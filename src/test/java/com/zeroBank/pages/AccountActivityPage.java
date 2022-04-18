package com.zeroBank.pages;

import com.zeroBank.pages.base.BasePage;
import com.zeroBank.utilities.Driver;
import com.zeroBank.utilities.NotElementDefinedException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AccountActivityPage extends BasePage {
    public AccountActivityPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public static final String FIND_TRANSACTIONS_TAB = "Find Transactions";
    public static final String FIND_BTN = "Find";
    public static final String FROM_DATE_IB = "From Date";
    public static final String TO_DATE_IB = "To Date";
    public static final String DESCRIPTION_IB = "Description";



    @FindBy(id = "aa_accountId")
    public WebElement accountDropDown;

    @FindBy(xpath = "//div[@id='all_transactions_for_account']//thead//th")
    public List<WebElement> transactionsTableColumnNames;

    @FindBy(xpath = "//a[.='Find Transactions']")
    public WebElement findTransactionsTab;

    @FindBy(xpath = "//button[.='Find']")
    public WebElement findBtn;

    @FindBy(id = "aa_fromDate")
    public WebElement fromDateIB;

    @FindBy(id = "aa_toDate")
    public WebElement toDateIB;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tbody//td[1]")
    public List<WebElement> datesFromResultTable;

    @FindBy(id = "aa_description")
    public WebElement descriptionIB;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tbody//td[2]")
    public List<WebElement> descriptionsFromResultTable;







    public WebElement getElement(String element) {
        switch (element) {
            case FIND_TRANSACTIONS_TAB:
                return findTransactionsTab;
            case FIND_BTN:
                return findBtn;
            case FROM_DATE_IB:
                return fromDateIB;
            case TO_DATE_IB:
                return toDateIB;
            case DESCRIPTION_IB:
                return descriptionIB;
            default:
                throw new NotElementDefinedException(element);
        }
    }



    public void clickOnSomething(String clickable) {
        getElement(clickable).click();
    }

}
