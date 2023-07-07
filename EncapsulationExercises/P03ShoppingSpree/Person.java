package P03ShoppingSpree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Person {
    private String name;
    private double money;

    private List<Product> products;


    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        this.products =new ArrayList<>();

    }

    private void setName(String name) {
        //The name cannot be an empty string.
        // Be careful about white space in the name. - използваме trim()
        if (!name.trim().isEmpty()){
            this.name = name;}
        else {
            throw new IllegalArgumentException("Name cannot be empty");
        }

    }

    private void setMoney(double money) {
        //Money and cost cannot be a negative number
        if (money>0){
            this.money=money;
        }
        else {
            throw new IllegalArgumentException("Money cannot be negative");
        }

    }
    public void buyProduct (Product product){
        //Create a program in which each command corresponds to a person buying a product. If the person can afford a
        //product add it to his bag.
        if (this.money>product.getCost()){
            products.add(product);
            this.money-=product.getCost();
        }
        //If a person doesn’t have enough money, print an appropriate exception message:
        //"{Person name} can't afford {Product name}"
        else {
            String message =String.format(this.name+" can't afford " + product.getName());

            throw new IllegalArgumentException(message);
        }

    }

    public String getName() {
        return name;
    }

    //getter for List
    public List<Product> getProducts() {
        return Collections.unmodifiableList(this.products);
    }
}
