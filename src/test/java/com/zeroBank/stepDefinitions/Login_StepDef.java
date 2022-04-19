package com.zeroBank.stepDefinitions;

import com.zeroBank.pages.HomePage;
import com.zeroBank.pages.LoginPage;

import static com.zeroBank.pages.base.BasePage.*;
import static org.junit.Assert.*;

import com.zeroBank.pages.OnlineBankingPage;
import com.zeroBank.pages.base.BasePage;
import com.zeroBank.utilities.ConfigurationReader;
import com.zeroBank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login_StepDef {

    BasePage page;


    @Given("user navigates to {string}")
    public void user_navigates_to(String pageName) {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
    }


    @When("user sends {string} credentials")
    public void user_sends_credentials(String testType) {
        page = BasePage.pageObjectFactory(LOGIN_PAGE);
        if (testType.equals("Valid")) {
            ((LoginPage) page).loginValid();
            Driver.getDriver().navigate().back();
            page = BasePage.pageObjectFactory(HOME_PAGE);
            ((HomePage) page).onlineBankingPageBtn.click();
            page = BasePage.pageObjectFactory(ONLINE_BANKING_PAGE);
            ((OnlineBankingPage) page).accountSummaryLink.click();
        } else if (testType.equals("Invalid")) {
            ((LoginPage) page).loginInvalid();
        } else {
            ((LoginPage) page).loginWithCred("  ", "  ");
        }
        page.clearObjects();
    }

    @Then("verifies page title is {string}")
    public void verifies_page_title_is(String expectedPageTitle) {
        assertEquals(expectedPageTitle, Driver.getDriver().getTitle());
    }


    @Then("verifies {string} is displayed")
    public void verifiesIsDisplayed(String expectedErrorMsg) {
        page = pageObjectFactory(LOGIN_PAGE);
        assertTrue(((LoginPage) page).invalidCredErrorMsgDisplayed());
        assertEquals(expectedErrorMsg, ((LoginPage) page).invalidCredErrorMsg.getText());
        page.clearObjects();
    }
}
