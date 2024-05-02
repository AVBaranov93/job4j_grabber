package ru.job4j.ood.lsp.store;

import ru.job4j.ood.lsp.models.Food;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractStore implements Store<Food> {
    private List<Food> foods = new ArrayList<>();

    @Override
    public void add(Food food) {
        foods.add(food);
    }

    @Override
    public List<Food> getAllProducts() {
        return foods;
    }

    @Override
    public Food findById(int id) {
        return foods.get(id);
    }

    @Override
    public Food delete(int id) {
        return foods.remove(id);
    }
}
