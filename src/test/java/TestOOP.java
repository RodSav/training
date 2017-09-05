import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class TestOOP {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        TestProject testProject = new TestProject("https://usabb-dev.zaelab.com/");
        User testUser = new User("matheu.silva@rustic-hw.com", "12341234");
        UserAddress userAddress = new UserAddress.UserAddressBuilder()
                .country("United states")
                .title("Mr")
                .firstName("Some")
                .lastName("Guy")
                .address1("TestOOP Address, 56")
                .city("New York")
                .region("New York")
                .postcode("12345")
                .phone("1122334455")
                .build();

        HomePage homePage = new HomePage(driver, testProject.getUrl());
        LoginPage loginPage = homePage.openLoginPage();
        loginPage.loginAs(testUser);
        AddressPage addressPage = homePage.openAddressPage();
        AddAddressPage addAddressPage = addressPage.openAddAddress();
        addAddressPage.fillNewAddress(userAddress);

        driver.quit();
    }
}
