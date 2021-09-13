package com.example.sorter.service.sorting.factory;

import com.example.sorter.model.Student;
import com.example.sorter.service.sorting.SortingService;
import com.example.sorter.service.sorting.StudentSortingService;

public class SortingServiceFactory {

    public static SortingService createSortingService(Class<?> candidateClass,
                                                  String sortingFieldName) {
        if (Student.class.equals(candidateClass)) {
            return new StudentSortingService(
                    ComparatorHolder.getStudentComparator(sortingFieldName));
        }
        return null;
    }
}
