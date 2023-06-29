package P04PizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;

    public Pizza(String name, int numberOfToppings) {
        setName(name);
        setToppings(numberOfToppings);
    }
    //If the name of the pizza is empty, only whitespace or longer than 15 symbols throw an exception with the
    //message "Pizza name should be between 1 and 15 symbols.".
    private void setName(String name) {

        if (name.trim().length()>=1&&name.trim().length()<=15){
        this.name = name;}
    else {
        throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public String getName() {
        return name;
    }

    //If a number of toppings are outside of the range [0..10] throw an exception with the message "Number of
    //toppings should be in range [0..10].".
    private void setToppings(int count) {
        if (count>=0&&count<=10){
        this.toppings = new ArrayList<>(count);}

        else {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
    }
    public void addTopping (Topping topping){
        this.toppings.add(topping);
    }


    public double getOverallCalories (){

        //събираме всеки един типпинг от листа с топинги: this.toppings.stream().mapToDouble(t->t.calculateCalories()).sum()

        return this.dough.calculateCalories() + this.toppings.stream().mapToDouble(t->t.calculateCalories()).sum();

    }
}
