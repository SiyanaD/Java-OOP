package christmasPastryShop.entities.booths.interfaces;

import christmasPastryShop.common.ExceptionMessages;
import christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import christmasPastryShop.entities.delicacies.interfaces.Delicacy;

import java.util.ArrayList;
import java.util.Collection;

public abstract class BaseBooth implements Booth{
    //BaseBooth is a base class for different types of booths and should not be able to be instantiated. - abstract
    private Collection<Delicacy> delicacyOrders;
    private Collection<Cocktail> cocktailOrders;
    private int boothNumber;
    private int capacity;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReserved;
    private double price;

    //Constructor
    //A BaseBooth should take the following values upon initialization:
    //int boothNumber, int capacity, double pricePerPerson
    public BaseBooth(int boothNumber, int capacity, double pricePerPerson) {
        this.boothNumber = boothNumber;
        this.setCapacity(capacity);
        this.pricePerPerson = pricePerPerson;
        this.delicacyOrders=new ArrayList<>();
        this.cocktailOrders=new ArrayList<>();
        //•	isReserved – boolean returns true if the booth is reserved, otherwise false
        this.isReserved=false;
        //•	price – double calculates the price for all people.
        this.price=0;

    }

    public Collection<Delicacy> getDelicacyOrders() {
        return delicacyOrders;
    }

    public void setDelicacyOrders(Collection<Delicacy> delicacyOrders) {
        this.delicacyOrders = delicacyOrders;
    }

    public Collection<Cocktail> getCocktailOrders() {
        return cocktailOrders;
    }

    public void setCocktailOrders(Collection<Cocktail> cocktailOrders) {
        this.cocktailOrders = cocktailOrders;
    }

    @Override
    public int getBoothNumber() {
        return boothNumber;
    }

    public void setBoothNumber(int boothNumber) {
        this.boothNumber = boothNumber;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        //o	 It can’t be less than zero. In these cases,
        // throw an IllegalArgumentException with the message "Capacity has to be greater than 0!"
        if (capacity<0){
            throw new IllegalArgumentException(ExceptionMessages.INVALID_TABLE_CAPACITY);
        }
        this.capacity = capacity;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        //Cannot be less or equal to 0. In these cases,
        // throw an IllegalArgumentException with message "Cannot place zero or less people!"
        if (numberOfPeople<=0){
            throw new IllegalArgumentException(ExceptionMessages.INVALID_NUMBER_OF_PEOPLE);
        }
        this.numberOfPeople = numberOfPeople;
    }

    public double getPricePerPerson() {
        return pricePerPerson;
    }

    public void setPricePerPerson(double pricePerPerson) {
        this.pricePerPerson = pricePerPerson;
    }

    @Override
    public boolean isReserved() {
        return isReserved;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void reserve(int numberOfPeople) {
        //Reserve the booth with the count of people given and calculate the price of the booth.
        this.setNumberOfPeople(numberOfPeople);
        isReserved=true;
        this.price=this.pricePerPerson*numberOfPeople;


    }

    @Override
    public double getBill() {
        //Returns the bill for the booth, all of the ordered cocktails and delicacies
       double bill = 0;
       bill+=this.delicacyOrders.stream().mapToDouble(Delicacy::getPrice).sum();
       bill+=this.cocktailOrders.stream().mapToDouble(Cocktail::getPrice).sum();
       bill+=this.getPrice();
       return bill;
    }

    @Override
    public void clear() {
        //Removes all the ordered cocktails and delicacies and finally frees the booth, sets the count of people and price to 0.
        isReserved=false;
        this.delicacyOrders.clear();
        this.cocktailOrders.clear();
        this.numberOfPeople=0;
        this.price=0;

    }

    public void setPrice(double price) {
        this.price = price;
    }
}
