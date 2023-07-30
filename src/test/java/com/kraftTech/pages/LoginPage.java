package com.kraftTech.pages;


import com.kraftTech.utilities.ConfigurationReader;
import com.kraftTech.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;


public class LoginPage extends BasePage {

    @FindBy(css = "#email")
    public WebElement emailInputBox;

    @FindBy(css = "#yourPassword")
    public WebElement passwordInputBox;

    @FindBy(xpath = "//button[text()='Login']")
    public WebElement loginButton;

    @FindBy(xpath = "//div[contains(text(),'incorrect')]")
    public WebElement passwordErrorMessage;

    @FindBy(xpath = "//div[contains(text(),'address')]")
    public WebElement usernameErrorMessage;

    //AND logic
    @FindBys({
            @FindBy(css = "#email"),
            @FindBy(name = "email")
    })
    public WebElement emailInputBoxWithFindBys;

    //OR logic
    @FindAll({
            @FindBy(id = "email"),
            @FindBy(name = "anOtherName")
    })
    public WebElement emailInputBoxWithFindAll;

    public void login(String userEmail, String password){
        emailInputBox.sendKeys(userEmail);
        passwordInputBox.sendKeys(password);
        loginButton.click();
    }

    //method OVERLOADİNG
    public void login(){
        emailInputBox.sendKeys(ConfigurationReader.get("userEmail"));
        passwordInputBox.sendKeys(ConfigurationReader.get("userPassword"));
        loginButton.click();
    }
    public String getWarningMessageText(String message){
        return Driver.get().findElement(By.xpath("//div[contains(text(),'"+message+"')]")).getText();
    }

}