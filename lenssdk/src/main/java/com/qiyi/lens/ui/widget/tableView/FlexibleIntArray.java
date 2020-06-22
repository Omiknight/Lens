package com.qiyi.lens.ui.widget.tableView;

public class FlexibleIntArray {
    private int[] ar;
    private int size;
    private int capacity;

    public FlexibleIntArray() {
        size = 0;
        ar = new int[6];
        capacity = 6;

    }

    public void add(int a) {
        if (size == capacity) {
            // enlarge buffer and copy data
            int[] aar = new int[capacity << 1];
            if (capacity >= 0) System.arraycopy(ar, 0, aar, 0, capacity);
            ar = aar;
            capacity = aar.length;
        }

        ar[size] = a;
        size++;

    }

    public int size() {
        return size;
    }

    public int get(int i) {
        if (i < size) {
            return ar[i];
        }
        return 0;
    }

    public boolean contains(int a) {
        for (int i = 0; i < size; i++) {
            if (ar[i] == a) {
                return true;
            }
        }

        return false;
    }

    public void addIfNotExist(int a) {
        if (!contains(a)) {
            add(a);
        }

    }
}
