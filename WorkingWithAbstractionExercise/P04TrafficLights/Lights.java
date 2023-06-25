package WorkingWithAbstractionExercise.P04TrafficLights;

public class Lights {

    private Color color;

    public Lights(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    //сменяме цвета
    //red -> green -> yellow -> red
    public void  changeColor(){
        if (getColor()==Color.RED){
            setColor(Color.GREEN);
        }
        else if (getColor()==Color.GREEN) {
            setColor(Color.YELLOW);
        } else if (getColor()==Color.YELLOW) {
            setColor(Color.RED);
        }
    }
}
