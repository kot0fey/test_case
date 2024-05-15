package org.example.task01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sort {

    private static List<Integer> sort(List<Integer> array) {
        if (array.size() <= 1) {
            return array;
        }
        List<Integer> lessList = new ArrayList<>();
        List<Integer> moreList = new ArrayList<>();
        List<Integer> pivotList = new ArrayList<>();
        Integer pivot = array.get(0);
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
        List<Integer> sortedLessArray = sort(lessList);
        List<Integer> sortedMoreArray = sort(moreList);
        List<Integer> sortedList = new ArrayList<>();
        sortedList.addAll(sortedLessArray);
        sortedList.addAll(pivotList);
        sortedList.addAll(sortedMoreArray);
        return sortedList;
    }

    public static Integer[] sort(Integer[] array) {
        List<Integer> result = sort(Arrays.stream(array).toList());
        return result.toArray(Integer[]::new);
    }

}
