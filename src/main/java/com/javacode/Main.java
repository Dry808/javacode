package com.javacode;


import com.javacode.javacollection.Filter;
import com.javacode.javacollection.MathFilter;
import com.javacode.javacollection.task2.CountElements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static com.javacode.javacollection.FilterArray.filter;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // ЗАДАЧА 1
        Filter filter = new MathFilter(); // инициализируем нужный фильтр
        Integer[] numbers = {1, 2, 3, 4, 5}; // начальный массив

        Object[] filteredNumbers = filter(numbers, filter); // применяем фильтр MathFilter для массива numbers

        // проверка
        for (Object number : filteredNumbers) {
            System.out.println(number);
        }


        // ЗАДАЧА 2 (счётчик)
        Integer[] numbs = {0, 1, 2 , 3, 1, 2, 3, 1};

        Map<Integer, Integer> task2 = CountElements.countOfElements(numbs);
        System.out.println(task2.get(1)); // 3
        System.out.println(task2.get(0)); // 1
        System.out.println(task2.get(3)); // 2


    }
}