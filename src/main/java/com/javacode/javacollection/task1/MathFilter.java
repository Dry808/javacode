package com.javacode.javacollection.task1;

/**
 * Фильтр для проверки (прибавляет каждому числу 10)
 */

public class MathFilter implements Filter {

    @Override
    public Integer apply(Object o) {
        int number = (int) o;
        return number + 10;
    }


}
