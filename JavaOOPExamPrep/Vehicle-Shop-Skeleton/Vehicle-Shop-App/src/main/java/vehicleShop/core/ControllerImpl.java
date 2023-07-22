package vehicleShop.core;

import vehicleShop.common.ConstantMessages;
import vehicleShop.common.ExceptionMessages;
import vehicleShop.models.shop.Shop;
import vehicleShop.models.shop.ShopImpl;
import vehicleShop.models.tool.Tool;
import vehicleShop.models.tool.ToolImpl;
import vehicleShop.models.vehicle.Vehicle;
import vehicleShop.models.vehicle.VehicleImpl;
import vehicleShop.models.worker.FirstShift;
import vehicleShop.models.worker.SecondShift;
import vehicleShop.models.worker.Worker;
import vehicleShop.repositories.VehicleRepository;
import vehicleShop.repositories.WorkerRepository;

import java.util.List;
import java.util.stream.Collectors;

//Note: The ControllerImpl class SHOULD NOT handle exceptions!
// The tests are designed to expect exceptions, not messages! ->нетрябва да слагаме try catch
public class ControllerImpl implements Controller {

    private WorkerRepository workerRepository;//мястото за съхранение на работници
    private VehicleRepository vehicleRepository;//място за съхранение на превозни средства

    private int countMadeVehicle;//брой на направените коли

    //The constructor of ControllerImpl does not take any arguments.
    public ControllerImpl() {
        //поставяме нещата който сме добавили
        this.workerRepository = new WorkerRepository();
        this.vehicleRepository=new VehicleRepository();
        this.countMadeVehicle=0;
    }




    @Override
    public String addWorker(String type, String workerName) {

        Worker worker;//създаваме worker

        //If the worker is invalid (the type is not FirstShift or SecondShift), throw an IllegalArgumentException with the message:
        //"Worker type doesn't exist."
        //The method should return the following message if the worker has been added to the repository:
        //"Successfully added {workerType} with name {workerName}."
        if (type.equals("FirstShift")){
            worker = new FirstShift(workerName);
        } else if (type.equals("SecondShift")) {
            worker = new SecondShift(workerName);
        }
        else {
            throw new IllegalArgumentException(ExceptionMessages.WORKER_TYPE_DOESNT_EXIST);
        }
        workerRepository.add(worker);//съхраняваме в workerRepository създадения работник
        return String.format(ConstantMessages.ADDED_WORKER,type,workerName);
    }

    @Override
    public String addVehicle(String vehicleName, int strengthRequired) {
        //Creates a vehicle with the provided name and required strength and adds it to the corresponding repository.
        //The method should return the following message:
        //•	"Successfully added Vehicle: {vehicleName}."
        Vehicle vehicle = new VehicleImpl(vehicleName,strengthRequired);//създаваме ново превозно средство
        vehicleRepository.add(vehicle);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_VEHICLE,vehicleName);
    }

    @Override
    public String addToolToWorker(String workerName, int power) {
        //Creates a tool with the given power and adds it to the collection of the worker.
        //If the worker doesn't exist in the worker repository, throw an IllegalArgumentException with the message:
        //"The worker doesn't exist. You cannot add a tool."
        //The method should return the following message if the tool has been added to the worker:
        //"Successfully added tool with power {toolPower} to worker {workerName}."
        //1 Намираме работник с такова име
        Worker worker= workerRepository.findByName(workerName);
        if (worker==null){//не сме намерили работник с даденото име
            throw new IllegalArgumentException(ExceptionMessages.HELPER_DOESNT_EXIST);
        }
        //Ако има такъв раборник създаваме инструмент който има нов инструмент с дадената сила
        Tool tool = new ToolImpl(power);//създаваме инструмент с дадената сила
        worker.addTool(tool);//на worker добавяме инструмента с тази сила
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_TOOL_TO_WORKER,power,workerName);
    }

    @Override
    public String makingVehicle(String vehicleName) {
        //You should start making the given vehicle, by assigning workers which are almost ready:
        //•	The workers that you should select are the ones with strength above 70 units.
        //•	The suitable ones start working on the given vehicle.
        //•	If no workers are ready, throw IllegalArgumentException with the following message:
        //"There is no worker ready to start making."
        //•	After the work is done, you must return the following message, reporting whether the vehicle is done and
        // how many total tools were unfit in the process:
        //"Vehicle {vehicleName} is {done/not done}. {countBrokenTools} tool/s have been unfit while working on it!"
        //списък с работници със сила >70
        List<Worker> availableWorkers = workerRepository.getWorkers().stream().filter(worker -> worker.getStrength()>70).collect(Collectors.toList());
        if (availableWorkers.isEmpty()){
            throw new IllegalArgumentException(ExceptionMessages.NO_WORKER_READY);
        }

        //намираме превозно средство спрямо името
        Vehicle vehicle = vehicleRepository.findByName(vehicleName);//трябва да се изработи
        Shop shop = new ShopImpl();//магазин - making
        int brokenTools = 0;//счупените инструменти

        while (!availableWorkers.isEmpty()&&!vehicle.reached()){//!vehicle.reached() - докато автомобила не е направен

            Worker worker = availableWorkers.get(0);//от списъка с налични работници взимаме първия работник
            shop.make(vehicle,worker);
            brokenTools+=worker.getTools().stream().filter(Tool::isUnfit).count();

            //работника неможе да работи или няма сила или няма инструменти
            if (!worker.canWork()|| worker.getTools().stream().noneMatch(tool -> !tool.isUnfit())){
                availableWorkers.remove(worker);
            }
        }

        //•	After the work is done, you must return the following message, reporting whether the vehicle is done and
        // how many total tools were unfit in the process:
        //"Vehicle {vehicleName} is {done/not done}. {countBrokenTools} tool/s have been unfit while working on it!"

        if (vehicle.reached()){
            //готова кола
            countMadeVehicle++;

            return String.format(ConstantMessages.VEHICLE_DONE,vehicle.getName(),"done") +
                    String.format(ConstantMessages.COUNT_BROKEN_INSTRUMENTS,brokenTools);
        }
        else {

            return String.format(ConstantMessages.VEHICLE_DONE,vehicle.getName(),"not done") +
                    String.format(ConstantMessages.COUNT_BROKEN_INSTRUMENTS,brokenTools);

        }
    }

    @Override
    public String statistics() {
        //Returns information about making vehicles and workers:
        //"{countMadeVehicle} vehicles are ready!
        //Info for workers:
        //Name: {workerName1}, Strength: {workerStrength1}
        //Tools: {countTools} fit left"
        //…
        //"Name: {workerNameN}, Strength: {workerStrengthN}
        //Tools: {countTools} fit left"


        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%d vehicles are ready!",countMadeVehicle)).append(System.lineSeparator());
        sb.append("Info for workers:").append(System.lineSeparator());
        workerRepository.getWorkers().forEach(w->{
           sb.append(w.toString());//правим toString метод в BaseWorker
        });
        return sb.toString().trim();
    }
}
