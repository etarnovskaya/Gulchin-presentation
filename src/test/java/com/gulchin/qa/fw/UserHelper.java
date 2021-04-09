package com.gulchin.qa.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.gulchin.qa.model.User;

public class UserHelper extends  HelperBase{
    public UserHelper(WebDriver wd) {
        super(wd);
    }
    HeaderHelper header = new HeaderHelper(wd);

    public void confirmLogin() {
        click(By.cssSelector("#login-submit"));
    }

    public void fillLoginForm(User user) throws InterruptedException {
        type(By.cssSelector("#user"), user.getEmail());

        Thread.sleep(2000);

        click(By.cssSelector("#login"));

//        click(By.cssSelector("#password"));
//        wd.findElement(By.cssSelector("#password")).clear();
//        wd.findElement(By.cssSelector("#password")).sendKeys("12345.com");

        type(By.cssSelector("#password"), user.getPassword());
    }

    public void startLogin() {
        click(By.cssSelector("[href='/login']"));
    }

    public void authorizeGoogle(String email) {
        click(By.cssSelector("#identifierId"));
        wd.findElement(By.cssSelector("#identifierId")).sendKeys(email);
    }

    public void clickLoginWithGoogle() {
        click(By.cssSelector("#googleButton"));
    }

    public String getAccountEmail() {
        header.clickOnTheAvatar();
        return wd.findElement(By.cssSelector("._2TvKKP0vwCN5Zd")).getText();
    }

    public boolean isUserLoggedIn() {
        //homeButton
        return isElementPresent(By.cssSelector("[data-test-id='header-home-button']"));
    }

    public void login(User user) throws InterruptedException {
        startLogin();
        fillLoginForm(user);
        confirmLogin();
    }

    public void logout() {
        header.clickOnTheAvatar();
        clickLogout();
        confirmLogout();
    }

    private void confirmLogout() {
        click(By.cssSelector("[id='logout-submit']"));
    }

    private void clickLogout() {
        click(By.cssSelector("[data-test-id='header-member-menu-logout']"));
    }

    public boolean isButtonLoginPresent() {
        return isElementPresent(By.cssSelector("[href='/login']"));
    }
}
