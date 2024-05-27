package org.example.Task03;

import java.util.Collections;
import java.util.List;

public class Task03 {
    public static Integer start(List<Integer> list){
        Collections.sort(list);
        list.sort(Collections.reverseOrder());
        return list.get(0) + list.get(1);
    }
}
