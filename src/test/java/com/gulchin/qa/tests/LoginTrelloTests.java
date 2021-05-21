package com.gulchin.qa.tests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.gulchin.qa.model.User;

public class LoginTrelloTests extends TestBase {


    @BeforeMethod
    public void ensurePreconditions(){
        if(app.getUser().isUserLoggedIn()){
            app.getUser().logout();
        } else if (!app.getUser().isButtonLoginPresent()){
            app.openSite("https://trello.com/");
        }
    }

    @Test
    public void atlassianLoginTest() throws InterruptedException {

        app.getUser().startLogin();
        app.getUser().fillLoginForm(new User()
                .setEmail("rochman.elena@gmail.com")
                .setPassword("12345.com"));
        app.getUser().confirmLogin();

        Assert.assertTrue(app.getHeader().isAvatarPresent());
        String accountEmail = app.getUser().getAccountEmail();
        Assert.assertEquals(accountEmail, "rochman.elena@gmail.com");

    }

    @Test(enabled = false)

    public void negativeAtlassianLoginWithputPasswordTest() throws InterruptedException {
        app.getUser().startLogin();
        app.getUser().fillLoginForm(new User().setEmail("rochman.elena@gmail.com"));
        app.getUser().confirmLogin();

    }

    @Test(enabled = false)


    public void testLogin() {
        app.getUser().startLogin();
        app.getUser().clickLoginWithGoogle();
        app.getUser().authorizeGoogle("gulchin1212@gmail.com");

    }

}
