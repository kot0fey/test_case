package org.example.task01;

import java.util.ArrayList;
import java.util.List;

public class Sort {

//Todo pivot is doubling
    public static Integer[] sort(Integer[] array) {
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
            Integer[] sortedLessArray = sort(lessList.toArray(Integer[]::new));
            Integer[] sortedMoreOrEqualsArray = sort(moreList.toArray(Integer[]::new));
            List<Integer> sortedList = new ArrayList<>();
            sortedList.addAll(List.of(sortedLessArray));
            sortedList.addAll(pivotList);
            sortedList.addAll(List.of(sortedMoreOrEqualsArray));
            return sortedList.toArray(Integer[]::new);
        }
        return array;
    }


}
