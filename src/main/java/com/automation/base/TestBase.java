package com.automation.base;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.automation.utils.ConfigReader;

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