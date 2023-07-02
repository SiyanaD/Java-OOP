package animals;

public class Kitten extends Cat{
    //Kittens are "Female" and
    //Tomcats are "Male"
    //изтриваме по default gender който ни се задава в конструктора и заместваме с този по условието

    private static final String GENDER = "Female";
    public Kitten(String name, int age) {
        super(name, age, GENDER);

    }

    @Override
    public String produceSound() {
        return "Meow";
    }
}
