package org.example.task01.multithread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MultiThreadSort implements Callable<Integer[]> {
    private static ExecutorService executorService = Executors.newWorkStealingPool();

    private Integer[] array;

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
            }
            if (number.equals(pivot)) {
                pivotList.add(number);
            }
        }
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

    public static Integer[] sort(Integer[] array) throws ExecutionException, InterruptedException {
        Callable<Integer[]> callable = new MultiThreadSort(array);
        Future<Integer[]> future = executorService.submit(callable);
        Integer[] result = future.get();
        executorService.shutdown();
        return result;
    }

    private MultiThreadSort(Integer[] array) {
        this.array = array;
    }

//    @Override
//    protected Integer[] compute() {
//        if (array.length > 1) {
//            List<Integer> lessList = new ArrayList<>();
//            List<Integer> moreList = new ArrayList<>();
//            List<Integer> pivotList = new ArrayList<>();
//            Integer pivot = array[0];
//            for (Integer number : array) {
//                if (number > pivot) {
//                    moreList.add(number);
//                    continue;
//                }
//                if (number < pivot) {
//                    lessList.add(number);
//                }
//                if (number.equals(pivot)) {
//                    pivotList.add(number);
//                }
//            }
//            MultiThreadSort multiThreadSort1 = new MultiThreadSort(lessList.toArray(Integer[]::new));
//            MultiThreadSort multiThreadSort2 = new MultiThreadSort(moreList.toArray(Integer[]::new));
//            multiThreadSort1.fork();
//            multiThreadSort2.compute();
//            multiThreadSort1.join();
//            //TODO toArray -> copyOf
//
//            Future<Integer[]> sortedLessArray = executorService.submit(callableLess);
//            Future<Integer[]> sortedMoreOrEqualsArray = executorService.submit(callableMore);
//
//            List<Integer> sortedList = new ArrayList<>();
//            sortedList.addAll(List.of(sortedLessArray.get()));
//            sortedList.addAll(pivotList);
//            sortedList.addAll(List.of(sortedMoreOrEqualsArray.get()));
//            return sortedList.toArray(Integer[]::new);
//        }
//        return array;
//    }
}
