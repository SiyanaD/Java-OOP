package P04PizzaCalories;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;


    public Dough(String flourType, String bakingTechnique, double weight) {

        setFlourType(flourType);

        setBakingTechnique(bakingTechnique);

        setWeight(weight);
    }

    private void setFlourType(String flourType) {

        if (flourType.equals("White")||flourType.equals("Wholegrain")){
        this.flourType = flourType;}
        else {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    private void setBakingTechnique(String bakingTechnique) {

        if (bakingTechnique.equals("Crispy") || bakingTechnique.equals("Chewy") || bakingTechnique.equals("Homemade")){
        this.bakingTechnique = bakingTechnique;
        }
        else {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }
    //If dough weight is outside of the range [1..200]
    // throw an exception with the message
    // "Dough weight should be in the range [1..200].


    private void setWeight(double weight) {
        if (weight>=1&&weight<=200){
        this.weight = weight;}
        else {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
    }
    public double  calculateCalories (){

        double caloriesTypeFlour = 0;
        double caloriesBacking = 0;
        if (this.flourType.equals("White")){
            caloriesTypeFlour=1.5;
        } else if (this.flourType.equals("Wholegrain")) {
            caloriesTypeFlour=1.0;
        }
        if (this.bakingTechnique.equals("Crispy")){
            caloriesBacking=0.9;
        } else if (this.bakingTechnique.equals("Chewy")) {
            caloriesBacking=1.1;
        } else if (this.bakingTechnique.equals("Homemade")) {
            caloriesBacking=1.0;
            
        }
        return (2*weight)*caloriesTypeFlour*caloriesBacking;

    }
}
