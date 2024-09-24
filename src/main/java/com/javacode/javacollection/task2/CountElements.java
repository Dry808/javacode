package com.javacode.javacollection.task2;

import java.util.HashMap;
import java.util.Map;

public class CountElements {

    public static <T> Map<T, Integer> countOfElements(T[] arr) {
        Map<T, Integer> countMap = new HashMap<>();


        for (T obj : arr) {
            Integer counter = 0;
            for (T ob : arr) {
                if (obj.equals(ob)) {
                    counter++;
                }
            }
            countMap.put(obj, counter);
        }
        return countMap;
    }
}
