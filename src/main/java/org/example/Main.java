package org.example;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        Sortings sorter = new Sortings();
        Searching searcher = new Searching();
        int[] nums = generateArray(length);
        printArray(nums);
        System.out.println("_".repeat(10));
        sorter.heapSort(nums);
        printArray(nums);

//        int[] nums1 = generateArray(length);
//        printArray(nums1);
//        int[] nums2 = generateArray(length);
//        printArray(nums1);
//        sorter.bubble(nums);
//        sorter.directSort(nums1);
//        sorter.insertSort(nums2);
//        System.out.println();
//        printArray(nums);
//        System.out.println();
//        printArray(nums1);
//        System.out.println();
//        printArray(nums1);
//        System.out.println();
//        System.out.println(searcher.binarySearch(nums, 7));
//        System.out.println(searcher.binarySearch(nums, 0));
//        System.out.println(searcher.binarySearch(nums, 1));
    }

    public static int[] generateArray(int length){
        Random random = new Random();
        int[] result = new int[length];
        for (int i = 0; i < result.length; i++) {
            result[i] = random.nextInt(10);
        }
        return result;
    }
    public static void printArray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}