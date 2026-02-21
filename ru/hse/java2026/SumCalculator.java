package ru.hse.java2026;

import java.util.Scanner;

public class SumCalculator{
    static void main(String[] args) {
        int sum = 0;
        String numbers = String.join(" ", args);
        Scanner scaner = new Scanner(numbers);
        while (scaner.hasNext()){
            String token = scaner.next();
            try{
                int number = Integer.parseInt(token);
                sum += number;
            } catch (NumberFormatException e){
                System.err.println("Ошибка: " + token + " не число");
                return;
            }

        }
        scaner.close();
        System.out.println(sum);
         }





}

