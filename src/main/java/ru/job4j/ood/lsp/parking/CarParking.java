package ru.job4j.ood.lsp.parking;

import ru.job4j.ood.lsp.parking.models.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class CarParking implements Parking<Vehicle> {
    private int truckSeats;
    private int passengerCarSeats;
    private List<Vehicle> truckPlaces = new ArrayList<>();
    private List<Vehicle> passengerCarPlaces = new ArrayList<>();

    public CarParking(int trackSeats, int passengerCarSeats) {
        this.truckSeats = trackSeats;
        this.passengerCarSeats = passengerCarSeats;
    }

    @Override
    public boolean parkVehicle(Vehicle vehicle) {
        boolean isParking = false;
        if (vehicle.getSize() == 1 && passengerCarSeats > 0) {
            passengerCarPlaces.add(vehicle);
            isParking = true;
            passengerCarSeats--;
        } else if (vehicle.getSize() != 1 && truckSeats > 0) {
            truckPlaces.add(vehicle);
            isParking = true;
            truckSeats--;
        } else if (vehicle.getSize() != 1 && truckSeats == 0 && passengerCarSeats >= vehicle.getSize()) {
            passengerCarPlaces.add(vehicle);
            isParking = true;
            passengerCarSeats -= vehicle.getSize();
        }
        return isParking;
    }
}
