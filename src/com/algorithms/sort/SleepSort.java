package com.algorithms.sort;

import java.util.concurrent.CountDownLatch;

public class SleepSort {

    public static void main(String[] args) {
        int[] array = {12, 2, 11, 56, 6};
        sort(array);
    }

    public static void sort(int[] array){
        CountDownLatch countDownLatch = new CountDownLatch(array.length);
        for(Integer number : array){
            new Thread(() -> {
                countDownLatch.countDown();
                try{
                    countDownLatch.await();
                    Thread.sleep(number*100);
                    System.out.print(number + " ");
                }catch (Exception e){
                    e.printStackTrace();
                }
            });
        }
    }
}
