package ru.job4j.ood.dip.violations;

public class ShoppingMoll {
    private DebitCard debitCard;

    public ShoppingMoll(DebitCard debitCard) {
        this.debitCard = debitCard;
    }

    public void doPayment(int amount) {
        debitCard.doTransaction(amount);
    }
}
