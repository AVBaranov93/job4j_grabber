package ru.job4j.ood.lsp.models;

import java.time.LocalDate;

public class Food {
    private String name;
    private LocalDate expirationDate;
    private LocalDate creationDate;
    private double price;
    private double discount;

    public Food() {
    }

    public Food(String name, LocalDate expirationDate, LocalDate creationDate,
                double price, double discount) {
        this.name = name;
        this.expirationDate = expirationDate;
        this.creationDate = creationDate;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Food{"
                + "name='" + name + '\''
                + ", expirationDate=" + expirationDate
                + ", creationDate=" + creationDate
                + ", price=" + price
                + ", discount=" + discount
                + '}';
    }
}
