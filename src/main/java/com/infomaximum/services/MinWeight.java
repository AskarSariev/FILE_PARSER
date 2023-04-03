package com.infomaximum.services;

import com.infomaximum.models.ParseObject;
import com.infomaximum.parsers.ParserFile;
import com.infomaximum.print.PrintToConsole;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class MinWeight implements PrintToConsole {

    @Override
    public void printToConsole(ParserFile parserFile, String path) {
        Optional<ParseObject> minWeight = getMinWeight(parserFile.parse(path));
        System.out.println("MIN WEIGHT = " + minWeight.get().getWeight());
    }

    private Optional<ParseObject> getMinWeight(List<ParseObject> parseObjects) {
        return parseObjects
                .stream()
                .min(Comparator.comparing(ParseObject::getWeight));

    }
}
