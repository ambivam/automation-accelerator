package com.accelerator.spring.automationaccelerator.util;

import com.accelerator.spring.automationaccelerator.repository.ExceutionSummaryRepository;
import com.accelerator.spring.automationaccelerator.repository.TestCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Lazy
@Component
public class ReportUtil {

    @Lazy
    @Autowired
    private TestCaseRepository testCaseRepository;

    @Lazy
    @Autowired
    private ExceutionSummaryRepository exceutionSummaryRepository;

    public void ReportInfo(String... info){
        this.testCaseRepository.insertTestInfo(info[0],info[1],info[2],info[3]);
    }

    public void ReportSummary(Timestamp timestamp,String... info){
        this.exceutionSummaryRepository.insertSummaryInfo(timestamp,info[0],info[1],info[2],info[3],
                info[4],info[5],info[6],info[7],info[8]);
    }
}


