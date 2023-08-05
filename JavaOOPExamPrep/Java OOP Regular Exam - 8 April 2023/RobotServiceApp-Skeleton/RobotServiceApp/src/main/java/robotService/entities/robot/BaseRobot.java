package robotService.entities.robot;

import robotService.common.ExceptionMessages;

public abstract class BaseRobot implements Robot{
    //BaseRobot is a base class of any type of robot and it should not be able to be instantiated. - abstract
    private String name;
    private String kind;
    private int kilograms;
    private double price;

    public BaseRobot(String name, String kind, int kilograms, double price) {
        this.setName(name);
        this.setKind(kind);
        this.kilograms = kilograms;
       this.setPrice(price);
    }

    @Override
    public String getName() {
        return name;
    }

    //o	If the name is null or whitespace, throw a NullPointerException with a message:
    //"Robot name cannot be null or empty."
    @Override
    public void setName(String name) {
        if (name==null || name.trim().equals("")){
            throw new NullPointerException(ExceptionMessages.ROBOT_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public String getKind() {
        return kind;
    }

    //o	If the kind is null or whitespace, throw a NullPointerException with a message:
    //"Robot kind cannot be null or empty."
    public void setKind(String kind) {
        if (kind==null || kind.trim().equals("")){
            throw new NullPointerException(ExceptionMessages.ROBOT_KIND_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.kind = kind;
    }

    @Override
    public int getKilograms() {
        return kilograms;
    }

    public void setKilograms(int kilograms) {
        this.kilograms = kilograms;
    }

    @Override
    public double getPrice() {
        return price;
    }


    //o	If the price is below or equal to 0, throw an IllegalArgumentException with a message:
    // "Robot price cannot be below or equal to 0."
    public void setPrice(double price) {
        if (price<=0){
            throw new IllegalArgumentException(ExceptionMessages.ROBOT_PRICE_CANNOT_BE_BELOW_OR_EQUAL_TO_ZERO);
        }
        this.price = price;
    }

    //The eating() method increases the Robot’s kilograms.
    // Keep in mind that some kinds of Robot can implement the method differently.-ще е abstract защото котките ядат различно
    //правиме го abstract за да може всеки един от наследниците на котката да може да имплементира по този метод
    // и да имплементира по различен начин
    //т.е eating - ще държи по различен начин от класовете който се наследяват
    //Ако котките ядяха по еднакъв начин описваме поведението в метода public void eating() и НЕ го правим abstract
    @Override
    public abstract void eating();




}
