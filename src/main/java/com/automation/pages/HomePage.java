package com.automation.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.base.TestBase;

import org.openqa.selenium.JavascriptExecutor;

/**
 * Page Object Model for Login page.
 */
public class HomePage {

    private WebDriver driver;
    
    WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(10));
    Actions actions = new Actions(TestBase.getDriver());
    
    

    // Locators

    @FindBy(xpath="//button[@class=\"btn btn-link dropdown-toggle\"]")
    private WebElement usCurrencyDropdown;
    
    @FindBy(xpath="//span[@class=\"hidden-xs hidden-sm hidden-md\"]")
    private WebElement currencyDropdown;
    
    @FindBy(xpath="//a[text()=\"Contact Us\"]")
    private WebElement conactUsLink;
    


    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
     String menuXpath = "//a[text()='%s']";
     String subMenuXpath = "//a[contains(text(),'%s')]";
     String productName = "//a[text()='%s']/ancestor::div[@class=\"caption\"]/following-sibling::div//span[text()=\"Add to Cart\"]";
    

    public void selectSubMenu(String subMenu) {
    	
    	String finalXpath = String.format(subMenuXpath, subMenu);
    	WebElement SubMenu = driver.findElement(By.xpath(finalXpath));
    	SubMenu.click();
    }
    // Actions

    
    public void hoverOverMenu(String menu) {
    	
    	String finalXpath = String.format(menuXpath, menu);
  
    	WebElement Menu = driver.findElement(By.xpath(finalXpath));
    	
    	actions.moveToElement(Menu).perform();
    }
    public void clickOnCurrency() {
    	
    	currencyDropdown.click();
    }
    
    public void selectCurrency() {
    	

    }
    public void clickOnContactUs() {
    	
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("arguments[0].scrollIntoView(true);",conactUsLink);

    }
   public void clickOnContactUsLink() {
	  
     	conactUsLink.click();
   }
   



}