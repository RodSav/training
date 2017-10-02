package runners;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import definition_steps.Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import demo_project.Objects.TestProject;
import demo_project.Pages.HomePage;

import java.util.concurrent.TimeUnit;

public class CucumberTestsRunner extends AbstractTestNGCucumberTests {
    private TestNGCucumberRunner testNGCucumberRunner;

    private WebDriver driver;
    private TestProject testProject;

    @BeforeSuite
    public void initSuite() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        caps.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        driver = new FirefoxDriver(caps);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        testProject = new TestProject("https://demo-b2b.zaelab.com/yb2bacceleratorstorefront/");
        Pages.homePage = new HomePage(driver, testProject.getUrl());
    }

    @BeforeClass
    public void initClass() {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeature) {
        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
    }

    @DataProvider
    public Object[][] features() {
        return testNGCucumberRunner.provideFeatures();
    }

    @AfterClass
    public void finishClass() {
        testNGCucumberRunner.finish();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDownClass() throws Exception {
        driver.quit();
    }
}
