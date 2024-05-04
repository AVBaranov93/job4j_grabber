package ru.job4j.ood.lsp.parking;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.parking.models.PassengerCar;
import ru.job4j.ood.lsp.parking.models.Truck;
import ru.job4j.ood.lsp.parking.models.Vehicle;

import static org.assertj.core.api.Assertions.assertThat;

class CarParkingTest {
    @Test
    void whenEnoughParkingPlacesThenParkTheVehicle() {
        Parking<Vehicle> parking = new CarParking(1, 3);
        parking.parkVehicle(new PassengerCar());
        parking.parkVehicle(new Truck(2));
        assertThat(parking.parkVehicle(new Truck(2))).isTrue();
    }

    @Test
    void whenNotEnoughParkingPlacesThenCantParkTheVehicle() {
        Parking<Vehicle> parking = new CarParking(1, 3);
        parking.parkVehicle(new PassengerCar());
        parking.parkVehicle(new Truck(2));
        assertThat(parking.parkVehicle(new Truck(3))).isFalse();
    }

}