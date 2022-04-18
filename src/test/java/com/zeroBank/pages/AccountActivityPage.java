package com.zeroBank.pages;

import com.zeroBank.pages.base.BasePage;
import com.zeroBank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AccountActivityPage extends BasePage {
    public AccountActivityPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "aa_accountId")
    public WebElement accountDropDown;

    @FindBy(xpath = "//div[@id='all_transactions_for_account']//thead//th")
    public List<WebElement> transactionsTableColumnNames;



}
