package com.accelerator.spring.automationaccelerator.condition;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Component;

@Component
@Qualifier("civic")
//@ConditionalOnExpression("${car.speed} < 70")
public class Civic implements Car{

    @Override
    public void run() {
        System.out.println("I am civic . Speed is 60 mph");
    }
}
