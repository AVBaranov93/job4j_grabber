package ru.job4j.ood.lsp;

import ru.job4j.ood.lsp.models.Food;

import java.time.Duration;
import java.time.LocalDate;

public class CheckDate {

    public static double calculateRestDays(Food food) {
        long expirationDate = Duration.between(food.getCreationDate().atStartOfDay(),
                food.getExpirationDate().atStartOfDay()).toDays();
        long remainingDays = Duration.between(LocalDate.now().atStartOfDay(),
                food.getExpirationDate().atStartOfDay()).toDays();
        return  remainingDays <= 0 ? -1 : (double) (expirationDate - remainingDays) / (double) expirationDate;
    }
}
