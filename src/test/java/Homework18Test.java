import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18Test extends BaseTest {

    public static final String SONG_NAME = "M33 Project - Emotional Soundtrack";

    @Test(testName = "Play Song Test and validate that the song is playing", groups = {"Smoke","Regression"})
    public void playSong() {
        enterEmail("darina.mussulmanova@testpro.io");
        enterPassword("Darinam9!!");
        clickLoginButton();

        WebElement allSongsClick = driver.findElement(By.xpath("//ul[@class='menu']//a[contains(@class,'songs')]"));
        allSongsClick.click();
        allSongsClick.click();

        WebElement selectSong = driver.findElement(By.xpath("//table[@class='items']//td[contains(text(),'" + SONG_NAME + "')]"));

        Actions actions = new Actions(getDriver());
        actions.doubleClick(selectSong).build().perform();

        WebElement songIsPlaying = driver.findElement(By.cssSelector("[data-testid='sound-bar-play']"));

        Assert.assertTrue(songIsPlaying.isDisplayed());
    }
}
