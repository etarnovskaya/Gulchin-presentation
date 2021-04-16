package com.gulchin.qa.tests;

import com.gulchin.qa.model.User;
import org.testng.annotations.Test;

public class TeamDeletionTest extends TestBase{
@Test
    public void teamDeletionTest() throws InterruptedException {
    app.getUser().startLogin();
    app.getUser().fillLoginForm(new User()
            .setEmail("rochman.elena@gmail.com")
            .setPassword("12345.com"));
    app.getUser().confirmLogin();

    int before = app.getBoard().getBoardsCount();
    int count = app.getTeam().getTeamsCount();
   // while (count>1) {


        app.getTeam().selectFirstTeam();
        app.getTeam().openSettings();
        app.getTeam().delete();
        count = app.getTeam().getTeamsCount();
   // }
}
}
