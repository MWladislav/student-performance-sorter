package com.example.sorter.writer.factory;

import com.example.sorter.exceptions.NoSuchWriterException;
import com.example.sorter.writer.StudentWriter;
import com.example.sorter.writer.TextFileStudentWriter;

public class StudentWriterFactory {

    public static StudentWriter createWriter(String fileFormat) {
        if ("txt".equals(fileFormat)) {
            return new TextFileStudentWriter();
        }
        throw new NoSuchWriterException(String.format("Can't find parser for format: %s", fileFormat));
    }
}
