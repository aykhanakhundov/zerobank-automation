package com.zeroBank.stepDefinitions;

import static com.zeroBank.pages.base.BasePage.*;
import static org.junit.Assert.*;

import com.zeroBank.pages.AccountActivityPage;
import com.zeroBank.pages.AccountSummaryPage;
import com.zeroBank.pages.LoginPage;
import com.zeroBank.pages.PayBillsPage;
import com.zeroBank.pages.base.BasePage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.*;

public class AccountSummary_Activity_StepDef {

    BasePage page;
    Select select;
    List<String> actualDatesGlobal;

    @Given("user is on {string}")
    public void user_is_on(String string) {
        page = pageObjectFactory(LOGIN_PAGE);
        ((LoginPage) page).login();
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
        select = new Select(((AccountActivityPage) page).accountDropDown);
        page.clearObjects();
        assertEquals(expectedDefaultChosenOption, select.getFirstSelectedOption().getText());
//        System.out.println("select.getFirstSelectedOption().getText() = " + select.getFirstSelectedOption().getText());
    }

    @And("verifies account dropdown has following options")
    public void verifiesAccountDropdownHasFollowingOptions(List<String> expectedDropDownOptionsList) {
        page = pageObjectFactory(ACCOUNT_ACTIVITY_PAGE);
        select = new Select(((AccountActivityPage) page).accountDropDown);
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


    @When("user clicks on {string} on {string} page")
    public void userClicksOnOnThePage(String clickable, String pageName) {
        page = pageObjectFactory(pageName);
        switch (pageName) {
            case ACCOUNT_SUMMARY_PAGE:
                ((AccountSummaryPage) page).clickOnSomething(clickable);
                break;
            case ACCOUNT_ACTIVITY_PAGE:
                ((AccountActivityPage) page).clickOnSomething(clickable);
                break;
            case PAY_BILLS_PAGE:
                ((PayBillsPage) page).clickOnSomething(clickable);
                break;
        }
        page.clearObjects();
    }

    @When("user enters date range from {string} to {string}")
    public void userEntersDateRangeFromTo(String fromDate, String toDate) {
        page = pageObjectFactory(ACCOUNT_ACTIVITY_PAGE);
        //BrowserUtils.waitFor(2);
        ((AccountActivityPage) page).fromDateIB.sendKeys(fromDate);
        ((AccountActivityPage) page).toDateIB.sendKeys(toDate);
        page.clearObjects();
    }

    @Then("verifies results should only show transactions dates between {string} to {string}")
    public void verifiesResultsShouldOnlyShowTransactionsDatesBetweenTo(String fromDate, String toDate) {
        page = pageObjectFactory(ACCOUNT_ACTIVITY_PAGE);
        List<String> actualDatesFromResults = new ArrayList<>();
        for (WebElement eachDate : ((AccountActivityPage) page).datesFromResultTable) {
            actualDatesFromResults.add(eachDate.getText());
        }
        actualDatesGlobal = actualDatesFromResults;
        //System.out.println("actualDatesFromResults = " + actualDatesFromResults);
        page.clearObjects();
        assertTrue(page.datesInRange(fromDate, toDate, actualDatesFromResults));
    }

    @And("results should be sorted by most recent date")
    public void resultsShouldBeSortedByMostRecentDate() {
        assertTrue(page.datesSortedByMostRecent(actualDatesGlobal));
    }

    @And("results should not contain transaction dated {string}")
    public void resultsShouldNotContainTransactionDated(String givenDate) {
        assertFalse(actualDatesGlobal.contains(givenDate));
    }


    @When("user enters {string} to description box")
    public void userEntersToDescriptionBox(String searchValue) {
        page = pageObjectFactory(ACCOUNT_ACTIVITY_PAGE);
        page.wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(((AccountActivityPage) page).descriptionIB)));
        ((AccountActivityPage) page).descriptionIB.clear();
        ((AccountActivityPage) page).descriptionIB.sendKeys(searchValue);
        page.clearObjects();
    }

    @Then("verifies results should only show descriptions containing {string}")
    public void verifiesResultsShouldOnlyShowDescriptionsContaining(String searchResult) {
        page = pageObjectFactory(ACCOUNT_ACTIVITY_PAGE);
        page.wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfAllElements(((AccountActivityPage) page).descriptionsFromResultTable)));
        for (WebElement eachDescription : ((AccountActivityPage) page).descriptionsFromResultTable) {
            assertTrue(eachDescription.getText().contains(searchResult));
        }
        page.clearObjects();
    }

    @But("results should not show descriptions containing {string}")
    public void resultsShouldNotShowDescriptionsContaining(String irrelevantSearchResult) {
        page = pageObjectFactory(ACCOUNT_ACTIVITY_PAGE);
        for (WebElement eachDescription : ((AccountActivityPage) page).descriptionsFromResultTable) {
            assertFalse(eachDescription.getText().contains(irrelevantSearchResult));
        }
        page.clearObjects();
    }

    @Then("results should show at least one result under {string}")
    public void resultsShouldShowAtLeastOneResultUnder(String columName) {
        page = pageObjectFactory(ACCOUNT_ACTIVITY_PAGE);

        if (columName.equals("Deposit")) {
            assertTrue(((AccountActivityPage) page).notAllCellsNull(((AccountActivityPage) page).depositsFromResultsTable));
        } else {
            assertTrue(((AccountActivityPage) page).notAllCellsNull(((AccountActivityPage) page).withdrawalsFromResultsTable));
        }
        page.clearObjects();
    }

    @When("user selects type {string}")
    public void userSelectsType(String transactionType) {
        page = pageObjectFactory(ACCOUNT_ACTIVITY_PAGE);
        page.wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(((AccountActivityPage) page).transactionTypeDropDown)));
        select = new Select(((AccountActivityPage) page).transactionTypeDropDown);
        select.selectByVisibleText(transactionType);
        page.clearObjects();
    }

    @But("results should show no result under {string}")
    public void resultsShouldShowNoResultUnder(String columnName) {
        page = pageObjectFactory(ACCOUNT_ACTIVITY_PAGE);
        if (columnName.equals("Withdrawal")) {
            assertTrue(((AccountActivityPage) page).allCellsAreNull(((AccountActivityPage) page).withdrawalsFromResultsTable));
        } else {
            assertTrue(((AccountActivityPage) page).allCellsAreNull(((AccountActivityPage) page).depositsFromResultsTable));
        }
        page.clearObjects();
    }
}
