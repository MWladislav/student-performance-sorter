package com.example.sorter.service.sorting;

import org.apache.commons.lang3.time.StopWatch;

import java.util.Comparator;

public class HeapSort<T> implements Sort<T> {

    @Override
    public void sort(T[] arr, Comparator<T> comparator) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        try {
            int n = arr.length;
            for (int i = n / 2 - 1; i >= 0; i--)
                buildHeap(arr, comparator, n, i);

            for (int i = n - 1; i > 0; i--) {
                T temp = arr[0];
                arr[0] = arr[i];
                arr[i] = temp;

                buildHeap(arr, comparator, i, 0);
            }
        } finally {
            stopWatch.stop();
            System.out.printf("Successful sorting, costed time: %d%n", stopWatch.getNanoTime());
        }
    }

    void buildHeap(T[] arr, Comparator<T> comparator, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && comparator.compare(arr[l], arr[largest]) > 0)
            largest = l;

        if (r < n && comparator.compare(arr[r], arr[largest]) > 0)
            largest = r;

        if (largest != i) {
            T swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            //Recursive call
            buildHeap(arr, comparator, n, largest);
        }
    }
}
