package org.example;

import org.example.task01.Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Integer[] array = {1,5,8,4,5,9,6,4,5,8,6,3,2,5,6,5,4,4};
        array = Sort.quickSortSingleThread(array);
        List list = new ArrayList<>();

        list.addAll(Arrays.stream(array).toList());
        System.out.println(list);
    }
}