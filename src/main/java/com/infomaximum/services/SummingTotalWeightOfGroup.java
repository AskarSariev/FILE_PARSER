package com.infomaximum.services;

import com.infomaximum.models.ParseObject;
import com.infomaximum.parsers.ParserFile;
import com.infomaximum.print.PrintToConsole;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SummingTotalWeightOfGroup implements PrintToConsole {

    @Override
    public void printToConsole(ParserFile parserFile, String path) {
        getSumTotalWeightOfGroup(parserFile.parse(path))
                .forEach((k, v) -> System.out.println("GROUP - " + k + " | TOTAL WEIGHT - " + v));
    }

    private Map<String, Long> getSumTotalWeightOfGroup(List<ParseObject> parseObjects) {
        return parseObjects
                .stream()
                .collect(
                        Collectors.groupingBy(ParseObject::getGroup,
                                Collectors.summingLong(ParseObject::getWeight)
                        )
                );
    }
}
