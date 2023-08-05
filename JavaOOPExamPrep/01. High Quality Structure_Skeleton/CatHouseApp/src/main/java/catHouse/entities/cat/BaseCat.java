package catHouse.entities.cat;

import catHouse.common.ExceptionMessages;

public abstract class BaseCat implements Cat{

    private String name;

    private String breed;
    private int kilograms;
    private double price;

    public BaseCat(String name, String breed,int kilograms, double price) {
        this.setName(name);
       this.setBreed(breed);
        this.setPrice(price);
        this.setKilograms(kilograms);
    }

    @Override
    public String getName() {
        return name;
    }

    //o	If the name is null or whitespace, throw a NullPointerException with a message:
    //"Cat name cannot be null or empty."
    //o	All names are unique.
    @Override
    public void setName(String name) {
        if ((name==null || name.equals(""))){
            throw new NullPointerException(ExceptionMessages.CAT_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    //o	If the breed is null or whitespace, throw a NullPointerException with a message:
    //"Cat breed cannot be null or empty."
    public void setBreed(String breed) {
        if ((breed==null || breed.equals(""))){
            throw new NullPointerException(ExceptionMessages.CAT_BREED_CANNOT_BE_NULL_OR_EMPTY);

        }
        this.breed = breed;
    }

    //o	The kilograms of the Cat
    @Override
    public int getKilograms() {

        return this.kilograms;
    }

    public void setKilograms(int kilograms) {
        this.kilograms = kilograms;
    }

    @Override
    public double getPrice() {
        return price;
    }


    //o	The price of the Cat.
    //o	If the price is below or equal to 0, throw an IllegalArgumentException with a message:
    // "Cat price cannot be below or equal to 0."
    public void setPrice(double price) {
        if (price<=0){
            throw new IllegalArgumentException(ExceptionMessages.CAT_PRICE_CANNOT_BE_BELOW_OR_EQUAL_TO_ZERO);
        }

        this.price = price;
    }


    //The eating() method increases the Cat’s kilograms.
    // Keep in mind that some breeds of Cat can implement the method differently-ще е abstract защото котките ядат различно
    //правиме го abstract за да може всеки един от наследниците на котката да може да имплементира по този метод
    // и да имплементира по различен начин
    //т.е eating - ще държи по различен начин от класовете който се наследяват
    //Ако котките ядяха по еднакъв начин описваме поведението в метода public void eating() и НЕ го правим abstract
    @Override
    abstract public void eating();

}
