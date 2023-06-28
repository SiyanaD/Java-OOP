package P02AnimalFarm;

public class Chicken {
    private String name;
    private int age;

    public Chicken(String name, int age) {
        setName(name);
       setAge(age);
    }

    private void setName(String name) {

        if (name.length()>0){
        this.name = name;}
        else {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
    }

    private void setAge(int age) {

        if (age>=0&&age<=15){
        this.age = age;}
        else {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
    }

    public double productPerDay (){
        //. The calculateProductPerDay() method is used by the productPerDay() public method. This
        //means the method can safely be hidden inside the Chicken class by declaring it private
        return calculateProductPerDay();

    }


    @Override
    public String toString() {

        return String.format("Chicken %s (age %d) can produce %.2f eggs per day.",this.name,this.age,this.productPerDay());
    }

    private double calculateProductPerDay(){

        //Chicken lives for 15 years. Chicken has a name for sure, at least 1 symbol long. Chicken producing eggs:
        //• First 6 years it produces 2 eggs per day [0 - 5].
        //• Next 6 years it produces 1 egg per day [6 - 11].
        //• And after that, it produces 0.75 eggs per day
        if (this.age>=0 && this.age<=5){
            return 2;
        } else if (this.age>=6 && this.age<=11) {
            return 1;
        }
        else {
            return 0.75;
        }
    }
}
