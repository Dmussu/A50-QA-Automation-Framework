import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework17Test extends BaseTest {

    public static final String PLAY_LIST_NAME = "HW17";
    public static final String SONG_NAME = "M33 Project - Emotional Soundtrack";

    @Test(testName = "Create user playlist and add song to the playlist test", groups = {"Smoke", "Regression"})
    public void addSongToPlaylistTest() throws InterruptedException {

        loginKoel("darina.mussulmanova@testpro.io","Darinam9!!");

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//i[@data-testid='sidebar-create-playlist-btn']")));

        WebElement createNewPlaylistButton = getDriver().findElement(By.xpath("//i[@data-testid='sidebar-create-playlist-btn']"));
        createNewPlaylistButton.click();

        WebElement newPlaylistButtonField = getDriver().findElement(By.xpath("//li[@data-testid='playlist-context-menu-create-simple']"));
        newPlaylistButtonField.click();

        WebElement newPlaylistName = getDriver().findElement(By.xpath("//input[@name='name']"));
        newPlaylistName.sendKeys(PLAY_LIST_NAME);
        newPlaylistName.submit();

        WebElement allSongsClick = getDriver().findElement(By.xpath("//ul[@class='menu']//a[contains(@class,'songs')]"));
        allSongsClick.click();
        allSongsClick.click();

        WebElement selectSong = getDriver().findElement(By.xpath("//table[@class='items']//td[contains(text(),'" + SONG_NAME + "')]"));
        selectSong.click();

        WebElement addToButton =getDriver().findElement(By.xpath("//button[@title='Add selected songs to…']"));
        addToButton.click();

        WebElement addSongToThePlaylist = getDriver().findElement(By.xpath("//li[@class='playlist' and contains(text(), '" + PLAY_LIST_NAME + "')]\n"));
        addSongToThePlaylist.click();

        WebElement playlists = getDriver().findElement(By.xpath("//*[@id=\"playlists\"]"));
        WebElement playlist = playlists.findElement(By.linkText(PLAY_LIST_NAME));
        playlist.click();

        WebElement addedSong = getDriver().findElement(By.xpath("//*[@id=\"playlistWrapper\"]//td[@class='title']"));

        Assert.assertEquals(addedSong.getText(), SONG_NAME);
    }
}

