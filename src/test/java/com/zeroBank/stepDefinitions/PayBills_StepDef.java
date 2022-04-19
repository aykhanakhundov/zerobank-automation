package com.zeroBank.stepDefinitions;

import com.zeroBank.pages.PayBillsPage;
import com.zeroBank.pages.base.BasePage;
import com.zeroBank.utilities.BrowserUtils;
import com.zeroBank.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Map;

import static com.zeroBank.pages.base.BasePage.PAY_BILLS_PAGE;
import static com.zeroBank.pages.base.BasePage.pageObjectFactory;
import static org.junit.Assert.*;

public class PayBills_StepDef {

    BasePage page;

    @And("user completes {string} pay operation")
    public void userCompletesPayOperation(String testType) {
        page = pageObjectFactory(PAY_BILLS_PAGE);
        if (testType.equals("Successful")) {
            ((PayBillsPage) page).paySuccessfully();
        } else if (testType.equals("Wrong Amount")) {//check this one
            ((PayBillsPage) page).payWithDetails("abcd", ((PayBillsPage) page).randomDate());
        } else if (testType.equals("Wrong Date")) {
            ((PayBillsPage) page).payWithDetails("" + page.randomNumber(1, 1000), "abcd");
        } else if (testType.equals("No Amount Selected")) {
            ((PayBillsPage) page).payWithDetails("", page.randomDate());
        } else if (testType.equals("No Date Selected")) {
            ((PayBillsPage) page).payWithDetails("" + page.randomNumber(1, 1000), "");
        }
        page.clearObjects();
    }

    @Then("verifies {string} message is displayed for {string}")
    public void verifiesMessageIsDisplayed(String expectedMsg, String testType) {
        page = pageObjectFactory(PAY_BILLS_PAGE);
        if (testType.equals("Successful")) {
            assertTrue(((PayBillsPage) page).successfulPaymentMsg.isDisplayed());
        } else if (testType.equals("No Amount Selected")) {
            assertEquals("true", ((PayBillsPage) page).dateIB.getAttribute("required"));
        } else if (testType.equals("No Date Selected")) {
            assertEquals("true", ((PayBillsPage) page).dateIB.getAttribute("required"));
        }
        page.clearObjects();
    }

    @Then("user verifies {string} is not accepted")
    public void userVerifiesIsNotAccepted(String testType) {
        page = pageObjectFactory(PAY_BILLS_PAGE);
        if (testType.equals("Wrong Date")) {
            assertEquals("", ((PayBillsPage) page).dateIB.getText());
        } else if (testType.equals("Wrong Amount")) { //check this one
            //check this one
            page.wait.until(ExpectedConditions.visibilityOf(((PayBillsPage) page).successfulPaymentMsg));
            if (((PayBillsPage) page).successfulPaymentMsg.isDisplayed()) {
                // System.err.println("Sending money with wrong amount is possible!!!");
                Assert.fail("Sending money with wrong amount is possible!!!");
            }
        }
        page.clearObjects();
    }


    @When("fills out payee using following information")
    public void fills_out_payee_using_following_information(Map<String, String> mapOfRequiredFields) {
        //System.out.println("mapOfRequiredFields = " + mapOfRequiredFields);
        page = pageObjectFactory(PAY_BILLS_PAGE);
        ((PayBillsPage) page).payeeNameIB.sendKeys(mapOfRequiredFields.get("Payee Name"));
        ((PayBillsPage) page).payeeAddressIB.sendKeys(mapOfRequiredFields.get("Payee Address"));
        ((PayBillsPage) page).payeeAccountIB.sendKeys(mapOfRequiredFields.get("Account"));
        ((PayBillsPage) page).payeeDetailsIB.sendKeys(mapOfRequiredFields.get("Payee Details"));
        page.clearObjects();
    }


    @Then("{string} message should be displayed")
    public void message_should_be_displayed(String expectedMsg) {
        page = pageObjectFactory(PAY_BILLS_PAGE);
        assertEquals(((PayBillsPage) page).payeeCreatedMsg.getText(), expectedMsg);
        page.clearObjects();
    }
}
