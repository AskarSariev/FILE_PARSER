package com.infomaximum;

import com.infomaximum.parsers.*;
import com.infomaximum.print.PrintToConsole;
import com.infomaximum.services.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Runner {

    public static void main(String[] args) {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Please, enter the full path to the file or 'exit': ");

        try {
            String textFromConsole;
            textFromConsole = bufferedReader.readLine();

            while (!textFromConsole.equals("exit")) {

                File file = new File(textFromConsole);

                if (file.exists()) {
                    ParserFileFactory parserFileFactory = new ParserFileFactoryImpl();
                    ParserFile parserFile = parserFileFactory.getParserFile(textFromConsole);

                    List<PrintToConsole> summaryStatistics = new ArrayList<>();

                    StatisticFactory statisticFactory = new StatisticFactoryImpl();

                    CountingObjectsWithSameGroupAndType countingObjectsWithSameGroupAndType =
                            statisticFactory.getCountingObjectsWithSameGroupAndType();

                    SummingTotalWeightOfGroup summingTotalWeightOfGroup =
                            statisticFactory.getSummingTotalWeightOfGroup();

                    MaxWeight maxWeight = statisticFactory.getMaxWeight();

                    MinWeight minWeight = statisticFactory.getMinWeight();

                    summaryStatistics.add(countingObjectsWithSameGroupAndType);
                    summaryStatistics.add(summingTotalWeightOfGroup);
                    summaryStatistics.add(maxWeight);
                    summaryStatistics.add(minWeight);

                    for (PrintToConsole statistics : summaryStatistics) {
                        statistics.printToConsole(parserFile, textFromConsole);
                    }

                } else {
                    System.out.print("Please, enter the CORRECT full path to the file or 'exit': ");
                }

                textFromConsole = bufferedReader.readLine();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}