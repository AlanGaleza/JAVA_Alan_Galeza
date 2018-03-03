package com.kodilla.testing.shape;

import java.util.Objects;

import static java.lang.Math.PI;

public class Circle implements Shape {
    private String shapeName;
    private double radius;

    public Circle(int radius) {
        this.shapeName = "Circle";
        this.radius = radius;
    }

    @Override
    public boolean equals(Object o) {
        if (! (o instanceof Circle)) return false;
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return radius == circle.radius &&
                Objects.equals(shapeName, circle.shapeName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(shapeName, radius);
    }

    @Override
    public String getShapeName() {
        return shapeName;
    }

    @Override
    public double getField() { return radius * PI; }

    @Override
    public String toString() {
        return "Circle{" +
                "shapeName='" + shapeName + '\'' +
                ", field=" + radius +
                '}';
    }
}
