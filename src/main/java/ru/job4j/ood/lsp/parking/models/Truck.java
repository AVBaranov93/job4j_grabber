package ru.job4j.ood.lsp.parking.models;

public class Truck implements Vehicle {
    private int size;

    public Truck(int size) {
        this.size = size;
    }

    @Override
    public int getSize() {
        return this.size;
    }

}
