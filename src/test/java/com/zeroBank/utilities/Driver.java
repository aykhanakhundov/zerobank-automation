package com.zeroBank.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {

  private Driver(){}

  private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();

  public static WebDriver getDriver() {
    if (driverPool.get() == null) {

      synchronized (Driver.class) {

        String browserType = ConfigurationReader.getProperty("browser");
        switch (browserType) {
          case "chrome":
            WebDriverManager.chromedriver().setup();
            driverPool.set(new ChromeDriver());
            driverPool.get().manage().window().maximize();
            driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driverPool.get().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
            break;
          case "firefox":
            WebDriverManager.firefoxdriver().setup();
            driverPool.set(new FirefoxDriver());
            driverPool.get().manage().window().maximize();
            driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driverPool.get().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
            break;
          case "remote-chrome":
            try {
              // assign your grid server address
              String gridAddress = ConfigurationReader.getProperty("gridAddress");
              URL url = new URL("http://" + gridAddress + ":4444/wd/hub");
              DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
              desiredCapabilities.setBrowserName("chrome");
              driverPool.set(new RemoteWebDriver(url, desiredCapabilities));
            } catch (Exception e) {
              e.printStackTrace();
            }
            break;
        }
        }
      }
      return driverPool.get();
    }

    public static void closeDriver () {
      if (driverPool.get() != null) {
        driverPool.get().quit();
        driverPool.remove();
      }
    }
}
