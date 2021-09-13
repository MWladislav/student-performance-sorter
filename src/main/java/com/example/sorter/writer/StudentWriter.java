package com.example.sorter.writer;

import com.example.sorter.model.Student;

import java.io.File;

public interface StudentWriter {

    void writeToFile(File file, Student[] students);
}
