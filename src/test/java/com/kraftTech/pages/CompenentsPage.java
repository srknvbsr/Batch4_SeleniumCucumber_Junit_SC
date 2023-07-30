package com.kraftTech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CompenentsPage extends BasePage {
    @FindBy(xpath = "//a[.='Home']")
    public WebElement homebutton;

    @FindBy(xpath = "//li[.='Components']")
    public WebElement dashboardText;

    @FindBy(css = "main#main li:nth-of-type(3)")
    public WebElement title3;

    public String getHomeButtonText() {
        return homebutton.getText();
    }

    public String getDashBoardText() {
       return dashboardText.getText();
    }
    public String getTitleText3(){
        return title3.getText();
    }

}
