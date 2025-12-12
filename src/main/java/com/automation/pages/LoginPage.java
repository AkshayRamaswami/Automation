package com.automation.pages;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Page Object Model for Login page.
 */
public class LoginPage {

    private WebDriver driver;
    
    WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(10));
    
    

    // Locators
    @FindBy(name = "username")
    private WebElement txtUsername;

    @FindBy(xpath = "//input[@placeholder=\"Password\"]")
    private WebElement txtPassword;
    
    @FindBy(xpath="//span[text()=\"My Account\"]")
     private WebElement  myAccount;


    @FindBy(css = "p.oxd-text.oxd-text--p.oxd-alert-content-text")
    private WebElement lblError;
    
    @FindBy(xpath="//li/a[text()='Login']")
    private WebElement btnLogin;
    
    @FindBy(xpath="//input[@value='Login']")
    private WebElement btnnLogin;
    
    @FindBy(xpath="//a[text()='Account']/parent::li/following-sibling::li/a[@href=\"https://awesomeqa.com/ui/index.php?route=account/login\" and text()=\"Login\"]")
    private WebElement loginDetailsPage;
    
    @FindBy(xpath="//input[@placeholder=\"E-Mail Address\"]")
    private WebElement emailAddress;

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Actions
    public void enterUsername(String username) {
    	emailAddress.clear();
    	emailAddress.sendKeys(username);
    }

    public void enterPassword(String password) {
        txtPassword.clear();
        txtPassword.sendKeys(password);
    }

    public void clickLogin() {
        btnLogin.click();
    }
    public void clickLoginButton() {
    	
    	btnnLogin.click();
    }
    public void clickMyAccount() {
    	
    	myAccount.click();
    }

    public String getErrorMessage() {
        return lblError.getText();
    }
    

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

	public void visibilityOf() throws InterruptedException {
    	
    	wait.until(ExpectedConditions.visibilityOf(loginDetailsPage)); 
    	Thread.sleep(1000);
    	
    	

    	System.out.println("User landed on login page");
    }
    public void invisibilityOf() {
    	
    	wait.until(ExpectedConditions.invisibilityOf(btnnLogin));
    	System.out.println("User successfully logged in");
    }


}