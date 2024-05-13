package ru.job4j.ood.dip.violations;

import java.util.List;

public class ShopService {
    private MemoryStore store;

    public void addProducts(List<Product> products) {
        for (Product product : products) {
            store.add(product);
        }
    }
}
