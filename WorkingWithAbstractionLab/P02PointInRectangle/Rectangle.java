package WorkingWithAbstractionLab.P02PointInRectangle;

public class Rectangle {
    private Point bottomLeft;
    private Point topRight;


    public Rectangle(Point bottomLeft, Point topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }

    public Point getBottomLeft() {
        return bottomLeft;
    }

    public void setBottomLeft(Point bottomLeft) {
        this.bottomLeft = bottomLeft;
    }

    public Point getTopRight() {
        return topRight;
    }

    public void setTopRight(Point topRight) {
        this.topRight = topRight;
    }
    public boolean contains(Point point){
        boolean isInHorizontal=
                this.bottomLeft.getX()<=point.getX() &&
                        this.topRight.getX()>=point.getX();
        boolean isInVertical = this.bottomLeft.getY()<=point.getY()&&
                this.topRight.getY()>=point.getY();
        boolean isInRectangle = isInHorizontal&&isInVertical;
        return isInRectangle;
    }
}
