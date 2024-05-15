package org.example.task01.multithread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class MultithreadSort implements Callable<Integer[]> {
    private volatile Integer[] array;
    @Override
    public Integer[] call() throws Exception {
        if (array.length > 1) {
            List<Integer> lessList = new ArrayList<>();
            List<Integer> moreList = new ArrayList<>();
            List<Integer> pivotList = new ArrayList<>();
            Integer pivot = array[0];
            for (Integer number : array) {
                if (number > pivot) {
                    moreList.add(number);
                    continue;
                }
                if (number < pivot) {
                    lessList.add(number);
                }
                if (number.equals(pivot)) {
                    pivotList.add(number);
                }
            }

            ExecutorService executorService = Executors.newFixedThreadPool(2);
            Callable<Integer[]> callableLess = new MultithreadSort(lessList.toArray(Integer[]::new));
            Callable<Integer[]> callableMore = new MultithreadSort(moreList.toArray(Integer[]::new));

            Integer[] sortedLessArray = executorService.submit(callableLess).get();
            Integer[] sortedMoreOrEqualsArray = executorService.submit(callableMore).get();


            List<Integer> sortedList = new ArrayList<>();
            sortedList.addAll(List.of(sortedLessArray));
            sortedList.addAll(pivotList);
            sortedList.addAll(List.of(sortedMoreOrEqualsArray));
            return sortedList.toArray(Integer[]::new);
        }
        return array;
    }
    public static Integer[] sort(Integer[] array) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Callable<Integer[]> callable = new MultithreadSort(array);
        Future<Integer[]> future = executorService.submit(callable);
        return future.get();
    }
    private MultithreadSort(Integer[] array) {
        this.array = array;
    }
}
