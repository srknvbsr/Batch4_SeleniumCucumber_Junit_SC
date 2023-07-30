package com.kraftTech.pages;


import com.kraftTech.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class EditProfilePage extends BasePage {


    @FindBy(css = "#about")
    public WebElement  aboutInputBox;

    @FindBy(xpath = "(//input[@id='company'])[1]")
    public WebElement companyInputBox;

    @FindBy(xpath = "//select[@id='job']")
    public WebElement jobInputBox;

    @FindBy(css = "#website")
    public WebElement websiteInputBox;

    @FindBy(xpath = "(//input[@id='location'])[1]")
    public WebElement locationInputBox;

    @FindBy(css = "#skills")
    public WebElement skillsInputBox;

    @FindBy(xpath = "//*[.='Save Changes']")
    public WebElement saveChangeBtn;

    public void selectJob(String jobOption) {
        Select select = new Select(jobInputBox);
        select.selectByVisibleText(jobOption);
    }
    public void editProfilInfo(String inputBoxName,String userInformation){
        WebElement inputbox = Driver.get().findElement(By.name(inputBoxName));
        inputbox.clear();
        inputbox.sendKeys(userInformation);
    }


    public String getSelectedJob(String job){
        Select select = new Select(jobInputBox);
        return select.getFirstSelectedOption().getText();
    }
    public void editProfileInfo(String inputBoxName,String userInformation){
        WebElement inputBox = Driver.get().findElement(By.name(inputBoxName));
        inputBox.clear();
        inputBox.sendKeys(userInformation);
    }

}

