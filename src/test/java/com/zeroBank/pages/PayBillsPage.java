package com.zeroBank.pages;

import com.zeroBank.pages.base.BasePage;
import com.zeroBank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PayBillsPage extends BasePage {
    public PayBillsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

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

    public void paySuccessfully(){
        amountIB.sendKeys("" + randomNumber(1, 1000));
        dateIB.sendKeys(randomDate());
        descriptionIB.sendKeys(randomLetters(8));
        payBtn.click();
    }

    public void payWithDetails(String amount, String date){
        amountIB.sendKeys(amount);
        dateIB.sendKeys(date);
        descriptionIB.sendKeys(randomLetters(8));
        payBtn.click();
    }

}
