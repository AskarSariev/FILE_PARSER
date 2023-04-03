package com.infomaximum.services;

import com.infomaximum.models.ParseObject;
import com.infomaximum.parsers.ParserFile;
import com.infomaximum.print.PrintToConsole;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class MaxWeight implements PrintToConsole {

    @Override
    public void printToConsole(ParserFile parserFile, String path) {
        Optional<ParseObject> maxWeight = getMaxWeight(parserFile.parse(path));
        System.out.println("MAX WEIGHT = " + maxWeight.get().getWeight());
    }

    private Optional<ParseObject> getMaxWeight(List<ParseObject> parseObjects) {
        return parseObjects
                .stream()
                .max(Comparator.comparing(ParseObject::getWeight));
    }
}
