package com.accelerator.spring.automationaccelerator.repository;

import com.accelerator.spring.automationaccelerator.entity.Predictions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PredictionsRepository extends JpaRepository<Predictions,Integer> {
}
