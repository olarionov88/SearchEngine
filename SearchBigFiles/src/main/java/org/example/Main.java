package org.example;

import java.util.*;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) {
        String command = args[0];
        int start = command.lastIndexOf(" ");
        double minSize = Double.valueOf(command.substring(start).trim()) * 1_048_576;
        String path = command.substring(0, start);

        TreeMap<Long, String> list = new ForkJoinPool().invoke(new SearchBigFiles(path, minSize));
        for (long number : list.descendingKeySet()) {
            System.out.println(getSize(number) + " " + list.get(number));
        }
    }

    public static double getSize(long length) {
        int power = (int) (Math.log(length) / Math.log(1024));
        double value = length / Math.pow(1024, power);
        double roundedValue = Math.round(value * 100) / 100.;
        return roundedValue;
    }
}
