package com.accelerator.spring.automationaccelerator.googletest;

import com.accelerator.spring.automationaccelerator.SpringBaseTestNGTest;
import com.accelerator.spring.automationaccelerator.config.page.google.GooglePage;
import com.accelerator.spring.automationaccelerator.util.ReportUtil;
import com.accelerator.spring.automationaccelerator.util.ScreenShotUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.Timestamp;

@Lazy
public class DefaultTest extends SpringBaseTestNGTest {



    @Test
    public void googleTest() throws IOException {


        System.out.println("Dummy Test");


    }


}
