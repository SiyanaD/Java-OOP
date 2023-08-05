package catHouse.core;

import catHouse.common.ConstantMessages;
import catHouse.common.ExceptionMessages;
import catHouse.entities.cat.Cat;
import catHouse.entities.cat.LonghairCat;
import catHouse.entities.cat.ShorthairCat;
import catHouse.entities.houses.House;
import catHouse.entities.houses.LongHouse;
import catHouse.entities.houses.ShortHouse;
import catHouse.entities.toys.Ball;
import catHouse.entities.toys.Mouse;
import catHouse.entities.toys.Toy;
import catHouse.repositories.ToyRepository;

import java.util.ArrayList;
import java.util.Collection;

public class ControllerImpl implements Controller{

    //Note: The ControllerImpl class SHOULD NOT handle exceptions! The tests are designed to expect exceptions, not messages!
    //трябва да имаме throw new ....


    //You need some private fields in your controller class:
    private ToyRepository toys;//съвкупност от играчки
    private Collection<House> houses;//съвкупност от къщи



    //The constructor of ControllerImpl does not take any arguments
    public ControllerImpl() {
        this.toys=new ToyRepository();//задаваме празен съвкупност от играчки
        this.houses = new ArrayList<>();//празен array list

    }


    //Functionality
    //Creates and adds a House to the houses’ collection. Valid types are: "ShortHouse" and "LongHouse".
    //If the House type is invalid, you have to throw a NullPointerException with the following message:
    //•	"Invalid house type."
    //If the House is added successfully, the method should return the following String:
    //•	"{houseType} is successfully added."

    @Override
    public String addHouse(String type, String name) {
        House house = null;//Creates and adds a House to the houses’ collection
        if (type.equals("ShortHouse")){
            house=new ShortHouse(name);
            houses.add(house);
        }
        else if (type.equals("LongHouse")) {
            house=new LongHouse(name);
            houses.add(house);
        }
        else {
            throw new NullPointerException(ExceptionMessages.INVALID_HOUSE_TYPE);
        }
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_HOUSE_TYPE,type);
    }


    //Functionality
    //Creates a toy of the given type and adds it to the ToyRepository. Valid types are: "Ball" and "Mouse".
    // If the toy type is invalid, throw an IllegalArgumentException with a message:
    //•	"Invalid toy type."
    //The method should return the following string if the operation is successful:
    //•	"{toyType} is successfully added."
    @Override
    public String buyToy(String type) {
        Toy toy;//Creates a toy of the given type and adds it to the ToyRepository.
        if (type.equals("Ball")){
            toy=new Ball();
            toys.buyToy(toy);
        }
        else if (type.equals("Mouse")) {
            toy=new Mouse();
            toys.buyToy(toy);
        }
        else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_TOY_TYPE);
        }
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_TOY_TYPE,type);
    }

    //Functionality
    //Adds (buys) the desired Toy to the House with the given name. You have to remove the Toy from the ToyRepository if the insert is successful.
    //If there is no such toy, you have to throw an IllegalArgumentException with the following message:
    //•	"Toy of type {toyType} is missing."
    //If no exceptions are thrown, return the String:
    //•	"Successfully added {toyType} to {houseName}."
    @Override
    public String toyForHouse(String houseName, String toyType) {

        //взимам играчката
        Toy toy = this.toys.findFirst(toyType);

        if (toy==null){
            throw  new IllegalArgumentException(String.format(ExceptionMessages.NO_TOY_FOUND,toyType));
        }
        //Adds (buys) the desired Toy to the House with the given name. You have to remove the Toy from the ToyRepository if the insert is successful.
        //купуваме играчката за къщата и след това я премахваме
        else {

            //getHouseByName() - правим метод
            House house = getHouseByName(houseName);
            house.buyToy(toy);
            this.toys.removeToy(toy);
        }
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_TOY_IN_HOUSE,toyType,houseName);
    }

    private House getHouseByName(String houseName) {
        //връща къща от списъка по име
       return this.houses.stream().filter(h->h.getName().equals(houseName)).findFirst().get();//.get()-взима и връша цялата къща
    }

    //Creates and adds the desired Cat to the House with the given name. Valid Cat types are: "ShorthairCat", "LonghairCat".
    //Note: The method must first check whether the cat type is valid.
    //If the Cat type is invalid, you have to throw an IllegalArgumentException with the following message:
    //•	"Invalid cat type."
    //If no errors are thrown, return one of the following strings:
    //•	"Unsuitable house." - if the given Cat cannot live in the House.
    //•	"Successfully added {catType} to {houseName}." - if the Cat is added successfully in the House.
    @Override
    public String addCat(String houseName, String catType, String catName, String catBreed, double price) {

        //създавам котка по нейния catType и catName
        Cat cat;
        //Note: The method must first check whether the cat type is valid.
        //след като проверим cat type дали е валиден създаваме котката
        switch (catType){
            case "ShorthairCat":
                cat = new ShorthairCat(catName,catType,price);
                break;
            case "LonghairCat" :
                cat = new LonghairCat(catName,catType,price);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_CAT_TYPE);
        }
        //House with the given name
        //манираме къща с даденото име
        House house = getHouseByName(houseName);

        // добавяме котката в къщата
        //ShorthairCat - ShortHouse
        //LonghairCat - LongHouse
        if (catType.startsWith("Short")&&house.getClass().getSimpleName().startsWith("Short")){
            house.addCat(cat);


        }
        else if (catType.startsWith("Long")&&house.getClass().getSimpleName().startsWith("Long")) {
            house.addCat(cat);

        }
        else {
        return ConstantMessages.UNSUITABLE_HOUSE;
        }


        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_CAT_IN_HOUSE,catType,houseName);
    }

    //Feeds all Cat in the House with the given name.
    //Returns a string with information about how many cats were successfully fed, in the following format:
    //•	"Feeding a cat: {fedCount}"
    @Override
    public String feedingCat(String houseName) {
        //взима къщата с име houseName
        House house = getHouseByName(houseName);
        house.feeding();
        return String.format(ConstantMessages.FEEDING_CAT,house.getCats().size());//house.getCats().size()- броя на котките
    }

    //Calculates the value of the House with the given name. It is calculated by the sum of all Cat’s and Toy’s prices in the House.
    //Return a string in the following format:
    //•	"The value of House {houseName} is {value}."
    //o	The value should be formatted to the 2nd decimal place!
    @Override
    public String sumOfAll(String houseName) {
        House house = getHouseByName(houseName);//взимаме къща с даденот име
        //It is calculated by the sum of all Cat’s and Toy’s prices in the House.
        double priceCats = house.getCats().stream().mapToDouble(Cat::getPrice).sum();//сума от всички котки
        double priceToys = house.getToys().stream().mapToDouble(Toy::getPrice).sum();//сума от всички играчки
        double priceAll = priceCats +priceToys;
        return String.format(ConstantMessages.VALUE_HOUSE,houseName,priceAll);
    }

    //Returns information about each house. You can use House's getStatistics method to implement the current functionality.
    //"{houseName} {houseType}:
    //Cats: {catName1} {catName2} {catName3} ... / Cats: none
    //Toys: {toysCount} Softness: {sumSoftness}"
    //"{houseName} {houseType}:
    //Cats: {catName1} {catName2} {catName3} ... / Cats: none
    //Toys: {toysCount} Softness: {sumSoftness}"
    //..."
    @Override
    public String getStatistics() {

        StringBuilder sb = new StringBuilder();
        for (House house :this.houses) {
            sb.append(house.getStatistics()).append(System.lineSeparator());

        }

        return sb.toString().trim();
    }
}
