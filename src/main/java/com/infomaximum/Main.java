package com.infomaximum;

import com.infomaximum.models.ParseObject;
import com.infomaximum.parsers.Parser;
import com.infomaximum.parsers.ParserCsvFileImpl;
import com.infomaximum.parsers.ParserJsonFileImpl;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException, CsvValidationException {
        String jsonFilePath = "C:\\Gen\\out.json";
        String csvFilePath = "C:\\Gen\\out.csv";
        Parser parser = new ParserCsvFileImpl();
        List<ParseObject> parseObjects = parser.parse(csvFilePath);

        parser.printObjectsWithTheSameGroupAndTypeFields(parseObjects);
    }


}