package com.zeroBank.pages;

import com.zeroBank.pages.base.BasePage;
import com.zeroBank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OnlineBankingPage extends BasePage {
    public OnlineBankingPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(id = "account_summary_link")
    public WebElement accountSummaryLink;


}
