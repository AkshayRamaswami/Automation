package com.flipkartAutomation.base;

import com.flipkartAutomation.utils.ConfigReader;

import java.util.Map;

import org.openqa.selenium.WebDriver;

public class TestBase {

    protected static WebDriver driver;
    public static  Map<String, String> testData; 

    public void launchApplication() {
        ConfigReader.loadProperties();
        String url = ConfigReader.getProperty("baseUrl");
        driver.get(url);
        
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

	public static WebDriver getDriver() {
		// TODO Auto-generated method stub
		return driver;
	}
}