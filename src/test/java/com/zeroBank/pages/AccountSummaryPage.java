package com.zeroBank.pages;

import com.zeroBank.pages.base.BasePage;
import com.zeroBank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AccountSummaryPage extends BasePage {
    public AccountSummaryPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(tagName = "h2")
    public List<WebElement> accountTypes;

}
