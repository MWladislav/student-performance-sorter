package com.example.sorter.writer;

import com.example.sorter.exceptions.WriterException;
import com.example.sorter.model.Student;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TextFileStudentWriter implements StudentWriter {

    @Override
    public void writeToFile(File file, Student[] students) {
        try {
            final List<String> lines = Arrays.stream(students)
                    .map(student -> String.format("%s,%f", student.getName(), student.getPerformance()))
                    .collect(Collectors.toList());
            Files.write(file.toPath(), lines);
            System.out.println("Result lines saved: " + lines.size());
        } catch (IOException e) {
            throw new WriterException(String.format("Can't write results to file: %s", file.getName()));
        }
    }
}
