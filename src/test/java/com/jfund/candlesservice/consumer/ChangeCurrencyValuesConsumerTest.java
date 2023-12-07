package com.jfund.candlesservice.consumer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ChangeCurrencyValuesConsumerTest {
    private ChangeCurrencyValuesConsumer changeCurrencyValuesConsumer;
    @Autowired
    public void setChangeCurrencyValuesConsumer(ChangeCurrencyValuesConsumer changeCurrencyValuesConsumer) {
        this.changeCurrencyValuesConsumer = changeCurrencyValuesConsumer;
    }
    @Test
    public void testParseItemFromJsonAsString(){
        String json = "{\"id\":\"65708638aad8e5355b2c7ebe\",\"changedValues\":[{\"key\":\"RSDEUR\",\"value\":0.008778244},{\"key\":\"BYNRUB\",\"value\":30.010366},{\"key\":\"RUBNZD\",\"value\":0.025670432}],\"changedDateTime\":\"2023-12-06T17:33:28.676\"}";
        changeCurrencyValuesConsumer.consume(json);
    }
}
