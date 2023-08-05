package christmasPastryShop.entities.cocktails.interfaces;

import christmasPastryShop.common.ExceptionMessages;

public abstract class BaseCocktail implements Cocktail {
    //BaseCocktail is a base class for any type of Cocktail and it should not be able to be instantiated - abstract
    private String name;
    private int size;
    private double price;
    private String brand;

    public BaseCocktail(String name, int size, double price, String brand) {
        this.setName(name);
        this.setSize(size);
        this.setPrice(price);
        this.setBrand(brand);
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
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        //o	If the size is less or equal to 0, throw an IllegalArgumentException
        // with the message "Size cannot be less or equal to zero!"
        if (size<=0){
            throw new IllegalArgumentException(ExceptionMessages.INVALID_SIZE);
        }
        this.size = size;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        //o	If the price is less or equal to 0, throw an IllegalArgumentException
        // with the message "Price cannot be less or equal to zero!"
        if (price<=0){
            throw new IllegalArgumentException(ExceptionMessages.INVALID_PRICE);
        }
        this.price = price;
    }

    @Override
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        //o	If the name is null or whitespace, throw an IllegalArgumentException
        // with the message "Brand cannot be null or white space!"
        if (name==null || name.equals("")){
            throw new IllegalArgumentException(ExceptionMessages.INVALID_BRAND);
        }
        this.brand = brand;
    }

    @Override
    public String toString() {
        //Returns a String with information about each cocktail. The returned String must be in the following format:
        //"{current cocktail name} {current brand name} - {current size}ml - {current price - formatted to the second digit}lv"
        return String.format("%s %s - %dml - %.2f%nlv",this.name,this.brand,this.size,this.price);
    }
}
