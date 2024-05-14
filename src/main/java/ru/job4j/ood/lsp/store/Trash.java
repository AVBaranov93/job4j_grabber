package ru.job4j.ood.lsp.store;

import ru.job4j.ood.lsp.CheckDate;
import ru.job4j.ood.lsp.models.Food;

import java.util.ArrayList;
import java.util.List;

public class Trash extends AbstractStore {
    private List<Food> foods = new ArrayList<>();

    @Override
    public void add(Food food) {
        if (CheckDate.calculateRestDays(food) < 0) {
            foods.add(food);
        }
    }

    @Override
    public void addRestored(Food food) {
        if (CheckDate.calculateRestDays(food) > 0.95) {
            foods.add(food);
        }
    }

    @Override
    public List<Food> getAllProducts() {
        return foods;
    }

    @Override
    public void clear() {
        foods.clear();
    }
}
