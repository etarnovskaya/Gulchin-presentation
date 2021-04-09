package com.gulchin.qa.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardCreationTest extends TestBase{

    @BeforeMethod
    public void insurePreconditions(){
        //if user logged in

    }

    @Test
    public void testBoardCreation(){
        app.getHeader().clickOnThePlusButton();
        app.getBoard().initBoardCreationFromHeader();
    }

}
