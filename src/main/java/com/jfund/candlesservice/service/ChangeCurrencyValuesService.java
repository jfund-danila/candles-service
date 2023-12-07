package com.jfund.candlesservice.service;

import com.jfund.candlesservice.entity.ChangeCurrencyValuesEvent;
import com.jfund.candlesservice.repository.ChangedCurrencyValuesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChangeCurrencyValuesService {
    private ChangedCurrencyValuesRepository changedCurrencyValuesRepository;
    @Autowired
    public void setChangedCurrencyValuesRepository(ChangedCurrencyValuesRepository changedCurrencyValuesRepository){
        this.changedCurrencyValuesRepository = changedCurrencyValuesRepository;
    }
    public ChangeCurrencyValuesEvent save(ChangeCurrencyValuesEvent changeCurrencyValues){
        return changedCurrencyValuesRepository.save(changeCurrencyValues);
    }

}
