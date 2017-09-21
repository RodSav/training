package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static Locators.HomePageLocators.*;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }


    public AddressPage openAddressPage() {
        driver.findElement(By.linkText("My Account")).click();
        driver.findElement(By.xpath(ADDRESS_BOOK_MY_ACCOUNT)).click();
        return new AddressPage(driver);
    }
}
