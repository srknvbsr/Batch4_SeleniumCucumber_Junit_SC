package com.kraftTech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomeWorkPage extends BasePage{
    @FindBy(xpath = "//div[@class='category-cards']/div")
    public List<WebElement> demoqatabList;

}
