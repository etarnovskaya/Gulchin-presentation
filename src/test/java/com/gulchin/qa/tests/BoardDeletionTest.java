package com.gulchin.qa.tests;

import com.gulchin.qa.model.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardDeletionTest extends TestBase{
    @Test
    public void testBoardDeletion() throws InterruptedException {
        app.getUser().startLogin();
        app.getUser().fillLoginForm(new User()
                .setEmail("rochman.elena@gmail.com")
                .setPassword("12345.com"));
        app.getUser().confirmLogin();

           int before = app.getBoard().getBoardsCount();

//while (before>4) {
    app.getBoard().openFirstPrivateBoard();
    app.getBoard().initBoardDeletion();
    app.getBoard().confirmBoardDeletion();//.js-delete
    app.getBoard().confirmFinishBoardDeletion();//.js-confirm.full
    app.getHeader().clickOnHomeButtonOnHeader();//[href='/']
    //int after = app.getBoard().getBoardsCount();
    before = app.getBoard().getBoardsCount();
//}

         //   Assert.assertEquals(after, before-1);

        }
}
