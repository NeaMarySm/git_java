package org.example;

public class Sortings {

    public static void bubble(int[] numbers) {
        int count = numbers.length;
        while (count > 0) {
            for (int i = 1; i < numbers.length; i++) {
                if (numbers[i - 1] > numbers[i]) {
                    int temp = numbers[i];
                    numbers[i] = numbers[i - 1];
                    numbers[i - 1] = temp;
                }
            }
            count--;
        }
    }

    public void bubbleOptimized(int[] numbers) {
        boolean needSort;
        do {
            needSort = false;
            for (int i = 1; i < numbers.length; i++) {
                if (numbers[i - 1] > numbers[i]) {
                    int temp = numbers[i];
                    numbers[i] = numbers[i - 1];
                    numbers[i - 1] = temp;
                    needSort = true;
                }
            }
        }
        while (needSort);
    }

    public void directSort(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[minIndex] > numbers[j]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = numbers[i];
                numbers[i] = numbers[minIndex];
                numbers[minIndex] = temp;
            }
        }
    }

    public void insertSort(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] > numbers[j]) {
                    int tmp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = tmp;
                }
            }
        }
    }

    public static void quickSort(int[] array, int start, int end) {
        int left = start;
        int right = end;
        int pivot = array[(start + end) / 2];
        do {
            while (array[left] < pivot) {
                left++;
            }
            while (array[right] > pivot) {
                right--;
            }
            if(left<=right){
                if(left<right){
                    int temp = array[left];
                    array[left] = array[right];
                    array[right] = temp;
                }
                left++;
                right--;
            }
        }
        while (left <= right);
        if(left<end){
            quickSort(array, left, end);
        }
        if(right>start){
            quickSort(array, start, right);
        }
    }
    public void heapSort(){}

}
