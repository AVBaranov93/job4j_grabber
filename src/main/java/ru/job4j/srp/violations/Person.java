package ru.job4j.srp.violations;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Person {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String serializePerson(Person person) {
        return new GsonBuilder().create().toJson(person);
    }
}
