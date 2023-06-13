package org.example;

import java.util.Arrays;
import java.util.Date;

import static org.example.Main.generateArray;

public class sort_comparator {
    public static void main(String[] args) {
        for (int i = 10_000; i < 100_000; i += 10_000) {
            int[] array = generateArray(i);
            Date start = new Date();
            Sortings.bubble(Arrays.copyOf(array, array.length));
            Date end = new Date();
            long diff = end.getTime() - start.getTime();
            System.out.println(diff);
            Date start2 = new Date();
            Sortings.quickSort(Arrays.copyOf(array, array.length), 0, array.length - 1);
            Date end2 = new Date();
            long diff2 = end2.getTime() - start2.getTime();
            System.out.println(diff2);
            System.out.println("*".repeat(10));
        }
    }
}
