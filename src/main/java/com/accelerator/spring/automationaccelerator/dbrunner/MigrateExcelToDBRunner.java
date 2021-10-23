package com.accelerator.spring.automationaccelerator.dbrunner;

import com.accelerator.spring.automationaccelerator.excel.PredictionResults;
import com.accelerator.spring.automationaccelerator.repository.PredictionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
//@Profile("!dbsuite")
@Profile("exceldb")
public class MigrateExcelToDBRunner implements CommandLineRunner {

    @Autowired
    PredictionsRepository eRepo;

    @Autowired
    PredictionResults predictioResults;

    @Value("${path.excel}")
    String fileName;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Executing MigrateExcelToDBRunner");
        eRepo.saveAll(predictioResults.readPredictionsFromExcel(fileName));
    }

}
