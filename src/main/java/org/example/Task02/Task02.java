package org.example.Task02;

import java.util.*;

public class Task02 {
    public static Integer[] start(Integer[] a, Integer[] b) {
        List<Integer> listA = new ArrayList<>(Arrays.stream(a).toList());
        List<Integer> listB = new ArrayList<>(Arrays.stream(b).toList());
        List<Integer> result = new ArrayList<>();
        for (Integer bNum : listB){
            while (listA.contains(bNum)){
             result.add(bNum);
             listA.remove(bNum);
            }
        }
        if (!listA.isEmpty()){
            Collections.sort(listA);
            listA.sort(Collections.reverseOrder());
        }
        result.addAll(listA);

        return result.toArray(new Integer[0]);
    }
}
