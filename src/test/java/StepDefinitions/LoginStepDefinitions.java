package StepDefinitions;

import StepDefinitions.HomePageStepDefinitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.automation.base.DriverFactory;
import com.automation.base.TestBase;
import com.automation.pages.LoginPage;
import com.automation.utils.ExcelUtil;

public class LoginStepDefinitions extends TestBase {

    private LoginPage loginPage;
    private ExcelUtil excel;
    private Map<String, String> testData;   

     public LoginStepDefinitions() {
    	 
    	 loginPage = new LoginPage(TestBase.getDriver());
     }


     @When("User clicks on my account and selects login button")
     public void User_clicks_on_my_account_and_selects_login_button() {
    	 
    	 loginPage.clickMyAccount();
    	 loginPage.clickLogin();
    	 
    	 
     }
     @And("User verifies that he has landed on the Login page")
     public void User_verifies_that_he_has_landed_on_the_Login_page() {
    	 
    	 try {
			loginPage.visibilityOf();
		 } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 } 
     }
     @And("User enters Username,password and clicks on login button")
     public void User_enters_Username_password_and_clicks_on_login_button(){ 	 
    	 
    	 String username = TestBase.testData.get("Email Address");
    	 loginPage.enterUsername(username);
    	 String password = TestBase.testData.get("Password");
    	 loginPage.enterPassword(password);
    	 loginPage.clickLoginButton();
    	 
     }
     @Then("User verifies that he has successfully logged in")
     public void User_verifies_that_he_has_successfully_logged_in() {
    	 
    	 loginPage.invisibilityOf();
    	 
     }
     

}