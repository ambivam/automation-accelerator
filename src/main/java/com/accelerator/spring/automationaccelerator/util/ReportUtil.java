package com.accelerator.spring.automationaccelerator.util;

import com.accelerator.spring.automationaccelerator.repository.TestCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class ReportUtil {

    @Lazy
    @Autowired
    private TestCaseRepository testCaseRepository;

    public void ReportInfo(String... info){
        this.testCaseRepository.insertTestInfo(info[0],info[1],info[2],info[3]);
    }
}
