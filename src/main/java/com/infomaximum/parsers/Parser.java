package com.infomaximum.parsers;

import com.infomaximum.models.ParseObject;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public interface Parser {

    List<ParseObject> parse(String path) throws IOException, CsvValidationException;

    default void printObjectsWithTheSameGroupAndTypeFields(List<ParseObject> parseObjects) {
        Map<String, Map<String, Long>> map =
                parseObjects
                        .stream()
                        .collect(
                                Collectors.groupingBy(ParseObject::getGroup,
                                        Collectors.groupingBy(ParseObject::getType,
                                                Collectors.counting()))
                        );



        for (Map.Entry<String, Map<String, Long>> pair : map.entrySet()) {
            Map<String, Long> mKey = pair.getValue();

            System.out.println("GROUP - " + pair.getKey() + " | TYPE=COUNT : " + pair.getValue());
        }
    }
}
