package com.qa.koel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework16Test extends BaseTest {

    @Test(testName = "Registration Navigation Test", groups = {"Smoke", "Regression"})
    public void testRegistrationNavigation() {

        WebElement registrationLink = getDriver().findElement(By.xpath("//form[@data-testid='login-form']//a[contains(@href,'registration')]"));
        registrationLink.click();
        WebElement submitButton = getDriver().findElement(By.xpath("//input[@id='button']"));
        Assert.assertTrue(submitButton.isDisplayed());
    }
}
