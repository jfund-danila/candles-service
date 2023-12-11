package com.jfund.candlesservice.service;

import com.jfund.candlesservice.entity.CandlePeriod;
import com.jfund.candlesservice.repository.CandlePeriodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class CandlePeriodService {
    private CandlePeriodRepository repository;
    @Autowired
    public void setRepository(CandlePeriodRepository repository) {
        this.repository = repository;
    }

    List<CandlePeriod> saveAll(Collection<CandlePeriod> candlePeriods){
        return repository.saveAll(candlePeriods);
    }
    CandlePeriod save(CandlePeriod candlePeriod){
        return repository.save(candlePeriod);
    }
    List<CandlePeriod> findAll(){
        return repository.findAll();
    }
}
