package com.javacode.javacollection;

import java.util.ArrayList;
import java.util.List;

public class FilterArray {
    public static Object[] filter(Object[] array, Filter filter) {
        List<Object> resultList = new ArrayList<>();

        for (Object item : array) {
            Object filteredItem = filter.apply(item);
            if (filteredItem != null) {
                resultList.add(filteredItem);
            }
        }

        return resultList.toArray(new Object[0]);
    }
}
