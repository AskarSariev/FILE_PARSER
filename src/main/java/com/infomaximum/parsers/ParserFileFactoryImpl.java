package com.infomaximum.parsers;

public class ParserFileFactoryImpl implements ParserFileFactory {

    @Override
    public ParserFile getParserFile(String pathToFile) {
        ParserFile parserFile = null;
        if (pathToFile.endsWith(".json")) {
            parserFile = new ParserJsonFile();
        }
        if (pathToFile.endsWith(".csv")) {
            parserFile = new ParserCsvFile();
        }
        return parserFile;
    }
}
