package com.gulchin.qa.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HeaderHelper extends  HelperBase{
    public HeaderHelper(WebDriver wd) {
        super(wd);
    }

    public void clickOnThePlusButton() {
        click(By.cssSelector("[data-test-id='header-create-menu-button']"));
    }


    public boolean isAvatarPresent() {
        new WebDriverWait(wd, 15).
                until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-test-id='header-member-menu-button']")));

        return isElementPresent(By.cssSelector("[data-test-id='header-member-menu-button']"));
    }

//    public void waitForElement(WebElement element){
//        new WebDriverWait(wd, 20)
//                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(locator)));
//    }

    public void clickOnTheAvatar() {
        click(By.cssSelector("[data-test-id='header-member-menu-button']"));
    }

    public void clickOnHomeButtonOnHeader() {
        new WebDriverWait(wd, 15).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[data-test-id='header-home-button']"))).click();

        click(By.cssSelector("a[data-test-id='header-home-button']"));

        //.icon-back
    }
}
