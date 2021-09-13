package com.example.sorter.parser.factory;

import com.example.sorter.exceptions.NoSuchParserException;
import com.example.sorter.parser.StudentParser;
import com.example.sorter.parser.TextFileStudentParser;

public class StudentParserFactory {

    public static StudentParser createParser(String fileFormat) {
        if ("txt".equals(fileFormat)) {
            return new TextFileStudentParser();
        }
        throw new NoSuchParserException(String.format("Can't find parser for format: %s", fileFormat));
    }
}
