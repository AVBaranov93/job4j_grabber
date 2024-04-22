package ru.job4j.srp.violations;

public class Product {
    int amount;
    Price price;

    public void setPrice(Price newPrice) {
        this.price = newPrice;
    }
    public void replenishAmount(int amount) {
        this.amount += amount;
    }
}
