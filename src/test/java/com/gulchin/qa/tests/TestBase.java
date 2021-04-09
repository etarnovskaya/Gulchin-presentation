package com.gulchin.qa.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.gulchin.qa.fw.ApplicaitonManager;

public class TestBase {

    protected static ApplicaitonManager app = new ApplicaitonManager(System.getProperty("browser", BrowserType.CHROME));

    @BeforeSuite
    public void setUp(){

        app.init();
    }

    @AfterSuite(enabled = false)
    public void tearDown(){
        app.stop();
    }

}
