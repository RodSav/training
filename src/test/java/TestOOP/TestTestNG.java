//package TestOOP;
//
//import Pages.AddAddressPage;
//import Pages.AddressPage;
//import Pages.HomePage;
//import Pages.LoginPage;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.remote.CapabilityType;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import Objects.*;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//import java.util.concurrent.TimeUnit;
//
//public class TestTestNG {
//    private WebDriver driver;
//    private TestProject testProject;
//    private User testUser;
//    private UserAddress userAddress;
//
//    @BeforeMethod
//    public void setUpTest() {
//        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
//        caps.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
//        driver = new FirefoxDriver(caps);
//        driver.manage().window().maximize();
//        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
//        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
//
//        testProject = new TestProject("https://demo-b2b.zaelab.com/yb2bacceleratorstorefront/");
//        testUser = new User("matheu.silva@rustic-hw.com", "12341234");
//        userAddress = new UserAddress.UserAddressBuilder()
//                .country("United states")
//                .title("Mr")
//                .firstName("Some")
//                .lastName("Guy")
//                .address1("TestTestNG Address, 56")
//                .city("New York")
//                .region("New York")
//                .postcode("12345")
//                .phone("1122334455")
//                .build();
//    }
//
//    @Test
//    public void testCreateAddress() {
//        HomePage homePage = new HomePage(driver, testProject.getUrl());
//        LoginPage loginPage = homePage.openLoginPage();
//        loginPage.loginAs(testUser);
//        AddressPage addressPage = homePage.openAddressPage();
//        AddAddressPage addAddressPage = addressPage.clickAddAddressLink();
//        addAddressPage.fillNewAddress(userAddress);
//        assert(addAddressPage.getNotification().contains("Your address was created."));
//    }
//
//    @Test
//    public void testUpdateAddress() {
//        HomePage homePage = new HomePage(driver, testProject.getUrl());
//        LoginPage loginPage = homePage.openLoginPage();
//        loginPage.loginAs(testUser);
//        AddressPage addressPage = homePage.openAddressPage();
//        AddAddressPage addAddressPage = addressPage.clickUpdateAddressFirstInAList();
//        addAddressPage.updateAddress();
//    }
//
//    @Test
//    public void testRemoveAddress() {
//        HomePage homePage = new HomePage(driver, testProject.getUrl());
//        LoginPage loginPage = homePage.openLoginPage();
//        loginPage.loginAs(testUser);
//        AddressPage addressPage = homePage.openAddressPage();
//        addressPage.removeAddress();
//    }
//
//    @AfterMethod
//    public void tearDown() {
//        driver.quit();
//    }
//}
