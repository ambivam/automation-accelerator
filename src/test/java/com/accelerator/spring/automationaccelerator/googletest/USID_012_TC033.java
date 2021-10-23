package com.accelerator.spring.automationaccelerator.googletest;

import com.accelerator.spring.automationaccelerator.SpringBaseTestNGTest;
import com.accelerator.spring.automationaccelerator.config.page.google.GooglePage;
import com.accelerator.spring.automationaccelerator.util.ScreenShotUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

@Profile("dbsuite")
public class USID_012_TC033 extends SpringBaseTestNGTest {

    @Lazy
    @Autowired
    private GooglePage googlePage;

    @Lazy
    @Autowired
    private ScreenShotUtil screenShotUtil;


    @Test
    public void googleTest() throws IOException {
        this.googlePage.goTo();


    }
}
