package com.javacode.javacore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class Snapshot {
    private final char[] value;
    private final int length;

    public Snapshot(char[] value, int length) {
        this.value = new char[value.length];
        System.arraycopy(value, 0, this.value, 0, length);
        this.length = length;
    }
}
