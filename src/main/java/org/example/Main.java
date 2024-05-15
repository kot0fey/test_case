package org.example;

import org.example.task01.Sort;
import org.example.task01.multithread.MultiThreadSort;

import java.util.Random;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Integer[] array = new Integer[10000];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextBoolean() ? random.nextInt(Integer.MAX_VALUE) : -random.nextInt(Integer.MAX_VALUE);
        }
        Timer timer = new Timer();


        timer.setTimer();
        Sort.sort(array);
        System.out.println("Sort: " + timer.stopTimer());


        timer.setTimer();
        MultiThreadSort.sort(array);
        System.out.println("MultiThreadSort: " + timer.stopTimer());
    }
}