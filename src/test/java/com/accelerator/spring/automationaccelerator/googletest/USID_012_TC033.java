package com.accelerator.spring.automationaccelerator.googletest;

import com.accelerator.spring.automationaccelerator.SpringBaseTestNGTest;
import com.accelerator.spring.automationaccelerator.config.page.google.GooglePage;
import com.accelerator.spring.automationaccelerator.entity.TestCaseTable;
import com.accelerator.spring.automationaccelerator.repository.TestCaseRepository;
import com.accelerator.spring.automationaccelerator.util.ReportUtil;
import com.accelerator.spring.automationaccelerator.util.ScreenShotUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

@Lazy
@Profile("dbsuite")
public class USID_012_TC033 extends SpringBaseTestNGTest {

    @Lazy
    @Autowired
    private GooglePage googlePage;

    @Lazy
    @Autowired
    private ScreenShotUtil screenShotUtil;

    @Lazy
    @Autowired
    private ReportUtil reportUtil;

    @Test
    public void googleTest() throws IOException {
        try{
            this.googlePage.goTo();
        }catch(Exception e){
            System.out.println("into exception");
            this.reportUtil.ReportInfo("TC03","TESTCASE SMOKE","RUNNING SMOKE","FAIL");

        }
        System.out.println("before pass");
        this.reportUtil.ReportInfo("TC03","TESTCASE SMOKE","RUNNING SMOKE","PASS");
        System.out.println("after pass");


    }
}
