package animals;

public class Dog extends Animal{
    public Dog(String name, int age, String gender) {
        super(name, age, gender);
    }

    //the type of sound each animal should produce:
    // Dog: "Woof!"
    @Override
    public String produceSound() {
        return "Woof!";
    }
}
