package com.accelerator.spring.automationaccelerator.googletest;

import com.accelerator.spring.automationaccelerator.SpringBaseTestNGTest;
import com.accelerator.spring.automationaccelerator.config.page.google.GooglePage;
import com.accelerator.spring.automationaccelerator.util.ReportUtil;
import com.accelerator.spring.automationaccelerator.util.ScreenShotUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Lazy;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.Timestamp;

@Lazy
public class USID_012_TC034 extends SpringBaseTestNGTest {

    /*browser=chrome
            browserversion=70
    os=Windows
            osversion=Win10
    status=fail
            build=1.0.1
    module=frontend*/



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

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        this.googlePage.goTo();
        display("Into test methods");
        this.reportUtil.ReportSummary(timestamp,"TC10","TESTING SUMMARY INFO","CHROME","71.1","WINDOWS",
                "WIN10","PASS","1.0.1","BACKEND");

    }
}
