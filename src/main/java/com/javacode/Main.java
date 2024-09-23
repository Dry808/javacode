package com.javacode;

import com.javacode.javacore.CustomStringBuilder;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        CustomStringBuilder stringBuilder = new CustomStringBuilder();

        stringBuilder.append("Новый");
        stringBuilder.append("StringBuilder");
        stringBuilder.append("!");
        stringBuilder.delete(3);

        System.out.println(stringBuilder);
    }
}