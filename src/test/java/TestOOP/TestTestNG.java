package TestOOP;

import Pages.AddAddressPage;
import Pages.AddressPage;
import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import Objects.*;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;

public class TestTestNG {
    private WebDriver driver;
    private TestProject testProject;
    private User testUser;
    private UserAddress userAddress;

    @BeforeSuite
    public void setUpTest() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        testProject = new TestProject("https://usabb-dev.zaelab.com/");
        testUser = new User("matheu.silva@rustic-hw.com", "12341234");
        userAddress = new UserAddress.UserAddressBuilder()
                .country("United states")
                .title("Mr")
                .firstName("Some")
                .lastName("Guy")
                .address1("TestTestNG Address, 56")
                .city("New York")
                .region("New York")
                .postcode("12345")
                .phone("1122334455")
                .build();
    }

    @Test
    public void testNGTest() {
        HomePage homePage = new HomePage(driver, testProject.getUrl());
        LoginPage loginPage = homePage.openLoginPage();
        loginPage.loginAs(testUser);
        AddressPage addressPage = homePage.openAddressPage();
        AddAddressPage addAddressPage = addressPage.openAddAddress();
        addAddressPage.fillNewAddress(userAddress);
        assert(addAddressPage.getNotification().contains("Your address was created."));
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}
