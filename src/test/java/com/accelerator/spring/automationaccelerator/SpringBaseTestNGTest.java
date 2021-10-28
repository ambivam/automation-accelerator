package com.accelerator.spring.automationaccelerator;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

@SpringBootTest
public class SpringBaseTestNGTest extends AbstractTestNGSpringContextTests {

        protected void display(String display){
            System.out.println(display);
        }
}
