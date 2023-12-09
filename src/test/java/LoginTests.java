import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @Test(testName = "Login with Empty Email and Password", groups = "Regression")
    public void loginEmptyEmailPassword() {
        Assert.assertEquals(getDriver().getCurrentUrl(), url);
    }

    @Test(testName = "Login with valid credentials", groups = "Smoke")
    public void loginUserTest (){
        enterEmail("darina.mussulmanova@testpro.io");
        enterPassword("Darinam9!!");
        clickLoginButton();

        WebElement logoutButton = getDriver().findElement(By.xpath("//span[@id=\"userBadge\"]//i[@class='fa fa-sign-out']"));

        Assert.assertTrue(logoutButton.isDisplayed());
    }
}
