package com.kraftTech.pages;

import com.kraftTech.utilities.BrowserUtils;
import com.kraftTech.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class UserProfilePage extends BasePage {

    @FindBy(css = "[role='alert']")
    public WebElement updateMessage;

    @FindBy(css = "[class='nav nav-tabs nav-tabs-bordered']>li")
    public List<WebElement> tabList;

    @FindBy(css = ".breadcrumb>li:nth-of-type(2)")
    public WebElement userProfilePageTitle;



    public void navigateToOverViewMenu(String tab) {
        WebElement tabElement = Driver.get().findElement(By.xpath("//li/button[.='" + tab + "']"));
        tabElement.click();
    }

    public String addedEducation(String schoolName){
        return Driver.get().findElement(By.xpath("(//span[text()='"+schoolName+"'])[last()]")).getText();
    }
    public void deleteEducationRecord(String schoolName){
        WebElement element = Driver.get().findElement(By.xpath("(//span[text()='"+schoolName+"'])[last()]/ancestor::tr//a"));
        BrowserUtils.clickWithJS(element);
        BrowserUtils.waitFor(2);
        Driver.get().switchTo().alert().accept();
    }

    public String updateMessageGetText() {

        return updateMessage.getText();
    }



}
