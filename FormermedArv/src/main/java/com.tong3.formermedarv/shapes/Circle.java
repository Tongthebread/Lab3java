package com.tong3.formermedarv.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Circle extends FillableShape {

    private double diameter;

    public Circle(Boolean filled, double diameter,double x, double y, Color color) {
        super(filled, x, y, color);
        this.diameter = diameter;
    }
    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    @Override
    public void paint(GraphicsContext gc) {
        if (isFilled()){
            gc.setFill(getColor());
            gc.fillOval(getX(), getY(), diameter, diameter);
        }
        else {
            gc.setStroke(getColor());
            gc.strokeOval(getX(), getY(), diameter, diameter);
        }
    }

    @Override
    protected void constrain(
            double boxX, double boxY,
            double boxWidth, double boxHeight) {
        // If outside the box - calculate new dx and dy
        super.constrain(boxX, boxY, boxWidth, boxHeight);
        double dx = getDx(), dy = getDy();
        if (getX() < boxX) {
            dx = Math.abs(getDx());
        } else if (this.diameter + getX() > boxWidth) {
            dx = -Math.abs(getDx());
        }
        if (getY() < boxY) {
            dy = Math.abs(getDy());
        } else if (this.diameter + getY() > boxHeight) {
            dy = -Math.abs(getDy());
        }
        setVelocity(dx, dy);
    }

    @Override
    public String ToString() {
        return super.toString()+
                ", diameter = " + diameter;
    }
}
