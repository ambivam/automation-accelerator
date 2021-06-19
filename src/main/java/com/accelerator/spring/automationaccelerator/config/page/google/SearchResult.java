package com.accelerator.spring.automationaccelerator.config.page.google;

import com.accelerator.spring.automationaccelerator.config.page.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SearchResult extends Base {

    //@FindBy(css = "div.rc")
    @FindBy(css = "div.g" )
    private List<WebElement> results;

    public int getCount(){
        return this.results.size();
    }

    @Override
    public boolean isAt(){
        return this.wait.until((d) -> !this.results.isEmpty());
    }

}
