package com.example.sorter.service.sorting;

import org.apache.commons.lang3.time.StopWatch;

import java.util.Comparator;

public class BubbleSort<T> implements Sort<T> {

    @Override
    public void sort(T[] arr, Comparator<T> comparator) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        try {
            int n = arr.length;
            for (int i = 0; i < n - 1; i++)
                for (int j = 0; j < n - i - 1; j++)
                    if (comparator.compare(arr[j], arr[j + 1]) > 0) {
                        T temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
        } finally {
            stopWatch.stop();
            System.out.printf("Successful sorting, costed time: %d%n", stopWatch.getNanoTime());
        }
    }
}
