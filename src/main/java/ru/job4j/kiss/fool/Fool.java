package ru.job4j.kiss.fool;

import java.util.Scanner;

public class Fool {
    public static void main(String[] args) {
        System.out.println("Игра FizzBuzz.");
        var startAt = 1;
        var input = new Scanner(System.in);
        while (startAt < 100) {
            System.out.println(fizzBuzz(startAt));
            startAt++;
            var answer = input.nextLine();
            if (!fizzBuzz(startAt).equals(answer)) {
                System.out.println("Ошибка. Начинай снова.");
                startAt = 0;
            }
            startAt++;
        }
    }

    private static String fizzBuzz(int number) {
        return number % 3 == 0 ? (number % 5 == 0 ? "FizzBuzz" : "Fizz")
                : (number % 5 == 0 ? "Buzz" : String.valueOf(number));
    }

}