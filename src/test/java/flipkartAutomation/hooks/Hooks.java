package flipkartAutomation.hooks;

import com.flipkartAutomation.base.DriverFactory;
import com.flipkartAutomation.base.TestBase;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Hooks extends TestBase {

    @Before
    public void setUp(Scenario scenario) {

        // Read browser tag from scenario: @browser_chrome, @browser_edge, etc.
        String browserFromScenario = scenario.getSourceTagNames()
                .stream()
                .filter(tag -> tag.startsWith("@browser_"))
                .map(tag -> tag.replace("@browser_", ""))
                .findFirst()
                .orElse(null);

        WebDriver driver = DriverFactory.initDriver(browserFromScenario);
        setDriver(driver);         // from TestBase
        launchApplication();       // open AUT

        System.out.println(">>> Starting scenario: " + scenario.getName()
                + " | Browser: " + browserFromScenario);
    }

    @After
    public void tearDown(Scenario scenario) {

        try {
            if (scenario.isFailed()) {
                // Take screenshot on failure and attach to Cucumber scenario
                final byte[] screenshot =
                        ((TakesScreenshot) DriverFactory.getDriver())
                                .getScreenshotAs(OutputType.BYTES);

                scenario.attach(screenshot, "image/png", "Failed Scenario Screenshot");
            }
        } catch (Exception e) {
            System.out.println("Could not capture screenshot: " + e.getMessage());
        } finally {
            // Always quit the driver at the end
            DriverFactory.quitDriver();
        }
    }
}