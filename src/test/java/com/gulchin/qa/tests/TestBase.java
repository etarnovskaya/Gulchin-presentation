package com.gulchin.qa.tests;

import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;
import com.gulchin.qa.fw.ApplicaitonManager;

import java.lang.reflect.Method;

public class TestBase {

    protected static ApplicaitonManager app = new ApplicaitonManager(System.getProperty("browser", BrowserType.CHROME));
    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeMethod
    public void startLogger(Method m) {

        logger.info("start test " + m.getName());
    }


    @AfterMethod

    public void stopLogger(Method m) {
        logger.info("stop test " + m.getName());
    }


    @BeforeSuite
    public void setUp() {

        app.init();
    }

    @AfterSuite(enabled = true)
    public void tearDown() {
        app.stop();
    }

}
