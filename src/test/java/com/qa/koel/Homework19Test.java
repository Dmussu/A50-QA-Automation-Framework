package com.qa.koel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework19Test extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;
    PlaylistPage playlistPage;
    public static final String PLAY_LIST_NAME = "HW19";

    @Test(testName = "Delete Playlist Test", groups = {"Smoke", "Regression"})
    public void deletePlaylist() throws InterruptedException {

        loginPage = new LoginPage(getDriver());
        homePage = new HomePage(getDriver());
        playlistPage = new PlaylistPage(getDriver());

        loginPage.loginKoel("darina.mussulmanova@testpro.io", "Darinam9!!");

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//i[@data-testid='sidebar-create-playlist-btn']")));

        homePage.getCreateNewPlaylistButton().click();

        homePage.getNewPlaylistButtonField().click();

        homePage.getNewPlaylistName();
        homePage.getNewPlaylistName().sendKeys(PLAY_LIST_NAME);
        homePage.getNewPlaylistName().submit();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[@title='Delete this playlist' and contains(@class, 'btn-delete-playlist')]")));

        playlistPage.getDeletePlaylistButton();
        playlistPage.getDeletePlaylistButton().click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//a[contains(@class, 'active') and contains(text(), 'HW19')]")));

        Assert.assertFalse(isPlaylistPresent(PLAY_LIST_NAME), "Playlist was not deleted successfully");
    }

    public boolean isPlaylistPresent(String playListName) {
        try {
            WebElement playlistElement = getDriver().findElement(By.xpath("//a[contains(@class, 'active') and contains(text(), '" + playListName + "')]"));
            return playlistElement.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
}

