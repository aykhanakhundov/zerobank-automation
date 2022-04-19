package com.zeroBank.pages;

import com.zeroBank.pages.base.BasePage;
import com.zeroBank.utilities.Driver;
import com.zeroBank.utilities.NotElementDefinedException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PayBillsPage extends BasePage {
    public PayBillsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public static final String ADD_NEW_PAYEE_BTN = "Add New Payee";
    public static final String PAYEE_NAME_IB = "Payee Name IB";
    public static final String PAYEE_ADDRESS_IB = "Payee Address IB";
    public static final String PAYEE_ACCOUNT_IB = "Payee Account IB";
    public static final String PAYEE_DETAILS_IB = "Payee Details IB";
    public static final String SUBMIT_NEW_PAYEE = "Submit New Payee";
    public static final String PAYEE_CREATED_MSG = "Payee Created Msg";
    public static final String PURCHASE_FOREIGN_CURRENCY_BTN = "Purchase Foreign Currency";
    public static final String CALCULATE_COSTS_BTN = "Calculate Costs";


    @FindBy(id = "sp_amount")
    public WebElement amountIB;

    @FindBy(id = "sp_date")
    public WebElement dateIB;

    @FindBy(id = "sp_description")
    public WebElement descriptionIB;

    @FindBy(id = "pay_saved_payees")
    public WebElement payBtn;

    @FindBy(xpath = "//div[@id='alert_content']/span")
    public WebElement successfulPaymentMsg;

    @FindBy(xpath = "//a[.='Add New Payee']")
    public WebElement addNewPayeeBtn;

    @FindBy(id = "np_new_payee_name")
    public WebElement payeeNameIB;

    @FindBy(id = "np_new_payee_address")
    public WebElement payeeAddressIB;

    @FindBy(id = "np_new_payee_account")
    public WebElement payeeAccountIB;

    @FindBy(id = "np_new_payee_details")
    public WebElement payeeDetailsIB;

    @FindBy(id = "add_new_payee")
    public WebElement submitNewPayee;

    @FindBy(xpath = "//div[@id='alert_content']")
    public WebElement payeeCreatedMsg;

    @FindBy(xpath = "//a[.='Purchase Foreign Currency']")
    public WebElement purchaseForeignCurrencyBtn;

    @FindBy(id = "pc_currency")
    public WebElement currencyDropDown;

    @FindBy(id = "pc_inDollars_true")
    public WebElement currencyRadioBtn;

    @FindBy(id = "pc_calculate_costs")
    public WebElement calculateCostsBtn;

    @FindBy(id = "pc_amount")
    public WebElement amountForCurrencyIB;


    public void paySuccessfully() {
        amountIB.sendKeys("" + randomNumber(1, 1000));
        dateIB.sendKeys(randomDate());
        descriptionIB.sendKeys(randomLetters(8));
        payBtn.click();
    }

    public void payWithDetails(String amount, String date) {
        amountIB.sendKeys(amount);
        dateIB.sendKeys(date);
        descriptionIB.sendKeys(randomLetters(8));
        payBtn.click();
    }

    public WebElement getElement(String element) {
        switch (element) {
            case ADD_NEW_PAYEE_BTN:
                return addNewPayeeBtn;
            case PAYEE_NAME_IB:
                return payeeNameIB;
            case PAYEE_ACCOUNT_IB:
                return payeeAccountIB;
            case PAYEE_DETAILS_IB:
                return payeeDetailsIB;
            case PAYEE_ADDRESS_IB:
                return payeeAddressIB;
            case SUBMIT_NEW_PAYEE:
                return submitNewPayee;
            case PAYEE_CREATED_MSG:
                return payeeCreatedMsg;
            case PURCHASE_FOREIGN_CURRENCY_BTN:
                return purchaseForeignCurrencyBtn;
            case CALCULATE_COSTS_BTN:
                return calculateCostsBtn;
            default:
                throw new NotElementDefinedException(element);
        }
    }

    public void clickOnSomething(String clickable) {
        getElement(clickable).click();
    }
}
