package com.qa.koel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.swing.plaf.PanelUI;

public class HomePage extends BasePage{
    static final By LOGOUT_BUTTON = By.xpath("//span[@id=\"userBadge\"]//i[@class='fa fa-sign-out']");
    static final By CREATE_PLAYLIST_BUTTON = By.xpath("//i[@data-testid='sidebar-create-playlist-btn']");
    static final By NEW_PLAYLIST_BUTTON_FIELD = By.xpath("//li[@data-testid='playlist-context-menu-create-simple']");
    static final By NEW_PLAYLIST_NAME = By.xpath("//input[@name='name']");

    public HomePage(WebDriver driver) {
        super(driver);
    }
    public WebElement getLogoutButton() {
        return pageDriver.findElement(LOGOUT_BUTTON);
    }
    public WebElement getCreateNewPlaylistButton(){
        WebElement createNewPlaylistButton = pageDriver.findElement(CREATE_PLAYLIST_BUTTON);
        return createNewPlaylistButton;
    }
    public WebElement getNewPlaylistButtonField(){
        WebElement newPlaylistButtonField = pageDriver.findElement(NEW_PLAYLIST_BUTTON_FIELD);
        return newPlaylistButtonField;
    }
    public WebElement getNewPlaylistName(){
        WebElement newPlaylistName = pageDriver.findElement(NEW_PLAYLIST_NAME);
        return newPlaylistName;
    }
}
