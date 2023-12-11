package com.jfund.candlesservice.repository;

import com.jfund.candlesservice.entity.CandlePeriod;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandlePeriodRepository extends MongoRepository<CandlePeriod, Long> {
}
