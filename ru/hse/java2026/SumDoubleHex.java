package ru.hse.java2026;

import java.util.Scanner;

public class SumDoubleHex {
    static void main(String[] args) {
        double sum = 0;
        String numbers = String.join(" ", args);
        Scanner scaner = new Scanner(numbers);
        while (scaner.hasNext()){
            String token = scaner.next();
            try{
                double number = Double.parseDouble(token);
                sum += number;
            } catch (NumberFormatException e) {
                System.err.println("Ошибка: " + token + " не число");
                return;
            }
        }
        scaner.close();
        System.out.println(sum);
    }
}