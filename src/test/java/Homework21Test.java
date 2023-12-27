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

    @Test
    public void renamePlaylistTest() throws InterruptedException {
        loginKoel("darina.mussulmanova@testpro.io", "Darinam9!!");

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//li[contains(@class, 'playlist')]//a[contains(text(),'HW17')]")));

        List<WebElement> playlists = getDriver().findElements(By.xpath("//li[contains(@class, 'playlist')]"));

        for (WebElement playlist : playlists) {
            if (playlist.getText().equals("HW17")) {
                actions.contextClick(playlist).perform();
            }
        }

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(text(), 'Edit')]")));

        WebElement editButtonClick = getDriver().findElement(By.xpath("//li[contains(text(), 'Edit')]"));
        editButtonClick.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[name='name']")));
        WebElement playListNameInputField = getDriver().findElement(By.cssSelector("[name='name']"));

        actions.moveToElement(playListNameInputField)
                .doubleClick().perform();
        actions.moveToElement(playListNameInputField)
                .sendKeys(Keys.COMMAND, "a")
                .sendKeys(Keys.DELETE)
                .sendKeys("HW21")
                .sendKeys(Keys.ENTER)
                .build().perform();

        WebElement renamedPlaylist = getDriver().findElement(By.xpath("//li[contains(@class, 'playlist')]//a[contains(text(),'HW21')]"));
        Assert.assertTrue(renamedPlaylist.isDisplayed(), "Playlist has not been renamed to 'HW21'");
    }
}
