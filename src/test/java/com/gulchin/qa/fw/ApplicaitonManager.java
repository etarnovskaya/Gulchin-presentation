package com.gulchin.qa.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class ApplicaitonManager {
    WebDriver wd;
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
            wd= new ChromeDriver();
        } else if(browser.equals(BrowserType.FIREFOX)){
            wd = new FirefoxDriver();
        } else if(browser.equals(BrowserType.SAFARI)){
            wd = new SafariDriver();
        }






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
}
