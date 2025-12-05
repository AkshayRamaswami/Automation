package StepDefinitions;

import com.flipkartAutomation.base.DriverFactory;
import com.flipkartAutomation.base.TestBase;
import com.flipkartAutomation.pages.LoginPage;
import com.flipkartAutomation.pages.SearchPage;
import com.flipkartAutomation.utils.ExcelUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SearchStepDefinitions extends TestBase {

    private SearchPage searchPage;
    private WebDriver driver;

    @When("User enters the search term into the search box")
    public void User_enters_the_search_term_into_the_box() {
    	
    	
    	System.out.println("its working");
    }


}