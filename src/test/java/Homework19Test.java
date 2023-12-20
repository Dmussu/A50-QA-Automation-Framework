import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework19Test extends BaseTest {

    public static final String PLAY_LIST_NAME = "HW19";

    @Test(testName = "Delete Playlist Test", groups = {"Smoke", "Regression"})
    public void deletePlaylist() throws InterruptedException {
        loginKoel("darina.mussulmanova@testpro.io","Darinam9!!");

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//i[@data-testid='sidebar-create-playlist-btn']")));

        WebElement createNewPlaylistButton = driver.findElement(By.xpath("//i[@data-testid='sidebar-create-playlist-btn']"));
        createNewPlaylistButton.click();

        WebElement newPlaylistButtonField = driver.findElement(By.xpath("//li[@data-testid='playlist-context-menu-create-simple']"));
        newPlaylistButtonField.click();

        WebElement newPlaylistName = driver.findElement(By.xpath("//input[@name='name']"));
        newPlaylistName.sendKeys(PLAY_LIST_NAME);
        newPlaylistName.submit();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[@title='Delete this playlist' and contains(@class, 'btn-delete-playlist')]")));

        WebElement deletePlaylistButton = driver.findElement(By.xpath("//button[@title='Delete this playlist' and contains(@class, 'btn-delete-playlist')]"));
        deletePlaylistButton.click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//a[contains(@class, 'active') and contains(text(), 'HW19')]")));

        Assert.assertFalse(isPlaylistPresent(PLAY_LIST_NAME), "Playlist was not deleted successfully");
    }

    public boolean isPlaylistPresent(String playListName) {
        try {
            WebElement playlistElement = driver.findElement(By.xpath("//a[contains(@class, 'active') and contains(text(), '" + playListName + "')]"));
            return playlistElement.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
}

