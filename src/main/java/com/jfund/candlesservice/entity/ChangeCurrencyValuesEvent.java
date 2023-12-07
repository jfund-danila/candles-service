package com.jfund.candlesservice.entity;

import com.jfund.candlesservice.data.CurrencyValue;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Accessors(chain = true)
@Getter
@Setter
@Document
public class ChangeCurrencyValuesEvent {
    @Id
    private String id;
    private List<CurrencyValue> changedValues;
    private LocalDateTime changedDateTime;
    private Boolean handed = false;

    @PersistenceCreator
    public ChangeCurrencyValuesEvent(String id, LocalDateTime changedDateTime, List<CurrencyValue> changedValues, Boolean handed){
        setId(id);
        setChangedValues(changedValues);
        setChangedDateTime(changedDateTime);
        setHanded(handed);
    }

    public ChangeCurrencyValuesEvent(String id, List<CurrencyValue> changedValues, LocalDateTime changedDateTime) {
        this(id, changedDateTime, changedValues, false);
    }

    public void setHanded(Boolean handed){
        this.handed = handed != null && handed;
    }
}
