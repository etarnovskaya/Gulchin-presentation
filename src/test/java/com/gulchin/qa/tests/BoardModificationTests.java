package com.gulchin.qa.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.gulchin.qa.model.User;

public class BoardModificationTests extends TestBase{
    @BeforeClass
    public void ensurePreconditions() throws InterruptedException {
        /*if(user not logged in){
        *log in }*/
        if(!app.getUser().isUserLoggedIn()){
            app.getUser().login(new User()
                    .setEmail("rochman.elena@gmail.com")
                    .setPassword("12345.com"));
        }
    }

    @Test
    public void testBoardModification(){
//click on first board
        app.getBoard().clickOnTheFirstBoard();
//change name
        app.getBoard().changeName("jjj1");
//return to home

    }
}
