import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;

public class Homework18Test extends BaseTest {

    public static final String SONG_NAME = "M33 Project - Emotional Soundtrack";

    @Test(testName = "Play Song Test", groups = {"Smoke","Regression"})
    public void playSong() {
        enterEmail("darina.mussulmanova@testpro.io");
        enterPassword("Darinam9!!");
        clickLoginButton();

        WebElement allSongsClick = getDriver().findElement(By.xpath("//ul[@class='menu']//a[contains(@class,'songs')]"));
        allSongsClick.click();
        allSongsClick.click();

        WebElement selectSong = getDriver().findElement(By.xpath("//table[@class='items']//td[contains(text(),'" + SONG_NAME + "')]"));

        Actions actions = new Actions(getDriver());
        actions.doubleClick(selectSong).build().perform();

        WebElement marvelousVisualizer =getDriver().findElement(By.xpath("//div[@data-testid='sound-bar-play']"));
        Assert.assertTrue(marvelousVisualizer.isDisplayed());


    }

}