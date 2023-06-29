package P04PizzaCalories;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {

        setToppingType(toppingType);
        setWeight(weight);
    }

    //If topping is not one of the provided types throw an exception with the message "Cannot place {name
    //of invalid argument} on top of your pizza."

    private void setToppingType(String toppingType) {
        if (toppingType.equals("Meat")||toppingType.equals("Veggies")
                || toppingType.equals("Cheese") ||toppingType.equals("Sauce")){
        this.toppingType = toppingType;
        }
        else {
            throw new IllegalArgumentException("Cannot place " + toppingType+ "on top of your pizza.");
        }

    }
    //If topping weight is outside of the range [1..50] throw an exception with the message "{Topping type
    //name} weight should be in the range [1..50].".

    private void setWeight(double weight) {
        if (weight>=1 && weight<=50){
        this.weight = weight;}
        else {
            throw new IllegalArgumentException( this.toppingType + " weight should be in the range [1..50].");
        }
    }
    public double calculateCalories(){
        double caloriesTopping=0;
        if (this.toppingType.equals("Meat")){
            caloriesTopping=1.2;
        } else if (this.toppingType.equals("Veggies")) {
            caloriesTopping=0.8;
        } else if (this.toppingType.equals("Cheese")) {
            caloriesTopping=1.1;
        } else if (this.toppingType.equals("Sauce")) {
            caloriesTopping=0.9;
        }
       return 2*this.weight*caloriesTopping;
    }
    }

