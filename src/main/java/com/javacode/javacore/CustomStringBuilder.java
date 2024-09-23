package com.javacode.javacore;

import java.util.Stack;

public class CustomStringBuilder {
    private char[] value;
    private int length;
    private Stack<Snapshot> snapshot;

    public CustomStringBuilder() {
        value = new char[10];
        length = 0;
        snapshot = new Stack<Snapshot>();
    }

    public CustomStringBuilder append(String s) {
        snapshot.push(new Snapshot(value, length)); // снимок
        ensureCapacity(length + s.length()); // обеспечение достаточной вместимости
        s.getChars(0, s.length(), value, length); // копирование символов
        length += s.length();
        return this;
    }

    public CustomStringBuilder delete(int start, int end) {
        if (start < 0 || start > end || end > length) {
            throw new RuntimeException("Неправильный индекс");
        }
        snapshot.push(new Snapshot(value, length));
        int numToDelete = end - start;
        System.arraycopy(value, end, value, start, length - end);
        length -= numToDelete;
        return this;
    }

    public CustomStringBuilder delete(int index) {
        if (index < 0 || index >= length) {
            throw new StringIndexOutOfBoundsException("Invalid index");
        }
        snapshot.push(new Snapshot(value, length));
        System.arraycopy(value, index + 1, value, index, length - index - 1);
        length--;
        return this;
    }

    public CustomStringBuilder insert(int index, String s) {
        if (index < 0 || index > length) {
            throw new StringIndexOutOfBoundsException("Invalid offset");
        }
        snapshot.push(new Snapshot(value, length));
        ensureCapacity(length + s.length());
        System.arraycopy(value, index, value, index + s.length(), length - index);
        s.getChars(0, s.length(), value, index);
        length += s.length();
        return this;
    }

    public String toString() {
        return new String(value, 0, length);
    }

    //вернуть назад
    public void undo() {
        if (!snapshot.isEmpty()) {
            Snapshot currentSnapshot = snapshot.pop();
            value = currentSnapshot.getValue();
            length = currentSnapshot.getLength();
        }
    }

    // увеличение вместимости массива
    private void ensureCapacity(int minCapacity) {
        if (minCapacity > value.length) {
            int newCapacity = Math.max(value.length * 2, minCapacity);
            char[] newValue = new char[newCapacity];
            System.arraycopy(value, 0, newValue, 0, length); //копирование элементов одного массива в другой
            value = newValue;
        }
    }
}
