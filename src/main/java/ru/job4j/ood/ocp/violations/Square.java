package ru.job4j.ood.ocp.violations;

public class Square {
    private int height;

    public Square(int height) {
        this.height = height;
    }

    public int area() {
        return height * height;
    }
}