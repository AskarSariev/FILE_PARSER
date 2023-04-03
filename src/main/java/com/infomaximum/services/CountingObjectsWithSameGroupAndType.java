package com.infomaximum.services;

import com.infomaximum.models.ParseObject;
import com.infomaximum.parsers.ParserFile;
import com.infomaximum.print.PrintToConsole;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CountingObjectsWithSameGroupAndType implements PrintToConsole {

    @Override
    public void printToConsole(ParserFile parserFile, String path) {
        countObjectsWithSameGroupAndTypeFields(parserFile.parse(path))
                .forEach((k, v) -> System.out.println("GROUP - " + k + " | TYPE=COUNT : " + v));
    }

    private Map<String, Map<String, Long>> countObjectsWithSameGroupAndTypeFields(List<ParseObject> parseObjects) {
        return parseObjects
                .stream()
                .collect(
                        Collectors.groupingBy(ParseObject::getGroup,
                                Collectors.groupingBy(ParseObject::getType,
                                        Collectors.counting()
                                )
                        )
                );
    }
}
