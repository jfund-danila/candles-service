package com.jfund.candlesservice.repository;

import com.jfund.candlesservice.entity.ChangeCurrencyValuesEvent;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChangedCurrencyValuesRepository extends MongoRepository<ChangeCurrencyValuesEvent, String> {}
