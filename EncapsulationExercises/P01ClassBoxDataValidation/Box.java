package P01ClassBoxDataValidation;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
//когато правиме валидация на променливите на коструктора променяме this.height=height с  setHeight(height);
     setLength(length);
     setWidth(width);
     setHeight(height);

    }
    //A box’s side should not be zero or a negative number.
    // Add data validation for each parameter given to the
    //constructor. Make a private setter that performs data validation internally.

    private void setLength(double length) {
        if (length>0){
        this.length = length;}
        else {
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        }
    }

    private void setWidth(double width) {
        if (width>0){
        this.width = width;}
        else {
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }
    }

    private void setHeight(double height) {
        if (height>0){
        this.height = height;}
        else {
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        }
    }
    public double  calculateSurfaceArea (){

        return 2*this.length*this.width+2*this.length*this.height+2*this.width*this.height;
    }
    public double calculateLateralSurfaceArea (){
        return 2*this.length*this.height+2*this.width*this.height;
    }
    public double calculateVolume (){

        return this.length*this.width*this.height;
    }
}
