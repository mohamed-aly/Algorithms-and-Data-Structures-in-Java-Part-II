package com.algorithms.sort;

public class CountingSort {

    public static void main(String[] args) {
        int[] array = {12, 2, 11, 13, 6, 4, 10};
        CountingSort countingSort = new CountingSort(array);
        countingSort.countingSort(2, 13);
        Util.show(array);
    }

    private int[] array;

    public CountingSort(int[] array) {
        this.array = array;
    }

    public void countingSort(int min, int max) {
        int[] countingArray = new int[max - min + 1];

        for (int i = 0; i < this.array.length; i++) {
            countingArray[this.array[i] - min]++;
        }

        int z = 0;

        for (int i = 0; i < countingArray.length; i++) {
            while (countingArray[i] > 0) {
               this.array[z] = i + min;
               countingArray[i]--;
               z++;
            }
        }


    }
}
