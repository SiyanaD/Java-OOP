package catHouse.entities.cat;

public class ShorthairCat extends BaseCat {

    private static final int KILOGRAMS =7;

    //Has initial kilograms of 7.
    //Can only live in ShortHouse!
    //The constructor should take the following values upon initialization:
    //(String name, String breed, double price)

    public ShorthairCat(String name, String breed, double price) {
        super(name, breed,KILOGRAMS, price);
    }

    //•	The method increases the cat’s kilograms by 1
    @Override
    public void eating() {
      //взимаме до моментните килограми и добавяме 1
        this.setKilograms(this.getKilograms()+1);
    }

}
