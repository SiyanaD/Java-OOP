package robotService.core;

import robotService.common.ConstantMessages;
import robotService.common.ExceptionMessages;
import robotService.entities.robot.FemaleRobot;
import robotService.entities.robot.MaleRobot;
import robotService.entities.robot.Robot;
import robotService.entities.services.MainService;
import robotService.entities.services.SecondaryService;
import robotService.entities.services.Service;
import robotService.entities.supplements.MetalArmor;
import robotService.entities.supplements.PlasticArmor;
import robotService.entities.supplements.Supplement;
import robotService.repositories.SupplementRepository;

import java.util.ArrayList;
import java.util.Collection;

public class ControllerImpl implements Controller{
    private SupplementRepository supplements;
    private Collection<Service> services;

    //създаваме празен конструктор
    public ControllerImpl() {
        this.supplements = new SupplementRepository();//създаваме празен съвкупност от добавки
        this.services = new ArrayList<>();//празен array list
    }

    @Override
    public String addService(String type, String name) {
        //Creates and adds a Service to the services’ collection. Valid types are: "MainService" and "SecondaryService".
        //If the Service type is invalid, you have to throw a NullPointerException with the following message:
        //•	"Invalid service type."
        //If the Service is added successfully, the method should return the following String:
        //•	"{serviceType} is successfully added."

        Service service =null; //Creates and adds a Service to the services’ collection.
        if (type.equals("MainService")){
            service=new MainService(name);
            services.add(service);
        }
        else if (type.equals("SecondaryService")) {
            service=new SecondaryService(name);
            services.add(service);
        }
        else {
            throw new NullPointerException(ExceptionMessages.INVALID_SERVICE_TYPE);
        }
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_SERVICE_TYPE,type);
    }

    @Override
    public String addSupplement(String type) {
        //Creates a supplement of the given type and adds it to the SupplementRepository.
        // Valid types are: "PlasticArmor" and "MetalArmor". If the supplement type is invalid, throw an IllegalArgumentException with a message:
        //•	"Invalid supplement type."
        //The method should return the following string if the operation is successful:
        //•	"{supplementType} is successfully added."

        Supplement supplement;//Creates a supplement of the given type and adds it to the SupplementRepository.
        if (type.equals("PlasticArmor")){
            supplement=new PlasticArmor();
            supplements.addSupplement(supplement);
        }
        else if (type.equals("MetalArmor")) {
            supplement=new MetalArmor();
            supplements.addSupplement(supplement);
        }
        else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_SUPPLEMENT_TYPE);
        }

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_SUPPLEMENT_TYPE,type);
    }



    @Override
    public String supplementForService(String serviceName, String supplementType) {
        //Adds the desired Supplement to the Service with the given name.
        // You have to remove the Supplement from the SupplementRepository if the insert is successful.
        //If there is no such supplement, you have to throw an IllegalArgumentException with the following message:
        //•	"Supplement of type {supplementType} is missing."
        //If no exceptions are thrown, return the String:
        //•	"Successfully added {supplementType} to {serviceName}."
        //взимам добавката
        Supplement supplement = this.supplements.findFirst(supplementType);
        if (supplement==null){
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_SUPPLEMENT_FOUND,supplementType));
        }
        else {
            //getServiceByName - правим метод
            Service service = getServiceByName(serviceName);
        }

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_SUPPLEMENT_IN_SERVICE,supplementType,serviceName);
    }

    private Service getServiceByName(String serviceName) {
        return this.services.stream().filter(s->s.getName().equals(serviceName)).findFirst().get();//.get()-взима и връша цялата къща
    }

    @Override
    public String addRobot(String serviceName, String robotType, String robotName, String robotKind, double price) {
        //Creates and adds the desired Robot to the Service with the given name. Valid Robot types are: "MaleRobot", "FemaleRobot".
        //Note: The method must first check whether the robot type is valid.
        //If the Robot type is invalid, you have to throw an IllegalArgumentException with the following message:
        //•	"Invalid robot type."
        //If no errors are thrown, return one of the following strings:
        //•	"Unsuitable service." - if the given Robot cannot live in the Service.
        //For reference: check their description from Task 1.
        //•	"Successfully added {robotType} to {serviceName}." - if the Robot is added successfully in the Service.

        //създававе робот с негорвите robotType Robot types are: "MaleRobot", "FemaleRobot". и robotName
        Robot robot;
        //Note: The method must first check whether the robot type is valid.
        //след като проверим robotType дали е валиден създаваме робота
        switch (robotType){
            case"MaleRobot":
                robot = new MaleRobot(robotName,robotKind,price);

                break;
            case "FemaleRobot":
                robot = new FemaleRobot(robotName,robotKind,price);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_ROBOT_TYPE);
        }
        //Намираме Service  с да денот име
        Service service = getServiceByName(serviceName);
        //добавяме робота към service
        //MainService - MaleRobot
        //SecondaryService - FemaleRobot
        if (robotType.startsWith("Male") && services.getClass().getSimpleName().startsWith("Main")){
            service.addRobot(robot);
        }
        else if (robotType.startsWith("Female") && services.getClass().getSimpleName().startsWith("Secondary")) {
            service.addRobot(robot);
        }
        else {
            return ConstantMessages.UNSUITABLE_SERVICE;
        }
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_ROBOT_IN_SERVICE,robotType,serviceName);
    }

    @Override
    public String feedingRobot(String serviceName) {
        //Feeds all Robot in the Service with the given name.
        //Returns a string with information about how many robots were successfully fed, in the following format:
        //•	"Robots fed: {fedCount}"

        //взимаме service  с име serviceName
        Service service = getServiceByName(serviceName);
        service.feeding();
        return String.format(ConstantMessages.FEEDING_ROBOT,service.getRobots().size());//service.getRobots().size() - броя на роботите
    }

    @Override
    public String sumOfAll(String serviceName) {
        //Calculates the value of the Service with the given name.
        // It is calculated by the sum of all Robot and Supplement prices in the Service.
        //Return a string in the following format:
        //•	"The value of service {serviceName} is {value}."
        //o	The value should be formatted to the 2nd decimal place!
        Service service = getServiceByName(serviceName);//взимаме Service  с даден робот
        // It is calculated by the sum of all Robot and Supplement prices in the Service.
        double priceRobot = service.getRobots().stream().mapToDouble(Robot::getPrice).sum();//sum на всички роботи
        double priceSupplement = service.getSupplements().stream().mapToDouble(Supplement::getPrice).sum();//sum на всички Supplement
        double priceAll = priceRobot+priceSupplement;
       return String.format(ConstantMessages.VALUE_SERVICE,serviceName,priceAll);
    }

    @Override
    public String getStatistics() {
        //Returns information about each service. You can use Service's getStatistics method to implement the current functionality.
        //"{serviceName} {serviceType}:
        //Robots: {robotName1} {robotName2} {robotName3} ... / Robots: none
        //Supplements: {supplementsCount} Hardness: {sumHardness}"
        //"{serviceName} {serviceType}:
        //Robots: {robotName1} {robotName2} {robotName3} ... / Robots: none
        //Supplements: {supplementsCount} Hardness: {sumHardness}"
        //..."

        StringBuilder sb = new StringBuilder();
        for (Service service : this.services) {
            sb.append(service.getStatistics()).append(System.lineSeparator());

        }
        return sb.toString().trim();
    }
}
