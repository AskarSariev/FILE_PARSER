package com.infomaximum.parsers;

import com.infomaximum.models.ParseObject;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class ParserCsvFileImpl implements Parser {

    public List<ParseObject> parse(String csvFilePath) throws IOException, CsvValidationException {

        List<ParseObject> parseObjects =
                Files.lines(Paths.get(csvFilePath))
                        .skip(1)
                        .parallel()
                        .map(line -> {
                            String[] strings = line.split(",");
                            ParseObject parseObject = new ParseObject(
                                    strings[0],
                                    strings[1],
                                    Long.parseLong(strings[2]),
                                    Long.parseLong(strings[3])
                            );
                            return parseObject;
                        })
                        .collect(Collectors.toList());
        return parseObjects;
    }
}
