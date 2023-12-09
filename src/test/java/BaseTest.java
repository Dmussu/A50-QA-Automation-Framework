import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BaseTest {

    WebDriver driver = null;
    String url = "https://qa.koel.app/";

//    public static final String URL = "https://qa.koel.app/";
//    public static final String EMAIL = "darina.mussulmanova@testpro.io";
//    public static final String PASSWORD = "Darinam9!!";

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    public void setupDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get(url);
    }

    public WebDriver getDriver(){
        return driver;
    }

    @AfterMethod
    public void closeBrowser(){
        getDriver().quit();
    }

    public void enterEmail (String email ){
        WebElement emailField = getDriver().findElement(By.xpath("//input[@type='email']"));
        emailField.sendKeys(email);
    }

    public void enterPassword (String password){
        WebElement passwordField = getDriver().findElement(By.xpath("//input[@type='password']"));
        passwordField.sendKeys(password);
    }

    public void clickLoginButton (){
        WebElement loginButton = getDriver().findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
    }
}
