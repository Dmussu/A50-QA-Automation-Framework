import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework21Test extends BaseTest {

    @Test
    public void renamePlaylistTest() throws InterruptedException {
        loginKoel("darina.mussulmanova@testpro.io", "Darinam9!!");

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//li[contains(@class, 'playlist')]//a[contains(text(),'HW17')]")));

        WebElement rightClickOnSelectedPlaylist = getDriver().findElement(By.xpath("//li[contains(@class, 'playlist')]//a[contains(text(),'HW17')]"));
        Actions actions = new Actions(getDriver());
        actions.contextClick(rightClickOnSelectedPlaylist).perform();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(text(), 'Edit')]")));

        WebElement editButtonClick = getDriver().findElement(By.xpath("//li[contains(text(), 'Edit')]"));
        editButtonClick.click();

        WebElement playListNameInputField = getDriver().findElement(By.xpath("//input[@name='name']"));
        actions.moveToElement(playListNameInputField);

        actions.moveToElement(playListNameInputField)
                .doubleClick().perform();
        actions.moveToElement(playListNameInputField)
                .sendKeys(Keys.DELETE)
                .sendKeys("HW21")
                .sendKeys(Keys.ENTER)
                .build().perform();
    }
}