package com.qa.koel;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Homework21Test extends BaseTest {
    LoginPage loginPage;
    PlaylistPage playlistPage;

    @Test
    public void renamePlaylistTest() throws InterruptedException {

        loginPage = new LoginPage(getDriver());
        loginPage.loginKoel("darina.mussulmanova@testpro.io", "Darinam9!!");

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//li[contains(@class, 'playlist')]//a[contains(text(),'HW17')]")));

        List<WebElement> playlists = getDriver().findElements(By.xpath("//li[contains(@class, 'playlist')]"));

        for (WebElement playlist : playlists) {
            if (playlist.getText().equals("HW17")) {
                actions.contextClick(playlist).perform();
            }
        }

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(text(), 'Edit')]")));

        playlistPage = new PlaylistPage(getDriver());
        playlistPage.getEditButtonClick().click();

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[name='name']")));
        playlistPage.getPlayListNameInputField();

        actions.moveToElement(playlistPage.getPlayListNameInputField())
                .doubleClick().perform();
        actions.moveToElement(playlistPage.getPlayListNameInputField())
                .sendKeys(Keys.COMMAND, "a")
                .sendKeys(Keys.DELETE)
                .sendKeys("HW21")
                .sendKeys(Keys.ENTER)
                .build().perform();

        WebElement renamedPlaylist = getDriver().findElement(By.xpath("//li[contains(@class, 'playlist')]//a[contains(text(),'HW21')]"));
        Assert.assertTrue(renamedPlaylist.isDisplayed(), "Playlist has not been renamed to 'HW21'");
    }
}
