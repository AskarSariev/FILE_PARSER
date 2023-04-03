package com.infomaximum.parsers;

import com.infomaximum.models.ParseObject;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public interface Parser {

    List<ParseObject> parse(String path) throws IOException, CsvValidationException;

    default void printSameGroupAndTypeFieldsWithCounting(List<ParseObject> parseObjects) {
                parseObjects
                        .stream()
                        .collect(
                                Collectors.groupingBy(ParseObject::getGroup,
                                        Collectors.groupingBy(ParseObject::getType,
                                                Collectors.counting()
                                        )
                                )
                        )
                        .forEach((k, v) -> System.out.println("GROUP - " + k + " | TYPE=COUNT : " + v));
    }

    default void printGroupWithTotalWeight(List<ParseObject> parseObjects) {
                parseObjects
                .stream()
                .collect(
                        Collectors.groupingBy(ParseObject::getGroup,
                                Collectors.summingLong(ParseObject::getWeight)
                                )
                )
                .forEach((k, v) -> System.out.println("GROUP - " + k + " | TOTAL WEIGHT - " + v));
    }

    default void printMaxWeight(List<ParseObject> parseObjects) {
        Optional<ParseObject> maxWeight = parseObjects
                .stream()
                .max(Comparator.comparing(ParseObject::getWeight));
        System.out.println("MAX WEIGHT = " + maxWeight.get().getWeight());
    }

    default void printMinWeight(List<ParseObject> parseObjects) {
        Optional<ParseObject> minWeight = parseObjects
                .stream()
                .min(Comparator.comparing(ParseObject::getWeight));
        System.out.println("MIN WEIGHT = " + minWeight.get().getWeight());
    }
}
