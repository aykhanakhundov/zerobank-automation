package com.zeroBank.pages.base;

import com.github.javafaker.Faker;
import com.zeroBank.pages.*;
import com.zeroBank.utilities.Driver;
import com.zeroBank.utilities.PageNotDefinedException;
import com.zeroBank.utilities.UnknownParameterException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public abstract class BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);
    public Faker faker = new Faker();
    public Actions action = new Actions(Driver.getDriver());


    public static final String LOGIN_PAGE = "Login Page";
    public static final String HOME_PAGE = "Home Page";
    public static final String ONLINE_BANKING_PAGE = "Online Banking";
    public static final String ACCOUNT_SUMMARY_PAGE = "Account Summary";
    public static final String ACCOUNT_ACTIVITY_PAGE = "Account Activity";
    public static final String PAY_BILLS_PAGE = "Pay Bills";


    private static final Map<String, BasePage> PAGE_OBJECT_MAP = new HashMap<>();

    public static BasePage pageObjectFactory(String page) {
        if (PAGE_OBJECT_MAP.containsKey(page)) {
            return PAGE_OBJECT_MAP.get(page);
        } else {
            switch (page) {
                case LOGIN_PAGE:
                    PAGE_OBJECT_MAP.put(page, new LoginPage());
                    return PAGE_OBJECT_MAP.get(page);
                case HOME_PAGE:
                    PAGE_OBJECT_MAP.put(page, new HomePage());
                    return PAGE_OBJECT_MAP.get(page);
                case ONLINE_BANKING_PAGE:
                    PAGE_OBJECT_MAP.put(page, new OnlineBankingPage());
                    return PAGE_OBJECT_MAP.get(page);
                case ACCOUNT_SUMMARY_PAGE:
                    PAGE_OBJECT_MAP.put(page, new AccountSummaryPage());
                    return PAGE_OBJECT_MAP.get(page);
                case ACCOUNT_ACTIVITY_PAGE:
                    PAGE_OBJECT_MAP.put(page, new AccountActivityPage());
                    return PAGE_OBJECT_MAP.get(page);
                case PAY_BILLS_PAGE:
                    PAGE_OBJECT_MAP.put(page, new PayBillsPage());
                    return PAGE_OBJECT_MAP.get(page);
                default:
                    throw new PageNotDefinedException(page);
            }
        }
    }

    public void clearObjects() {
        PAGE_OBJECT_MAP.clear();
    }


    public String randomLetters(int length) {
        Faker faker = new Faker();
        StringBuilder randomLetters = new StringBuilder();
        for (int i = 0; i < length; i++) {
            randomLetters.append(faker.letterify("?"));
        }
        return randomLetters.toString();
    }


    public int randomNumber(int from, int to){
        return faker.number().numberBetween(from, to);
    }

    public String randomDate(){
        return "" + randomNumber(1990,2025) + "-" + randomNumber(1,12) + "-" + randomNumber(1,28);
    }


    public String getExpectedUrl(String page) {
        switch (page) {
            case LOGIN_PAGE:
                return "http://zero.webappsecurity.com/login.html";
            case HOME_PAGE:
                return "http://zero.webappsecurity.com/index.html";
            case ACCOUNT_SUMMARY_PAGE:
                return "http://zero.webappsecurity.com/bank/account-summary.html";
            case ACCOUNT_ACTIVITY_PAGE:
                return "http://zero.webappsecurity.com/bank/account-activity.html";
            case PAY_BILLS_PAGE:
                return "http://zero.webappsecurity.com/bank/pay-bills.html";
            default:
                throw new UnknownParameterException(page);
        }
    }

    public void goTo(String pageName) {
        Driver.getDriver().get(getExpectedUrl(pageName));
    }
}
