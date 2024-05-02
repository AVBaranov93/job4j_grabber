package ru.job4j.ood.lsp.store;


import ru.job4j.ood.lsp.CheckDate;
import ru.job4j.ood.lsp.models.Food;

import java.util.ArrayList;
import java.util.List;

public class Shop extends AbstractStore {
    private List<Food> foods = new ArrayList<>();

    @Override
    public void add(Food food) {
        if (CheckDate.calculateRestDays(food) >= 0.25 && CheckDate.calculateRestDays(food) <= 0.75) {
            foods.add(food);
        } else if (CheckDate.calculateRestDays(food) > 0.75) {
            food.setPrice(food.getPrice() * 0.2);
            foods.add(food);
        }
    }

    @Override
    public List<Food> getAllProducts() {
        return foods;
    }

}
