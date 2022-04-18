package com.zeroBank.stepDefinitions;

import static com.zeroBank.pages.base.BasePage.*;
import static org.junit.Assert.assertEquals;

import com.zeroBank.pages.AccountSummaryPage;
import com.zeroBank.pages.LoginPage;
import com.zeroBank.pages.base.BasePage;
import com.zeroBank.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class MainPages_StepDef {

    BasePage page;

    @Given("user is on {string}")
    public void user_is_on(String string) {
        page = pageObjectFactory(LOGIN_PAGE);
        ((LoginPage)page).login();
        page.clearObjects();
    }

    @When("user goes to {string} page")
    public void user_goes_to_page(String pageName) {
        page.goTo(pageName);
    }

    @Then("verifies {string} page has following account types")
    public void verifies_page_has_following_account_types(String pageName, List<String> expectedAccountTypes) {
        page = pageObjectFactory(pageName);
        List<String> actualAccountTypes = new ArrayList<>();
        for (WebElement eachType : ((AccountSummaryPage) page).accountTypes) {
            actualAccountTypes.add(eachType.getText());
        }
        assertEquals(expectedAccountTypes, actualAccountTypes);
    }



    @And("verifies account dropdown default chosen option is {string}")
    public void verifiesAccountDropdownDefaultChosenOptionIs(String expectedDefaultChosenOption) {

    }

    @And("verifies account dropdown has following options")
    public void verifiesAccountDropdownHasFollowingOptions(List<String> expectedDropDownOptions) {

    }

    @And("verifies transactions table has following column names")
    public void verifiesTransactionsTableHasFollowingColumnNames(List<String> expectedTableColumnNames) {

    }
}
