package org.example.Task04;

import java.util.Collections;
import java.util.List;

public class Task04 {
    public static Integer start(List<Integer> list, Integer element) {
        Integer low = 0;
        Integer high = list.size()-1;

        while (low <= high) {
            Integer mid = (low + high) >>> 1;
            Integer midVal = list.get(mid);
            Integer cmp = midVal.compareTo(element);

            if (cmp < 0)
                low = mid + 1;
            else if (cmp > 0)
                high = mid - 1;
            else
                return mid;
        }
        return -(low + 1);
    }
}
