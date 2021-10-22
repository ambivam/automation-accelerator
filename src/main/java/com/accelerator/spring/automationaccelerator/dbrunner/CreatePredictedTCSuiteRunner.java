package com.accelerator.spring.automationaccelerator.dbrunner;

import com.accelerator.spring.automationaccelerator.suite.CreatePredictedSuite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dbsuite")
public class CreatePredictedTCSuiteRunner implements CommandLineRunner {

    @Autowired
    CreatePredictedSuite createPredictedSuite;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Executing CreatePredictedTCSuiteRunner");
        createPredictedSuite.createPredictedTestSuite();
    }
}
