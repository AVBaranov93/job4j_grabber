package ru.job4j.ood.lsp.store;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.models.Food;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class TrashTest {
    @Test
    void whenThen() {
        LocalDate date = LocalDate.now();
        Food food = new Food("grin agro", date.minusDays(2), date.minusDays(1), 100, 10);
        Store<Food> store = new Trash();
        store.add(food);
        assertThat(store.getAllProducts().get(0).getName()).isEqualTo("grin agro");
    }
}