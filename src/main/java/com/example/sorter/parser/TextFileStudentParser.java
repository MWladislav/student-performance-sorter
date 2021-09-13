package com.example.sorter.parser;

import com.example.sorter.exceptions.ParserException;
import com.example.sorter.model.Student;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class TextFileStudentParser implements StudentParser {

    @Override
    public List<Student> parseStudents(File file) {
        Collection<String> errors = new ArrayList<>();
        try {
            final List<Student> students = Files.readAllLines(file.toPath())
                    .stream()
                    .filter(s -> s != null && !s.isEmpty())
                    .map(str -> {
                        final String[] fields = str.split(",");
                        if (fields.length != 2) {
                            errors.add("Invalid number of parameters: " + str);
                            return null;
                        }
                        return new Student(fields[0], Double.parseDouble(fields[1]));
                    })
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
            System.out.println("Students parsed: " + students.size());
            errors.forEach(System.out::println);
            return students;
        } catch (IOException e) {
            throw new ParserException("Couldn't parse file, cause" + e.getMessage());
        }
    }
}
