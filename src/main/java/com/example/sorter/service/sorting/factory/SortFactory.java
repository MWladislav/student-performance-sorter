package com.example.sorter.service.sorting.factory;

import com.example.sorter.exceptions.NoSuchServiceException;
import com.example.sorter.service.sorting.BubbleSort;
import com.example.sorter.service.sorting.HeapSort;
import com.example.sorter.service.sorting.Sort;
import com.example.sorter.service.sorting.SortingAlgorithm;

public class SortFactory {

    public static SortFactory getInstance() {
        return new SortFactory();
    }

    private SortFactory() {
    }

    public Sort createSort(String sortingAlgorithm) {
        if (SortingAlgorithm.Bubble.name().equals(sortingAlgorithm)) {
            return new BubbleSort();
        } else if (SortingAlgorithm.Heap.name().equals(sortingAlgorithm)) {
            return new HeapSort();
        }
        throw new NoSuchServiceException("Can't find the implementation of sorting algorithm: " + sortingAlgorithm);
    }
}
