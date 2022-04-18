package com.zeroBank.pages;

import com.zeroBank.pages.base.BasePage;
import com.zeroBank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
    public HomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//div/strong[.='Online Banking']")
    public WebElement onlineBankingPageBtn;




}
