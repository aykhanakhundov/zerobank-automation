package com.zeroBank.pages;

import com.zeroBank.pages.base.BasePage;
import com.zeroBank.utilities.Driver;
import com.zeroBank.utilities.NotElementDefinedException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AccountSummaryPage extends BasePage {
    public AccountSummaryPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public static final String SAVINGS_LINK = "Savings Link";
    public static final String BROKERAGE_LINK = "Brokerage Link";
    public static final String CHECKING_LINK = "Checking Link";
    public static final String CREDIT_CARD_LINK = "Credit Card Link";
    public static final String LOAN_LINK = "Loan Link";


    @FindBy(tagName = "h2")
    public List<WebElement> accountTypes;

    @FindBy(xpath = "//a[.='Savings']")
    public WebElement savingsLink;

    @FindBy(xpath = "//a[.='Brokerage']")
    public WebElement brokerageLink;

    @FindBy(xpath = "//a[.='Checking']")
    public WebElement checkingLink;

    @FindBy(xpath = "//a[.='Credit Card']")
    public WebElement creditCardLink;

    @FindBy(xpath = "//a[.='Loan']")
    public WebElement loanLink;


    public WebElement getElement(String clickable) {
        switch (clickable) {
            case SAVINGS_LINK:
                return savingsLink;
            case BROKERAGE_LINK:
                return brokerageLink;
            case CHECKING_LINK:
                return checkingLink;
            case CREDIT_CARD_LINK:
                return creditCardLink;
            case LOAN_LINK:
                return loanLink;
            default:
                throw new NotElementDefinedException(clickable);
        }
    }

    public void clickOnSomething(String clickable) {
        getElement(clickable).click();
    }


}
