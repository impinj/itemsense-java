package com.impinj.itemsense.client.helpers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.google.common.base.Preconditions;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.io.IOException;
import java.lang.reflect.Type;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by jcombopi on 1/26/16.
 */
public class ZonedDateTimeDeserializer extends JsonDeserializer<ZonedDateTime> implements com.google.gson.JsonDeserializer<ZonedDateTime> {


    @Override
    public ZonedDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        System.out.println("ZonedDateTimeDeserializer::deserialize()");
        return ZonedDateTime.parse(jsonParser.getText());
    }

    public ZonedDateTime deserialize(String date, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        return ZonedDateTime.parse(date);
    }

    @Override
    public ZonedDateTime deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return ZonedDateTime.parse(jsonElement.getAsString());
    }
}