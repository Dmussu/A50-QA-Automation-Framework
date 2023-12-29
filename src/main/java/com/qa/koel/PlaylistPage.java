package com.qa.koel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PlaylistPage extends BasePage{
    static final By DELETE_PLAYLIST_BUTTON = By.xpath("//button[@title='Delete this playlist' and contains(@class, 'btn-delete-playlist')]");
    static final By EDIT_PLAYLIST_BUTTON = By.xpath("//li[contains(text(), 'Edit')]");
    static final By PLAYLIST_NAME_IMPUT_FIELD = By.cssSelector("[name='name']");
    public PlaylistPage(WebDriver driver) {
        super(driver);
    }
    public WebElement getDeletePlaylistButton(){
        WebElement deletePlaylistButton = pageDriver.findElement(DELETE_PLAYLIST_BUTTON);
        return deletePlaylistButton;
    }
    public WebElement getEditButtonClick(){
        WebElement editButtonClick = pageDriver.findElement(EDIT_PLAYLIST_BUTTON);
        return editButtonClick;
    }
    public WebElement getPlayListNameInputField(){
        WebElement playListNameInputField = pageDriver.findElement(PLAYLIST_NAME_IMPUT_FIELD);
        return playListNameInputField;
    }
}
