package com.example.sorter.service.sorting;

import com.example.sorter.model.Student;

import java.util.Comparator;

public class StudentSortingService implements SortingService<Student> {

    private final Comparator<Student> comparator;

    public StudentSortingService(Comparator<Student> comparator) {
        this.comparator = comparator;
    }

    @Override
    public void sort(Student[] objects, Sort algorithm) {
        algorithm.sort(objects, comparator);
    }
}
