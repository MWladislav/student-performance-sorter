package com.example.sorter.service.sorting;

import java.util.Comparator;

public interface Sort<T> {

    void sort(T[] arr, Comparator<T> comparator);
}
