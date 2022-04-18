package com.zeroBank.stepDefinitions;

import static com.zeroBank.pages.base.BasePage.*;
import static org.junit.Assert.*;

import com.zeroBank.pages.AccountActivityPage;
import com.zeroBank.pages.AccountSummaryPage;
import com.zeroBank.pages.LoginPage;
import com.zeroBank.pages.PayBillsPage;
import com.zeroBank.pages.base.BasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.*;

public class AccountSummary_Activity_StepDef {

    BasePage page;
    Select select;

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
        page.clearObjects();
        assertEquals(expectedAccountTypes, actualAccountTypes);
    }



    @And("verifies account dropdown default chosen option is {string}")
    public void verifiesAccountDropdownDefaultChosenOptionIs(String expectedDefaultChosenOption) {
        page = pageObjectFactory(ACCOUNT_ACTIVITY_PAGE);
        select = new Select(((AccountActivityPage)page).accountDropDown);
        page.clearObjects();
        assertEquals(expectedDefaultChosenOption, select.getFirstSelectedOption().getText());
    }

    @And("verifies account dropdown has following options")
    public void verifiesAccountDropdownHasFollowingOptions(List<String> expectedDropDownOptionsList) {
        page = pageObjectFactory(ACCOUNT_ACTIVITY_PAGE);
        select = new Select(((AccountActivityPage)page).accountDropDown);
        page.clearObjects();
        Set<String> expectedDropDownOptionsSet = new LinkedHashSet<>(expectedDropDownOptionsList);
        Set<String> actualDropDownOptions = new LinkedHashSet<>();
        for (WebElement eachOption : select.getOptions()) {
            actualDropDownOptions.add(eachOption.getText());
        }
//        System.out.println("actualDropDownOptions = " + actualDropDownOptions);
        assertEquals(expectedDropDownOptionsSet, actualDropDownOptions);
    }

    @And("verifies transactions table has following column names")
    public void verifiesTransactionsTableHasFollowingColumnNames(List<String> expectedTableColumnNames) {
        page = pageObjectFactory(ACCOUNT_ACTIVITY_PAGE);
        List<String> actualTableColumnNames = new ArrayList<>();
        for (WebElement eachColumn : ((AccountActivityPage) page).transactionsTableColumnNames) {
            actualTableColumnNames.add(eachColumn.getText());
        }
        page.clearObjects();
        assertEquals(expectedTableColumnNames, actualTableColumnNames);
    }




}
