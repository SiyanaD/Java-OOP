package robotService.entities.services;

import robotService.common.ConstantMessages;
import robotService.common.ExceptionMessages;
import robotService.entities.robot.Robot;
import robotService.entities.supplements.Supplement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public abstract class BaseService implements Service {
    //BaseService is a base class of any type of service and it should not be able to be instantiated. - abstract

    private String name;
    private int capacity;
    private Collection<Supplement> supplements;
    private Collection<Robot> robots;

    //A BaseService should take the following values upon initialization:
    //(String name, int capacity)
    public BaseService(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.supplements=new ArrayList<>();
        this.robots=new ArrayList<>();

    }

    @Override
    public String getName() {
        return name;
    }

    //o	If the name is null or whitespace, throw a NullPointerException with a message:
    //"Service name cannot be null or empty."
    //o	All names are unique.
    @Override
    public void setName(String name) {
        if (name==null || name.trim().equals("")){
            throw new NullPointerException(ExceptionMessages.SERVICE_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public Collection<Supplement> getSupplements() {
        return supplements;
    }

    //Adds a Robot in the Service if there is a capacity for it.
    //If there is not enough capacity to add the Robot in the Service,
    // throw an IllegalStateException with the following message:
    //•	"Not enough capacity for this robot."
    @Override
    public void addRobot(Robot robot) {
        if (this.getRobots().size()>=this.capacity){
            throw new IllegalStateException(ConstantMessages.NOT_ENOUGH_CAPACITY_FOR_ROBOT);
        }
        this.getRobots().add(robot);
    }

    //Removes a Robot from the Service
    @Override
    public void removeRobot(Robot robot) {
        this.getRobots().remove(robot);

    }

    //Adds a Supplements in the Service.
    @Override
    public void addSupplement(Supplement supplement) {
        this.getSupplements().add(supplement);

    }


    //The feeding() method feeds all robots in the Service.
    @Override
    public void feeding() {
        //взимаме списъка с роботи и всеки един робот трябва да се нахрани
        for (Robot robot : this.getRobots()) {
            robot.eating();//всеки един робот има функционалност eating()

        }

    }

    //Returns the sum of each supplement’s hardness in the Service.
    @Override
    public int sumHardness() {
        int sum = 0;
        for (Supplement supplement :this.getSupplements()) {
            sum+=supplement.getHardness();

        }
        return sum;
    }

    //Returns a String with information about the Service in the format below.
    //"{serviceName} {serviceType}:
    //Robots: {robotName1} {robotName2} {robotName3} ... / Robots: none
    //Supplements: {supplementsCount} Hardness: {sumHardness}"
    //Note: I remind you that there are two service types – MainService and SecondaryService.
    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s %s:%n",this.getName(),this.getClass().getSimpleName()));//this.getClass().getSimpleName() - {serviceType}
        sb.append("Robots: ");
        //none
        if (this.getRobots().isEmpty()){
            sb.append("none");
            sb.append(System.lineSeparator());
        }

        else {
            // Robots: {robotName1} {robotName2} {robotName3} - отпечатваме всеки един робот
            sb.append(this.getRobots().stream().map(Robot::getName).collect(Collectors.joining(" ")).trim());
            sb.append(System.lineSeparator());
        }

        // //Toys: {toysCount} Softness: {sumSoftness}"
        //        sb.append(String.format("Toys: %d Softness: %d",this.getToys().size(),this.sumSoftness()));
        //        //this.getToys().size() -  toysCount броя на играчките
        //        //this.sumSoftness() - дава сумата на софтнеса на всички игрчки

        //Supplements: {supplementsCount} Hardness: {sumHardness}"
        sb.append(String.format("Supplements: %d Hardness: %d",this.getSupplements().size(),this.sumHardness()));
        //this.getSupplements().size() - броя на добавките
        //this.sumHardness() - връща сумата

        return sb.toString().trim();
    }

    public void setSupplements(Collection<Supplement> supplements) {
        this.supplements = supplements;
    }

    @Override
    public Collection<Robot> getRobots() {
        return robots;
    }

    public void setRobots(Collection<Robot> robots) {
        this.robots = robots;
    }


}
