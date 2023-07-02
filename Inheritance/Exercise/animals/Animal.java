package animals;

public class Animal {
    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age>=0){
        this.age = age;}
        else {
            throw new IllegalArgumentException("Invalid input!");
        }
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    //Each animal should have the functionality to produceSound()
    public String produceSound(){
        return null;

    }

    //To find the name of the class you can use this.getClass().getSimpleName() in toString()
    @Override
    public String toString() {
        return  String.format("%s%n" + "%s %d %s%n" + "%s"
                ,this.getClass().getSimpleName(),this.name,this.age,this.gender,this.produceSound());
    }
}
