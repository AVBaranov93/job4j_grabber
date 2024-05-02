package ru.job4j.ood.lsp.store;

import ru.job4j.ood.lsp.CheckDate;
import ru.job4j.ood.lsp.models.Food;

import java.util.ArrayList;
import java.util.List;

public class Warehouse extends AbstractStore {
    private List<Food> foods = new ArrayList<>();

    @Override
    public void add(Food food) {
        if (CheckDate.calculateRestDays(food) < 0.25) {
            foods.add(food);
        }
    }

    @Override
    public List<Food> getAllProducts() {
        return foods;
    }
}
