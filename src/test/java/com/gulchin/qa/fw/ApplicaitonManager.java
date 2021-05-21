package com.gulchin.qa.fw;

import com.google.common.io.Files;
import com.gulchin.qa.tests.TestBase;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ApplicaitonManager {

    public static class MyListener extends AbstractWebDriverEventListener {
        Logger logger = LoggerFactory.getLogger(TestBase.class);
        @Override
        public void beforeFindBy(By by, WebElement element, WebDriver driver) {
           logger.info("start search element "+by);
        }

        @Override
        public void afterFindBy(By by, WebElement element, WebDriver driver) {
             logger.info("element " +by +"found");
        }

        @Override
        public void onException(Throwable throwable, WebDriver driver) {
            logger.error("Error!", throwable);

            try {
                new ApplicaitonManager(System.getProperty("browser", BrowserType.CHROME)).screenshot();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    EventFiringWebDriver wd;
    UserHelper user;
    BoardHelper board;
    TeamHelper team;
    HeaderHelper header;
    String browser;

    public ApplicaitonManager(String browser) {

        this.browser = browser;
    }

    public void init() {
        if(browser.equals(BrowserType.CHROME)){
            wd= new EventFiringWebDriver(new ChromeDriver());
        } else if(browser.equals(BrowserType.FIREFOX)){
            wd = new EventFiringWebDriver(new FirefoxDriver());
        } else if(browser.equals(BrowserType.SAFARI)){
            wd = new EventFiringWebDriver(new SafariDriver());
        }


        wd.register(new MyListener());
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        openSite("https://trello.com/");
        user = new UserHelper(wd);
        board = new BoardHelper(wd);
        team = new TeamHelper(wd);
        header = new HeaderHelper(wd);
    }



    public void openSite(String url) {
          wd.get(url);
      }

    public void stop() {
        wd.quit();
    }

    public UserHelper getUser() {
        return user;
    }

    public BoardHelper getBoard() {
        return board;
    }

    public TeamHelper getTeam() {
        return team;
    }

    public HeaderHelper getHeader() {
        return header;
    }

    public void screenshot() throws IOException {
        File tmp = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
        File screenshot = new File("Screen-" + System.currentTimeMillis() + ".png");
        try {
            Files.copy(tmp, screenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

