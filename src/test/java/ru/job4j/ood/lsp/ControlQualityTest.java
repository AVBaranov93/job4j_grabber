package ru.job4j.ood.lsp;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.models.Food;
import ru.job4j.ood.lsp.store.Shop;
import ru.job4j.ood.lsp.store.Store;
import ru.job4j.ood.lsp.store.Trash;
import ru.job4j.ood.lsp.store.Warehouse;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ControlQualityTest {
    @Test
    void whenThen() {
        LocalDate date = LocalDate.now();
        Food food = new Food("grin agro", date.plusDays(1), date.minusDays(5), 100, 10);
        Store<Food> shop = new Shop();
        Store<Food> trash = new Trash();
        Store<Food> warehouse = new Warehouse();
        ControlQuality controlQuality = new ControlQuality(List.of(shop, trash, warehouse));
        controlQuality.addFood(food);
        assertThat(shop.getAllProducts().get(0).getName()).isEqualTo("grin agro");
    }
}