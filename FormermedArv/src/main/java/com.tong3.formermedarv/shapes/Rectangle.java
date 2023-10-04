package com.tong3.formermedarv.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rectangle extends FillableShape {

    private double width, height;
    public Rectangle(Boolean filled, double x, double y, Color color, double width, double height) {
        super(filled, x, y, color);
        this.width = width;
        this.height = height;
    }
    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
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
        } else if (this.width + getX() > boxWidth) {
            dx = -Math.abs(getDx());
        }
        if (getY() < boxY) {
            dy = Math.abs(getDy());
        } else if (this.height + getY() > boxHeight) {
            dy = -Math.abs(getDy());
        }
        setVelocity(dx, dy);
    }

    @Override
    public void paint(GraphicsContext gc) {
        if (isFilled()){
            gc.setFill(getColor());
            gc.fillRect(getX(), getY(),width, height);
        }
        else {
            gc.setStroke(getColor());
            gc.strokeRect(getX(), getY(), width, height);
        }
    }
    @Override
    public String ToString() {
        return super.toString()+
                ", width = " + width +
                ", height = " + height;
    }
}
