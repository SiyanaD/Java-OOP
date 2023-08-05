package catHouse.entities.cat;

public class LonghairCat extends BaseCat{

    private static final int KILOGRAMS=9;
    //Has initial kilograms of 9.
    //Can only live in LongHouse!
    //The constructor should take the following values upon initialization:
    //(String name, String breed, double price)

    public LonghairCat(String name, String breed, double price) {
        super(name, breed, KILOGRAMS, price);
    }

  //•	The method increases the cat’s kilograms by 3
    @Override
    public void eating() {
        this.setKilograms(this.getKilograms()+3);

    }
}
