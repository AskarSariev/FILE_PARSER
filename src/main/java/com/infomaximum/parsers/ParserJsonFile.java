package com.infomaximum.parsers;

import com.infomaximum.models.ParseObject;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParserJsonFile implements ParserFile {

    private static final String GROUP = "group";
    private static final String TYPE = "type";
    private static final String NUMBER = "number";
    private static final String WEIGHT = "weight";

    public List<ParseObject> parse(String jsonFilePath) {
        try {
            File jsonFile = new File(jsonFilePath);

            JsonFactory jsonFactory = new JsonFactory();
            JsonParser jsonParser = jsonFactory.createJsonParser(jsonFile);

            List<ParseObject> parseObjects = new ArrayList<>(10000000);
            StringBuilder fieldName = new StringBuilder();

            JsonToken currentToken = jsonParser.nextToken();

            while (currentToken != JsonToken.END_ARRAY) {
                ParseObject parseObject = new ParseObject();

                currentToken = jsonParser.nextToken();

                if (currentToken == JsonToken.END_ARRAY) break;

                while ((currentToken = jsonParser.nextToken()) != JsonToken.END_OBJECT) {

                    fieldName = fieldName.append(jsonParser.getCurrentName());

                    currentToken = jsonParser.nextToken();

                    switch (fieldName.toString()) {
                        case GROUP:
                            parseObject.setGroup(jsonParser.getText());
                            break;
                        case TYPE:
                            parseObject.setType(jsonParser.getText());
                            break;
                        case NUMBER:
                            parseObject.setNumber(jsonParser.getLongValue());
                            break;
                        case WEIGHT:
                            parseObject.setWeight(jsonParser.getLongValue());
                            break;
                    }
                    fieldName.setLength(0);
                }
                parseObjects.add(parseObject);
            }
            return parseObjects;

        } catch (JsonParseException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
