package com.gulchin.qa.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TeamHelper  extends HelperBase{
    public TeamHelper(WebDriver wd) {
        super(wd);
    }

    public int getTeamsCount() {
       return wd.findElements(By.xpath("//li[contains(@data-test-id,'home-team-tab-section')]")).size();

    }

    public void selectFirstTeam() {
        click(By.xpath("//li[contains(@data-test-id,'home-team-tab-section')]"));

    }

    public void openSettings() {
        click(By.cssSelector("[data-test-id='home-team-settings-tab']"));
    }

    public void delete() {
        click(By.cssSelector(".quiet-button"));
        if(!isElementPresent(By.cssSelector(".nch-button--danger"))){
            click(By.cssSelector(".quiet-button"));
        }
        click(By.cssSelector(".nch-button--danger"));


    }
}
