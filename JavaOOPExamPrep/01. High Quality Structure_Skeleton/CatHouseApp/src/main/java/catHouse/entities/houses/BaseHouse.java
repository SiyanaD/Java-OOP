package catHouse.entities.houses;

import catHouse.common.ConstantMessages;
import catHouse.common.ExceptionMessages;
import catHouse.entities.cat.Cat;
import catHouse.entities.toys.Toy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public abstract class BaseHouse implements House{
    private String name;
    private int capacity;
    private Collection<Toy> toys;
    private Collection<Cat> cats;

    //A BaseHouse should take the following values upon initialization:
    //(String name, int capacity)

    public BaseHouse(String name, int capacity) {
        this.setName(name);
        this.capacity = capacity;
        this.toys=new ArrayList<>();
        this.cats= new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    //o	If the name is null or whitespace, throw a NullPointerException with a message:
    //"House name cannot be null or empty."
    //o	All names are unique.
    @Override
    public void setName(String name) {
        if ((name==null || name.equals(""))){
            throw new NullPointerException(ExceptionMessages.HOUSE_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    //o	The number of Cat аn House can have
    public int getCapacity() {
        //брой на котките в къщата
        return this.cats.size();
    }


    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public Collection<Toy> getToys() {
        return this.toys;
    }

    public void setToys(Collection<Toy> toys) {
        this.toys = toys;
    }

    @Override
    public Collection<Cat> getCats() {
        return this.cats;
    }

    public void setCats(Collection<Cat> cats) {
        this.cats = cats;
    }

    //Returns the sum of each toy’s softness in the House.
    @Override
    public int sumSoftness() {

        int sum = 0;
        for (Toy toy :this.getToys()) {
            sum+=toy.getSoftness();
        }
        return sum;
    }

    //Adds a Cat in the House if there is a capacity for it.
    //If there is not enough capacity to add the Cat in the House, throw an IllegalStateException with the following message:
    //•	"Not enough capacity for this cat."
    @Override
    public void addCat(Cat cat) {

        //If there is not enough capacity to add the Cat in the House
        //this.getCats().size - взимаме броя на котките
        if (this.getCats().size()>=this.capacity){
            throw new IllegalStateException(ConstantMessages.NOT_ENOUGH_CAPACITY_FOR_CAT);
        }

        this.getCats().add(cat);


    }

    //Removes a Cat from the House.
    @Override
    public void removeCat(Cat cat) {
        this.getCats().remove(cat);

    }

    //Buy (adds) a Toy in the House.
    @Override
    public void buyToy(Toy toy) {
        //взимаме списъка с играчките this.getToys() и добавяме новата играчка toy
        this.getToys().add(toy);

    }

    //The feeding() method feeds all cats in the House
    @Override
    public void feeding() {
        //взимаме списъка с котките и всяка една котка трябва да я нахраним
        for (Cat cat : this.getCats()) {
            cat.eating();//всяка една котка има функционалност eating()
        }


    }

    //Returns a String with information about the House in the format below.
    //If the House doesn't have a cat, print "none" instead.
    //"{houseName} {houseType}:
    //Cats: {catName1} {catName2} {catName3} ... / Cats: none
    //Toys: {toysCount} Softness: {sumSoftness}"
    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%s %s:%n",this.getName(),this.getClass().getSimpleName()));//"{houseName}-this.getName(),{houseType}-this.getClass().getSimpleName()
        sb.append("Cats: ");
        // none
        if (this.getCats().isEmpty()){
            sb.append("none");
            sb.append(System.lineSeparator());
        }
        else {
            //{catName1} {catName2} {catName3}- отпечатваме всяка една котка
            sb.append(this.getCats().stream().map(Cat::getName).collect(Collectors.joining(" ")).trim());
            sb.append(System.lineSeparator());
        }
        //Toys: {toysCount} Softness: {sumSoftness}"
        sb.append(String.format("Toys: %d Softness: %d",this.getToys().size(),this.sumSoftness()));
        //this.getToys().size() -  toysCount броя на играчките
        //this.sumSoftness() - дава сумата на софтнеса на всички игрчки

        return sb.toString().trim();
    }
}
