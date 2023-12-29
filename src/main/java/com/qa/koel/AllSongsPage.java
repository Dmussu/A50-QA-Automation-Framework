package com.qa.koel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AllSongsPage extends BasePage{
    static final By ALL_SONGS_CLICK = By.xpath("//ul[@class='menu']//a[contains(@class,'songs')]");
    static final String SONG_NAME = "M33 Project - Emotional Soundtrack";
    static final By SELECT_SONG = By.xpath("//table[@class='items']//td[contains(text(),'" + SONG_NAME + "')]");
    static final By ADD_SELECTED_SONG_TO_BUTTON = By.xpath("//button[@title='Add selected songs to…']");
    static final String PLAY_LIST_NAME = "HW17";
    static final By ADD_SONG_TO_THE_PLAYLIST = By.xpath("//li[@class='playlist' and contains(text(), '" + PLAY_LIST_NAME + "')]\n");
    static final By PLAYLISTS = By.xpath("//*[@id=\"playlists\"]");
    static final By SOUND_BAR_PLAY = By.cssSelector("[data-testid='sound-bar-play']");

    public AllSongsPage(WebDriver driver) {
        super(driver);
    }
    public WebElement getAllSongsClick(){
        WebElement allSongsClick = pageDriver.findElement(ALL_SONGS_CLICK);
        return allSongsClick;
    }
    public WebElement getSelectSong(){
        WebElement selectSong = pageDriver.findElement(SELECT_SONG);
        return selectSong;
    }
    public WebElement getAddSelectedSongToButton(){
        WebElement addSelectedSongToButton =pageDriver.findElement(ADD_SELECTED_SONG_TO_BUTTON);
        return addSelectedSongToButton;
    }
    public WebElement getAddSongToThePlaylist(){
        WebElement addSongToThePlaylist = pageDriver.findElement(ADD_SONG_TO_THE_PLAYLIST);
        return addSongToThePlaylist;
    }
    public WebElement getPlaylists(){
        WebElement playlists = pageDriver.findElement(PLAYLISTS);
        return playlists;
    }
    public WebElement getSoundBarPlay(){
        WebElement soundBarPlay = pageDriver.findElement(SOUND_BAR_PLAY);
        return soundBarPlay;
    }
}
