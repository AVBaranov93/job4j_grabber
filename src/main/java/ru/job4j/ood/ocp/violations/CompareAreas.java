package ru.job4j.ood.ocp.violations;

public class CompareAreas {
    public static int compareArea(Square a, Square b) {
        return a.area() - b.area();
    }
}