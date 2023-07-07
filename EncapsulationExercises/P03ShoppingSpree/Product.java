package P03ShoppingSpree;

public class Product {
private String name;
private double cost;

    public Product(String name, double cost) {
              setName(name);
              setCost(cost);
    }

    private void setName(String name) {
        //The name cannot be an empty string. Be careful about white space in
        //the name.
        if (!name.trim().isEmpty()){
        this.name = name;}
        else {
            throw new IllegalArgumentException("Name cannot be empty");
        }

    }

    private void setCost(double cost) {
        //Money and cost cannot be a negative number
        if (cost>0){
        this.cost = cost;}
        else {
            throw new IllegalArgumentException("Money cannot be negative");
        }
    }

     public String getName(){
        return name;
}
    public double getCost() {
        return cost;
    }
}
