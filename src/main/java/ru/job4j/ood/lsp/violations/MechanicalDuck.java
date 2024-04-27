package ru.job4j.ood.lsp.violations;

public class MechanicalDuck extends Duck {
    @Override
    public void fly() {
        System.out.println("mechanical duck cant't fly");
    }
}
