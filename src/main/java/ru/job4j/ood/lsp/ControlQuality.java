package ru.job4j.ood.lsp;

import ru.job4j.ood.lsp.models.Food;
import ru.job4j.ood.lsp.store.*;

import java.util.List;

public class ControlQuality {
    private List<Store<Food>> stores;

    public ControlQuality(List<Store<Food>> stores) {
        this.stores = stores;
    }

    public void addFood(Food food) {
        for (Store<Food> store : stores) {
            store.add(food);
        }
    }

    public void restore() {
        List<Food> foods = stores.stream()
                .flatMap(e -> e.getAllProducts().stream())
                .toList();
        for (Store<Food> store : stores) {
            store.clear();
            for (Food food : foods) {
                store.addRestored(food);
            }
        }
    }
}
