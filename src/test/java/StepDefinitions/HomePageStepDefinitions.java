package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.automation.base.DriverFactory;
import com.automation.base.TestBase;
import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;
import com.automation.utils.ExcelUtil;

public class HomePageStepDefinitions extends TestBase {

    private LoginPage loginPage;
    private WebDriver driver;
    private ExcelUtil excel; // available to all steps in this scenario
    private int rowIndex;
    private HomePage homePage;
    private Map<String, String> testData; 

    public HomePageStepDefinitions() {
   	 loginPage = new LoginPage(TestBase.getDriver());
   	 homePage = new HomePage(TestBase.getDriver());
    }

    @Given("User is on home page for {int}")
    public void user_is_on_home_page_for(Integer tcNo) {
    	
        // 1. Open Excel and sheet
        String filePath  = System.getProperty("user.dir")
                            + "/src/test/resources/TestData/Flipkart.xlsx";   // change path
        String sheetName = "Web";                             // change sheet

        excel = new ExcelUtil(filePath, sheetName);

        // If row 1 = tcNo 1, row 2 = tcNo 2, etc.
        rowIndex = tcNo; // or tcNo + 0/1 depending on how your sheet is arranged

        // 2. Read the full row once
        TestBase.testData = excel.getRowData(rowIndex);   	
    }
    @And("User Selects Sub category from the home page")
    public void user_selects_sub_category_from_the_home_page() {
    	String subMenu = TestBase.testData.get("Sub Category");
    	homePage.selectSubMenu(subMenu);
    }
    @When("User hovers on Category on home page")
    public void user_hovers_on_category_home_page() {
    	
    	String menu = TestBase.testData.get("Category");

    	homePage.hoverOverMenu(menu);
    }

    @When("User clicks on currency button")
    public void User_clicks_on_currency_button() {
    	homePage.clickOnCurrency();
    	
    }
    @And("User Selects us currency from the home page")
    public void User_Selects_us_currency_from_the_home_page() {
    	
    	homePage.selectCurrency();
    }
    @When("User scrolls to the botton")
    public void User_scrolls_to_the_botton() {
    	
      homePage.clickOnContactUs();
    }


    @And("User clicks on the Contact us link")
    public void User_clicks_on_the_Contact_us_link() {
    	
    	homePage.clickOnContactUsLink();
    }
}



