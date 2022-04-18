package com.zeroBank.stepDefinitions;

import com.zeroBank.pages.PayBillsPage;
import com.zeroBank.pages.base.BasePage;
import com.zeroBank.utilities.BrowserUtils;
import com.zeroBank.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.zeroBank.pages.base.BasePage.PAY_BILLS_PAGE;
import static com.zeroBank.pages.base.BasePage.pageObjectFactory;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PayBills_StepDef {

    BasePage page;

    @And("user completes {string} pay operation")
    public void userCompletesPayOperation(String testType) {
        page = pageObjectFactory(PAY_BILLS_PAGE);
        if(testType.equals("Successful")){
            ((PayBillsPage)page).paySuccessfully();
        }else if(testType.equals("Wrong Amount")){//check this one
            ((PayBillsPage)page).payWithDetails("abcd", ((PayBillsPage)page).randomDate());
        }else if(testType.equals("Wrong Date")){
            ((PayBillsPage)page).payWithDetails("" + page.randomNumber(1, 1000), "abcd");
        }else if(testType.equals("No Amount Selected")){
            ((PayBillsPage)page).payWithDetails("", page.randomDate());
        }else if(testType.equals("No Date Selected"))
            ((PayBillsPage)page).payWithDetails("" + page.randomNumber(1, 1000), "");
    }

    @Then("verifies {string} message is displayed for {string}")
    public void verifiesMessageIsDisplayed(String expectedMsg, String testType) {
        page = pageObjectFactory(PAY_BILLS_PAGE);
        if(testType.equals("Successful")){
            assertTrue(((PayBillsPage)page).successfulPaymentMsg.isDisplayed());
        }else if(testType.equals("No Amount Selected")){
            assertEquals("true", ((PayBillsPage) page).dateIB.getAttribute("required"));
        }else if(testType.equals("No Date Selected")){
            assertEquals("true", ((PayBillsPage) page).dateIB.getAttribute("required"));
        }
        page.clearObjects();
    }

    @Then("user verifies {string} is not accepted")
    public void userVerifiesIsNotAccepted(String testType) {
        page = pageObjectFactory(PAY_BILLS_PAGE);
        if(testType.equals("Wrong Date")){
            assertEquals("", ((PayBillsPage) page).dateIB.getText());
        }else if(testType.equals("Wrong Amount")){ //check this one
            //check this one
            page.wait.until(ExpectedConditions.visibilityOf(((PayBillsPage)page).successfulPaymentMsg));
            if(((PayBillsPage)page).successfulPaymentMsg.isDisplayed()){
                System.err.println("Sending money with wrong amount is possible!!!");
                Assert.fail("Sending money with wrong amount is possible!!!");
            }
        }
    }
}
