package ru.job4j.ood.dip.violations;

import java.util.ArrayList;
import java.util.List;

public class MemoryStore {
    private List<Product> products = new ArrayList<>();

    public void add(Product product) {
        products.add(product);
    }

    public List<Product> getAllProducts() {
        return products;
    }
}
