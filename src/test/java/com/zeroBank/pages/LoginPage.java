package com.zeroBank.pages;

import com.zeroBank.pages.base.BasePage;
import com.zeroBank.utilities.ConfigurationReader;
import com.zeroBank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "user_login")
    public WebElement usernameIB;

    @FindBy(id = "user_password")
    public WebElement passwordIB;

    @FindBy(name = "submit")
    public WebElement signInBtn;

    @FindBy(xpath = "//div[@class='alert alert-error']")
    public WebElement invalidCredErrorMsg;

    public void loginValid(){
        usernameIB.sendKeys(ConfigurationReader.getProperty("username"));
        passwordIB.sendKeys(ConfigurationReader.getProperty("password"));
        signInBtn.click();
    }


    public void loginInvalid(){
        usernameIB.sendKeys(randomLetters(10));
        passwordIB.sendKeys(randomLetters(10));
        signInBtn.click();
    }


    public void loginWithCred(String username, String password){
        usernameIB.sendKeys(username);
        passwordIB.sendKeys(password);
        signInBtn.click();
    }

    public void login(){
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        usernameIB.sendKeys(ConfigurationReader.getProperty("username"));
        passwordIB.sendKeys(ConfigurationReader.getProperty("password"));
        signInBtn.click();
        Driver.getDriver().navigate().back();
    }

    public boolean invalidCredErrorMsgDisplayed(){
        return invalidCredErrorMsg.isDisplayed();
    }



}
