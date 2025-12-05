package com.flipkartAutomation.base;

import com.flipkartAutomation.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.MutableCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class DriverFactory {

    private static final ThreadLocal<WebDriver> tLDriver = new ThreadLocal<>();

    public static WebDriver initDriver(String browser) {

        // load config file
        ConfigReader.loadProperties();

        // runMode: local or cloud
        String runMode = ConfigReader.getProperty("runMode");
        System.out.println(runMode);
        // if browser not passed from runner, read from config
        if (browser == null || browser.trim().isEmpty()) {
            browser = ConfigReader.getProperty("browser");
        }
        System.out.println(browser);
        if ("local".equalsIgnoreCase(runMode)) {
        	startLocalDriver(browser);
            
        } else {
        	startBrowserStackDriver(browser);
        }

        // basic browser setup
        getDriver().manage().window().maximize();
        getDriver().manage().deleteAllCookies();

        return getDriver();
    }

    // ---------- LOCAL DRIVER ----------

    private static void startLocalDriver(String browser) {

        // we want to use manual driver paths, not Selenium Manager
        System.setProperty("webdriver.manager.enabled", "false");

        switch (browser.toLowerCase()) {

            case "chrome":
                System.setProperty("webdriver.chrome.driver",
                        "C:\\Users\\ramas\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
                tLDriver.set(new ChromeDriver());
                break;

            case "edge":
                System.setProperty("webdriver.edge.driver",
                        System.getProperty("user.dir") + "/drivers/msedgedriver.exe");
                tLDriver.set(new EdgeDriver());
                break;

            default:
                throw new RuntimeException("Browser not supported: " + browser);
        }
    }

    // ---------- BROWSERSTACK (DESKTOP ONLY) ----------

    private static void startBrowserStackDriver(String browser) {

        String username       = ConfigReader.getProperty("bs.username");
        String accessKey      = ConfigReader.getProperty("bs.accessKey");
        String os             = ConfigReader.getProperty("bs.os");
        String osVersion      = ConfigReader.getProperty("bs.osVersion");
        String browserVersion = ConfigReader.getProperty("bs.browserVersion");

        MutableCapabilities caps = new MutableCapabilities();
        caps.setCapability("browserName", browser);
        caps.setCapability("browserVersion", browserVersion);

        Map<String, Object> bstackOptions = new HashMap<>();
        bstackOptions.put("os", os);
        bstackOptions.put("osVersion", osVersion);
        bstackOptions.put("projectName", "Caseys");
        bstackOptions.put("buildName", "BDD Desktop Build");
        bstackOptions.put("sessionName", "scenario");

        caps.setCapability("bstack:options", bstackOptions);

        String hubUrl = "https://" + username + ":" + accessKey + "@hub-cloud.browserstack.com/wd/hub";

        try {
            tLDriver.set(new RemoteWebDriver(new URL(hubUrl), caps));
        } catch (MalformedURLException e) {
            throw new RuntimeException("Invalid BrowserStack hub URL", e);
        }
    }

    // ---------- GET / QUIT DRIVER ----------

    public static WebDriver getDriver() {
        return tLDriver.get();
    }

    public static void quitDriver() {
        WebDriver driver = tLDriver.get();
        if (driver != null) {
            driver.quit();
            tLDriver.remove();
        }
    }
}