package com.zeroBank.stepDefinitions;

import com.zeroBank.utilities.ConfigurationReader;
import com.zeroBank.utilities.DB;
import com.zeroBank.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hook {

    @Before("@ui")
    public void setupUI() {
        //Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @After("@ui")
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }

        Driver.getDriver().manage().deleteAllCookies();

        Driver.closeDriver();
    }

    @Before("@db")
    public void setupDB(){
        DB.createConnection(ConfigurationReader.getProperty("jdbcURL"),
                "library2_client",  "6s2LQQTjBcGFfDhY");
    }

    @After("@db")
    public void destroyConnection(){
        DB.destroy();
    }
}
