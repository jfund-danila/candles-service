package com.jfund.candlesservice.parse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.jfund.candlesservice.data.CurrencyValue;
import com.jfund.candlesservice.entity.ChangeCurrencyValuesEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

@Component
public class ChangeValuesEventParser {
    private ObjectMapper objectMapper;
    @Autowired
    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }
    public ChangeCurrencyValuesEvent parse(String objectAsJson){
        try {
            return handleJsonNode(objectAsJson);
        } catch (JsonProcessingException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private ChangeCurrencyValuesEvent handleJsonNode(String objectAsJson) throws JsonProcessingException, ParseException {
        JsonNode eventJsonNode = objectMapper.readTree(objectAsJson);

        String id = eventJsonNode.get("id").textValue();
        LocalDateTime dateTime = LocalDateTime.parse(eventJsonNode.get("changedDateTime").textValue());

        List<CurrencyValue> currencyValues = new ArrayList<>();
        for (Iterator<JsonNode> it = eventJsonNode.get("changedValues").elements(); it.hasNext(); ) {
            JsonNode jsonNode = it.next();
            CurrencyValue value = new CurrencyValue(jsonNode.get("key").textValue(), jsonNode.get("value").floatValue());
            currencyValues.add(value);
        }

        return new ChangeCurrencyValuesEvent(id, currencyValues, dateTime);
    }
}
