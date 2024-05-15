package org.example.task01;

import java.util.ArrayList;
import java.util.List;

public class Sort {

    public static Integer[] quickSortSingleThread(Integer[] array) {
        if (array.length > 1) {
            List<Integer> lessList = new ArrayList<>();
            List<Integer> moreList = new ArrayList<>();
            List pivotList = new ArrayList<>();
            Integer pivot = array[0];
            pivotList.add(pivot);
            for (Integer number : array) {
                if (number > pivot) {
                    moreList.add(number);
                    continue;
                }
                if (number < pivot) {
                    lessList.add(number);
                }
                if (number == pivot) {
                    pivotList.add(number);
                }
            }
            Integer[] sortedLessArray = quickSortSingleThread(lessList.toArray(Integer[]::new));
            Integer[] sortedMoreOrEqualsArray = quickSortSingleThread(moreList.toArray(Integer[]::new));
            List<Integer> sortedList = new ArrayList<>();
            sortedList.addAll(List.of(sortedLessArray));
            sortedList.addAll(pivotList);
            sortedList.addAll(List.of(sortedMoreOrEqualsArray));
            return sortedList.toArray(Integer[]::new);
        } else {
            return array;
        }
    }
}
