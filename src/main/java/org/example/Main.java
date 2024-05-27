package org.example;

import org.example.Task01.Task01;
import org.example.Task01.multithread.MultiThreadSort;
import org.example.Task02.Task02;
import org.example.Task03.Task03;
import org.example.Task04.Task04;
import org.example.Task08.Task08;

import java.util.*;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        String s = "[]{}{([]))}";
        System.out.println(Task08.check(s));


    }
}