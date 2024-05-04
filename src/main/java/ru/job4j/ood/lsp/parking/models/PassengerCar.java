package ru.job4j.ood.lsp.parking.models;

public class PassengerCar implements Vehicle {

    private static final int SIZE = 1;

    @Override
    public int getSize() {
        return SIZE;
    }
}
