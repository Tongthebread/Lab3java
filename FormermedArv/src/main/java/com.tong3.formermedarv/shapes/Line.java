package com.tong3.formermedarv.shapes;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Line extends Shape {

    private double x2, y2;

    public Line(double x, double y, double x2, double y2, Color color){
        super(x, y, color);
        this.x2 = x2;
        this.y2 = y2;
    }
    public Line(){
        super();
        this.x2 = 100;
        this.y2 = 100;
    }


    public double getX2() {
        return x2;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }

    public double getY2() {
        return y2;
    }

    public void setY2(double y2) {
        this.y2 = y2;
    }

    @Override
    protected void move(long elapsedTimeNs) {
        super.move(elapsedTimeNs);
        x2 += getDx() * elapsedTimeNs / BILLION;
        y2 += getDy() * elapsedTimeNs / BILLION;
    }
    @Override
    protected void constrain(
            double boxX, double boxY,
            double boxWidth, double boxHeight) {
        // If outside the box - calculate new dx and dy
        super.constrain(boxX, boxY, boxWidth, boxHeight);
        double dx = getDx(), dy = getDy();
        if (this.x2 < boxX) {
            dx = Math.abs(getDx());
        } else if (this.x2 > boxWidth) {
            dx = -Math.abs(getDx());
        }
        if (this.y2 < boxY) {
            dy = Math.abs(getDy());
        } else if (this.y2 > boxHeight) {
            dy = -Math.abs(getDy());
        }
        setVelocity(dx, dy);
    }
    @Override
    public void paint(GraphicsContext gc) {
        gc.setStroke(getColor());
        gc.strokeLine(getX(), getY(), x2, y2);
    }
    public String ToString() {
        return super.toString()+
                ", x2 = " + x2 +
                ", y2 = " + y2;
    }
}