package com.jfund.candlesservice.consumer;

import com.jfund.candlesservice.entity.ChangeCurrencyValuesEvent;
import com.jfund.candlesservice.parse.ChangeValuesEventParser;
import com.jfund.candlesservice.service.ChangeCurrencyValuesService;
import com.jfund.candlesservice.service.StartUpdateCandleTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Component
public class ChangeCurrencyValuesConsumer{
    private ChangeCurrencyValuesService changeCurrencyValuesService;
    private ChangeValuesEventParser changeValuesEventParser;
    private StartUpdateCandleTimeService startUpdateCandleTimeService;

    @Autowired
    public void setChangeCurrencyValuesService(ChangeCurrencyValuesService changeCurrencyValuesService) {
        this.changeCurrencyValuesService = changeCurrencyValuesService;
    }

    @Autowired
    public void setChangeValuesEventParser(ChangeValuesEventParser changeValuesEventParser) {
        this.changeValuesEventParser = changeValuesEventParser;
    }

    @Autowired
    public void setStartUpdateCandleTimeService(StartUpdateCandleTimeService startUpdateCandleTimeService) {
        this.startUpdateCandleTimeService = startUpdateCandleTimeService;
    }
    public void consume(String json) {
        try{
            ChangeCurrencyValuesEvent event = changeValuesEventParser.parse(json);
            changeCurrencyValuesService.save(event);
            saveStartDateTimeIfNotExist(event);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void saveStartDateTimeIfNotExist(ChangeCurrencyValuesEvent event){
        try{
            startUpdateCandleTimeService.get();
        }catch (NoSuchElementException e){
            startUpdateCandleTimeService.save(event.getChangedDateTime());
        }
    }
}
