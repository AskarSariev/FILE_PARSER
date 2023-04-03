package com.infomaximum.parsers;

import com.infomaximum.models.ParseObject;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.util.List;

public interface ParserFile {

    List<ParseObject> parse(String path);
}
