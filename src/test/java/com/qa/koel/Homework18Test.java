package com.qa.koel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18Test extends BaseTest {

   LoginPage loginPage;
   AllSongsPage allSongsPage;
    public static final String SONG_NAME = "M33 Project - Emotional Soundtrack";

    @Test(testName = "Play Song Test and validate that the song is playing", groups = {"Smoke","Regression"})
    public void playSong() {

        loginPage = new LoginPage(getDriver());
        loginPage.loginKoel("darina.mussulmanova@testpro.io", "Darinam9!!");

        allSongsPage = new AllSongsPage(getDriver());
        allSongsPage.getAllSongsClick();
        allSongsPage.getAllSongsClick().click();
        allSongsPage.getAllSongsClick().click();

        allSongsPage.getSelectSong();
        Actions actions = new Actions(getDriver());
        actions.doubleClick(allSongsPage.getSelectSong()).build().perform();

        allSongsPage.getSoundBarPlay();

        Assert.assertTrue(allSongsPage.getSoundBarPlay().isDisplayed());
    }
}
