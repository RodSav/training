package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import Objects.*;
import static Locators.AddAddressLocator.*;

public class AddAddressPage {
    private WebDriver driver;

    public AddAddressPage(WebDriver driver) {
        this.driver = driver;
    }

    public AddAddressPage fillNewAddress(UserAddress userAddress) {
//        driver.findElement(By.xpath(".//*[@id='address.country']")).click();
        driver.findElement(By.xpath(ADDRESS_COUNTRY_DROPDOWN_XPATH)).click();
        driver.findElement(By.xpath(UNITED_STATES_XPATH)).click();
        driver.findElement(By.xpath(TITLE_DROPDOWN_XPATH)).click();
        driver.findElement(By.xpath(TITLE_MR_XPATH)).click();
        driver.findElement(By.xpath(FIRSTNAME_FIELD_XPATH)).sendKeys(userAddress.getFirstName());
        driver.findElement(By.xpath(LASTNAME_FIELD_XPATH)).sendKeys(userAddress.getLastName());
        driver.findElement(By.xpath(ADDRESS1_FIELD_XPATH)).sendKeys(userAddress.getAddress1());
        driver.findElement(By.xpath(CITY_XPATH)).sendKeys(userAddress.getCity());
        driver.findElement(By.xpath(REGION_DROPDOWN_XPATH)).click();
        driver.findElement(By.xpath(NEW_YORK_DROPDOWN_XPATH)).click();
        driver.findElement(By.xpath(POSTCODE_FIELD_XPATH)).sendKeys(userAddress.getPostcode());
        driver.findElement(By.xpath(PHONE_FIELD_XPATH)).sendKeys(userAddress.getPhone());
        driver.findElement(By.xpath(SUBMIT_BUTTON_XPATH)).click();
        String flashMessage = driver.findElement(By.xpath(FLASH_MESSAGE_XPATH)).getText();
        //assertFalse
        if (!flashMessage.contains("Your address was created."))
            throw  new AssertionError();
        return new AddAddressPage(driver);
    }

    public String getNotification() {
        return driver.findElement(By.xpath(FLASH_MESSAGE_XPATH)).getText();
    }
}
