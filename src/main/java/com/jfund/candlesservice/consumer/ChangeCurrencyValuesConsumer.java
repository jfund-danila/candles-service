package com.jfund.candlesservice.consumer;

import com.jfund.candlesservice.entity.ChangeCurrencyValuesEvent;
import com.jfund.candlesservice.parse.ChangeValuesEventParser;
import com.jfund.candlesservice.service.ChangeCurrencyValuesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class ChangeCurrencyValuesConsumer{
    private ChangeCurrencyValuesService changeCurrencyValuesService;
    private ChangeValuesEventParser changeValuesEventParser;

    @Autowired
    public void setChangeCurrencyValuesService(ChangeCurrencyValuesService changeCurrencyValuesService) {
        this.changeCurrencyValuesService = changeCurrencyValuesService;
    }

    @Autowired
    public void setChangeValuesEventParser(ChangeValuesEventParser changeValuesEventParser) {
        this.changeValuesEventParser = changeValuesEventParser;
    }
    public void consume(String json) {
        try{
            ChangeCurrencyValuesEvent event = changeValuesEventParser.parse(json);
            changeCurrencyValuesService.save(event);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
