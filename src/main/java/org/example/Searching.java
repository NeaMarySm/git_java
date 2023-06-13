package org.example;

public class Searching {

    public int binarySearch(int[] array, int val){
        return binarySearch(array, val, 0, array.length-1);
    }

    /**
     * @apiNote binary search using recursion
     * @param array unsorted array
     * @param val target value
     * @param min array start value
     * @param max array last value
     * @return index of target element
     */
    public int binarySearch(int[] array, int val, int min, int max) {
        int midpoint;
        if (min > max) {
            return -1;
        } else {
            midpoint = (max - min) / 2 + min;
        }
        if (array[midpoint] == val) {
            return midpoint;
        } else if (midpoint > val) {
            return binarySearch(array, val, min, midpoint - 1);
        } else {
            return binarySearch(array, val, midpoint + 1, max);
        }
    }

}
