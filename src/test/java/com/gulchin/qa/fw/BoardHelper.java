package com.gulchin.qa.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BoardHelper extends  HelperBase{

    public BoardHelper(WebDriver wd) {
        super(wd);
    }

    public void initBoardCreationFromHeader() {
        click(By.cssSelector("[data-test-id='header-create-board-button']"));
    }

    public void clickOnTheFirstBoard() {
        click(By.xpath("//*[@class = 'icon-lg icon-member']/../../..//li"));
    }

    public void changeName() {
        click(By.cssSelector("h1"));
        wd.findElement(By.xpath("//*[contains(@class, 'js-board-name-input')]")).sendKeys( "jjj" + Keys.ENTER);
    }

    public void openAdvancedMenu() {
//        click(By.);
    }

    public void openFirstPrivateBoard() {

            new WebDriverWait(wd, 15).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class = 'boards-page-board-section-header-name' and contains(., 'Personal boards')]/../..")));
            WebElement privateBoardsList = wd.findElement(By.xpath("//*[@class = 'boards-page-board-section-header-name' and contains(., 'Personal boards')]/../.."));
        //    String boardNameForDelete = privateBoardsList.findElement(By.xpath(".//li")).getText();
          //  System.out.println("Delete board: ");
            privateBoardsList.findElement(By.xpath(".//li")).click();

    }

    public void initBoardDeletion() {
        clickMoreButtonInTheMenu();
        clickCloseBoardButton();
        confirmCloseButton();
    }

    private void confirmCloseButton() {
        click(By.cssSelector(".js-confirm.full.nch-button--danger"));
    }

    private void clickCloseBoardButton() {
        click(By.cssSelector(".board-menu-navigation-item-link.js-close-board"));
    }

    private void clickMoreButtonInTheMenu() {
//        WebElement menuButton = wd.findElement(By.cssSelector(".board-header-btn.mod-show-menu"));
//        System.out.println(menuButton.getCssValue("visibility"));
//        if(menuButton.getCssValue("visibility").equals("visible")){
//            click(By.cssSelector(".mod-show-menu"));
        if(!isElementPresent(By.cssSelector(".js-open-more"))){
            if(wd.findElement(By.cssSelector(".board-menu-header-back-button ")).isEnabled())

            click(By.cssSelector(".icon-back"));


        }else {
            click(By.xpath("//span[contains(., 'Show menu')]"));
        }
            click(By.cssSelector(".js-open-more"));

    }

    public void confirmBoardDeletion() {
        new WebDriverWait(wd, 10)
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector(".js-delete")));
        click(By.cssSelector(".js-delete"));
    }

    public void confirmFinishBoardDeletion() {
        click(By.cssSelector(".js-confirm.full"));
    }

    public int getBoardsCount() {
        new WebDriverWait(wd, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class = 'boards-page-board-section-header-name' and contains(., 'Personal boards')]/../..//li")));
        List<WebElement> boards = wd.findElements(By.xpath("//*[@class = 'boards-page-board-section-header-name' and contains(., 'Personal boards')]/../..//li"));

        return boards.size()-1;
    }
}
