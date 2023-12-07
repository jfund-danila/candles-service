package com.jfund.candlesservice.consumer;

import com.jfund.candlesservice.service.ChangeCurrencyValuesService;
import com.jfund.jfundclilib.UpdateOrCreateData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
@Slf4j(topic = "errors")
@Component
public class KafkaListeners {
    private ChangeCurrencyValuesConsumer consumer;
    private ChangeCurrencyValuesService changeCurrencyValuesService;
    @Autowired
    public void setChangeCurrencyValuesService(ChangeCurrencyValuesService changeCurrencyValuesService) {
        this.changeCurrencyValuesService = changeCurrencyValuesService;
    }

    @Autowired
    public void setConsumer(ChangeCurrencyValuesConsumer consumer){
        this.consumer = consumer;
    }

    @KafkaListener(topics = "jfund-currency-values", groupId = "currency-values-group")
    public UpdateOrCreateData listenChangeCurrencyValues(String stringChangeValuesEvent) {
        try {
            consumer.consume(stringChangeValuesEvent);
            return new UpdateOrCreateData().setCreateCount(1);
        }catch (Exception e){
            log.error(e.getMessage());
            return new UpdateOrCreateData().setErrorMessage(e.getMessage());
        }
    }
}
