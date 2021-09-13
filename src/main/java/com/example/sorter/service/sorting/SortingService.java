package com.example.sorter.service.sorting;

public interface SortingService<T> {

    void sort(T[] objects, Sort algorithm);
}
