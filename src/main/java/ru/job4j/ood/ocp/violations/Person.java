package ru.job4j.ood.ocp.violations;

public class Person {
    private String name;
    private int age;

    public void workInTaxi(Toyota toyota) {
        if (toyota instanceof Chr) {
            toyota.getChrPassengers();
        } else {
            toyota.getPassengers();
        }
    }

    public static void main(String[] args) {
        new Person().workInTaxi(new Toyota());
    }
}
