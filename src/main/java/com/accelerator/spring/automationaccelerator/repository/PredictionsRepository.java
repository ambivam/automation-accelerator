package com.accelerator.spring.automationaccelerator.repository;

import com.accelerator.spring.automationaccelerator.entity.Predictions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PredictionsRepository extends JpaRepository<Predictions,Integer> {

    /*@Query("select c from Predictions c where c.probabilityfailure >= ?#{[0]}")
    public List<Predictions> findTestCases(Double probabilityfailure);*/

    public List<Predictions> findByProbabilityfailureGreaterThan(Double probabilityfailure);

}
