package com.qa.koel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    LoginPage loginPage; // driver = null
    HomePage homePage;
    @Test(testName = "Login with Empty Email and Password", groups = "Regression")
    public void loginEmptyEmailPassword() {
        Assert.assertEquals(getDriver().getCurrentUrl(), url);
    }

    @Test(testName = "Login with valid credentials", groups = "Smoke")
    public void loginUserTest (){
        loginPage = new LoginPage(getDriver());
        homePage = new HomePage(getDriver());
        loginPage.loginKoel("darina.mussulmanova@testpro.io","Darinam9!!");

        Assert.assertTrue(homePage.getLogoutButton().isDisplayed());
    }
}
