package com.algorithms.sort;

public class BogoSort {

    public static void main(String[] args) {
        int[] array = {12, -4, 11, 56, 6};
        sort(array);
    }

    public static void sort(int[] array){
        int counter = 0;

        while(!Util.isSorted(array)){
            ++counter;
            shuffle(array);
        }

        System.out.println("the array is sorted after " + counter + " shuffle rounds");
    }

   public static void shuffle(int[] array){
       for(int i = array.length-1; i>=0; i--){
           int j = (int) (Math.random() * i);
           Util.swap(array, i, j);
       }
   }
}
