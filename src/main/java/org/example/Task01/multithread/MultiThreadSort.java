package org.example.Task01.multithread;

import org.example.Timer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MultiThreadSort implements Callable<Integer[]>  {
//    private static ExecutorService executorService = Executors.newWorkStealingPool();
    private static ForkJoinPool executorService = (ForkJoinPool) Executors.newWorkStealingPool();

    private Integer[] array;

    private MultiThreadSort(Integer[] array) {
        this.array = array;
    }

    public static Integer[] sort(Integer[] array) throws ExecutionException, InterruptedException {
        Callable<Integer[]> callable = new MultiThreadSort(array);
        Future<Integer[]> future = executorService.submit(callable);
        Integer[] result = future.get();
        executorService.shutdown();
        return result;
    }

    @Override
    public Integer[] call() throws Exception {
        if (array.length <= 1) {
            return array;
        }
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
                continue;
            }
            if (number.equals(pivot)) {
                pivotList.add(number);
            }
        }
        Timer timer = new Timer();
        Callable<Integer[]> callableLess = new MultiThreadSort(lessList.toArray(Integer[]::new));
        Callable<Integer[]> callableMore = new MultiThreadSort(moreList.toArray(Integer[]::new));
        Future<Integer[]> sortedLessArray = executorService.submit(callableLess);
        Future<Integer[]> sortedMoreOrEqualsArray = executorService.submit(callableMore);

        List<Integer> sortedList = new ArrayList<>();
        sortedList.addAll(List.of(sortedLessArray.get()));
        sortedList.addAll(pivotList);
        sortedList.addAll(List.of(sortedMoreOrEqualsArray.get()));

        return sortedList.toArray(Integer[]::new);
    }

}
