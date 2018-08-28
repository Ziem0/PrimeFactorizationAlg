package com.algorithms.primeF;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class PrimeFactorio {

    private int number;
    Predicate<Integer> isPrimary = (i) -> {
        for (int x = 2; x < i; x++) {
            if (i % x == 0) {
                return false;
            }
        }
        return true;
    };

    public PrimeFactorio(int number) {
        this.number = number;
    }

    private List<Integer> calculate() {
        List<Integer> result = new ArrayList<>();

        while (number != 1) {
            for (int i = 2; i <= number; i++) {
                if (isPrimary.test(i) && number % i == 0) {
                    result.add(i);
                    number /= i;
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        for (String s : args) {
            PrimeFactorio primeFactorio = new PrimeFactorio(Integer.valueOf(s));
            System.out.println("Prime factorization for number: " + primeFactorio.number + " is " + primeFactorio.calculate()+"\n");
        }
    }
}
