package p04FoodShortage;

public class Rebel implements Buyer,Person {
    private String name;
    private int age;
    private String group;
    private int food;

    public Rebel(String name, int age, String group) {
        this.name = name;
        this.age = age;
        this.group = group;
        this.food=0;
    }

    //. Implement the Buyer interface in the Citizen and Rebel class, both Rebels and Citizens
    //start with 0 food, when a Rebel buys food his food increases by 5, when a Citizen buys food his food increases by
    //10
    @Override
    public void buyFood() {
        this.food+=5;

    }

    @Override
    public int getFood() {
        return food;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    public String getGroup() {
        return group;
    }
}
