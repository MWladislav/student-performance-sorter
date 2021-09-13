package com.example.sorter.service.sorting.factory;

import com.example.sorter.model.Student;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class ComparatorHolder {

    private static final Map<String, Comparator<Student>> COMPARATORS;

    static {
        COMPARATORS = new HashMap<>();
        COMPARATORS.put("name", Comparator.comparing(Student::getName));
        COMPARATORS.put("performance", Comparator.comparingDouble(Student::getPerformance));
    }

    public static Comparator<Student> getStudentComparator(String fieldName) {
        return COMPARATORS.get(fieldName);
    }
}
