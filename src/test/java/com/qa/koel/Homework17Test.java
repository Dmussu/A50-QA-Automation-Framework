package com.qa.koel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework17Test extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;
    AllSongsPage allSongsPage;
    public static final String PLAY_LIST_NAME = "HW17";
    public static final String SONG_NAME = "M33 Project - Emotional Soundtrack";

    @Test(testName = "Create user playlist and add song to the playlist test", groups = {"Smoke", "Regression"})
    public void addSongToPlaylistTest() throws InterruptedException {
        loginPage = new LoginPage(getDriver());
        loginPage.loginKoel("darina.mussulmanova@testpro.io", "Darinam9!!");

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//i[@data-testid='sidebar-create-playlist-btn']")));
        homePage = new HomePage(getDriver());
        homePage.getCreateNewPlaylistButton().click();
        homePage.getNewPlaylistButtonField().click();

        homePage.getNewPlaylistName();
        homePage.getNewPlaylistName().sendKeys(PLAY_LIST_NAME);
        homePage.getNewPlaylistName().submit();

        allSongsPage = new AllSongsPage(getDriver());
        allSongsPage.getAllSongsClick();
        allSongsPage.getAllSongsClick().click();
        allSongsPage.getAllSongsClick().click();

        allSongsPage.getSelectSong();
        allSongsPage.getSelectSong().click();

        allSongsPage.getAddSelectedSongToButton();
        allSongsPage.getAddSelectedSongToButton().click();

        allSongsPage.getAddSongToThePlaylist();
        allSongsPage.getAddSongToThePlaylist().click();

        WebElement playlist = allSongsPage.getPlaylists().findElement(By.linkText(PLAY_LIST_NAME));
        playlist.click();

        WebElement addedSong = getDriver().findElement(By.xpath("//*[@id=\"playlistWrapper\"]//td[@class='title']"));

        Assert.assertEquals(addedSong.getText(), SONG_NAME);
    }
}

