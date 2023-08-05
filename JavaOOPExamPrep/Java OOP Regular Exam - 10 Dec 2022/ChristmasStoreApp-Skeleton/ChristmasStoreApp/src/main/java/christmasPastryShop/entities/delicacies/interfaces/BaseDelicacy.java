package christmasPastryShop.entities.delicacies.interfaces;

import christmasPastryShop.common.ExceptionMessages;

public abstract class BaseDelicacy implements Delicacy{
    //BaseDelicacy is a base class for any type of Delicacy, and it should not be able to be instantiated. - abstract
    private String name;
    private double portion;
    private double price;

    public BaseDelicacy(String name, double portion, double price) {
        this.setName(name);
        this.setPortion(portion);
        this.setPrice(price);
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        //o	If the name is null or whitespace, throw an IllegalArgumentException
        // with the message "Name cannot be null or white space!"
        if (name==null || name.equals("")){
            throw new IllegalArgumentException(ExceptionMessages.INVALID_NAME);
        }
        this.name = name;
    }

    @Override
    public double getPortion() {
        return portion;
    }

    public void setPortion(double portion) {
        //o	If the portion is less or equal to 0, throw an IllegalArgumentException
        // with the message "Portion cannot be less or equal to zero!"
        if (portion<=0){
            throw new IllegalArgumentException(ExceptionMessages.INVALID_PORTION);
        }
        this.portion = portion;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        //o	If the price is less or equal to 0, throw an IllegalArgumentException with
        // the message "Price cannot be less or equal to zero!"
        if (price<=0){
            throw new IllegalArgumentException(ExceptionMessages.INVALID_PRICE);
        }
        this.price = price;
    }

    //Returns a String with information about each delicacy. The returned String must be in the following format:
    //"{current delicacy name}: {current portion - formatted to the second digit}g - {current price - formatted to the second digit}"
    @Override
    public String toString() {
        return String.format("%s: %.2fg - %.2f%n",this.name,this.portion,this.price);
    }
}
