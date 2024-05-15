package org.example;

import org.example.task01.Sort;
import org.example.task01.multithread.MultithreadSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

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
        System.out.println(timer.stopTimer());
        timer.setTimer();
        MultithreadSort.sort(array);
        System.out.println(timer.stopTimer());
    }
}