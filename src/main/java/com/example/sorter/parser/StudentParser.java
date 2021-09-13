package com.example.sorter.parser;

import com.example.sorter.model.Student;

import java.io.File;
import java.util.List;

public interface StudentParser {

    List<Student> parseStudents(File file);
}
