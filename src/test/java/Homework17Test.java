import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17Test extends BaseTest {

    public static final String PLAY_LIST_NAME = "HW17";
    public static final String SONG_NAME = "M33 Project - Emotional Soundtrack";

    @Test(testName = "Create user playlist and add song to the playlist test", groups = {"Smoke", "Regression"})
    public void addSongToPlaylistTest() throws InterruptedException {

        enterEmail("darina.mussulmanova@testpro.io");
        enterPassword("Darinam9!!");
        clickLoginButton();

        Thread.sleep(1000);

        WebElement createNewPlaylistButton = driver.findElement(By.xpath("//i[@data-testid='sidebar-create-playlist-btn']"));
        createNewPlaylistButton.click();

        WebElement newPlaylistButtonField = driver.findElement(By.xpath("//li[@data-testid='playlist-context-menu-create-simple']"));
        newPlaylistButtonField.click();

        WebElement newPlaylistName = driver.findElement(By.xpath("//input[@name='name']"));
        newPlaylistName.sendKeys(PLAY_LIST_NAME);
        newPlaylistName.submit();

        WebElement allSongsClick = driver.findElement(By.xpath("//ul[@class='menu']//a[contains(@class,'songs')]"));
        allSongsClick.click();
        allSongsClick.click();

        WebElement selectSong = driver.findElement(By.xpath("//table[@class='items']//td[contains(text(),'" + SONG_NAME + "')]"));
        selectSong.click();

        WebElement addToButton = driver.findElement(By.xpath("//button[@title='Add selected songs to…']"));
        addToButton.click();

        WebElement addSongToThePlaylist = driver.findElement(By.xpath("//li[@class='playlist' and contains(text(), '" + PLAY_LIST_NAME + "')]\n"));
        addSongToThePlaylist.click();

        WebElement playlists = driver.findElement(By.xpath("//*[@id=\"playlists\"]"));
        WebElement playlist = playlists.findElement(By.linkText(PLAY_LIST_NAME));
        playlist.click();

        WebElement addedSong = driver.findElement(By.xpath("//*[@id=\"playlistWrapper\"]//td[@class='title']"));

        Assert.assertEquals(addedSong.getText(), SONG_NAME);
    }
}

