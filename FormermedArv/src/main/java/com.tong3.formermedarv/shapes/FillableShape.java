package com.tong3.formermedarv.shapes;

import javafx.scene.paint.Color;

abstract public class FillableShape extends Shape {

    private Boolean filled;

    public FillableShape(Boolean filled, double x, double y, Color color) {
        super(x, y, color);
        this.filled = filled;
    }

    public boolean isFilled(){
        return filled;
    }
    public void setFilled(Boolean filled) {
        this.filled = filled;
    }

    public abstract String ToString();
}
