package com.accelerator.spring.automationaccelerator.condition;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Component;

@Component
@Qualifier("accord")
//@ConditionalOnExpression("${car.speed} >= 70")
public class Accord implements Car{

    @Override
    public void run() {
        System.out.println("I am Accord . Speed is 80 mph");
    }
}
