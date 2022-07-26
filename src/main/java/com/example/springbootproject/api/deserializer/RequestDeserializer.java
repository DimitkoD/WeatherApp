package com.example.springbootproject.api.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;

public class RequestDeserializer extends JsonDeserializer<Boolean> {

    @Override
    public Boolean deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonToken currentToken = jsonParser.getCurrentToken();

        if (currentToken.equals(JsonToken.VALUE_STRING)) {
            String text = jsonParser.getText();

            if ("Yes".equalsIgnoreCase(text)) {
                return Boolean.TRUE;
            } else if ("No".equalsIgnoreCase(text)) {
                return Boolean.FALSE;
            }

        } else if (currentToken.equals(JsonToken.VALUE_NULL)) {
            return Boolean.FALSE;
        }

        return Boolean.FALSE;
    }
}
