package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.automation.base.DriverFactory;
import com.automation.base.TestBase;
import com.automation.pages.LoginPage;
import com.automation.pages.SearchPage;
import com.automation.utils.ExcelUtil;

public class SearchStepDefinitions extends TestBase {

    private SearchPage searchPage;
    private WebDriver driver;

    @When("User enters the search term into the search box")
    public void User_enters_the_search_term_into_the_box() {
    	
    	
    	System.out.println("its working");
    }


}