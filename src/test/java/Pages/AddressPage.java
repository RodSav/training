package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static Locators.AddAddressLocator.FLASH_MESSAGE_XPATH;
import static Locators.AddressBookLocators.*;

public class AddressPage {

    private WebDriver driver;

    public AddressPage(WebDriver driver) {
        this.driver = driver;
    }

    public AddAddressPage clickAddAddressLink() {
        driver.findElement(By.linkText("Add Address")).click();
        return new AddAddressPage(driver);
    }

    public AddAddressPage clickUpdateAddressFirstInAList() {
        driver.findElement(By.xpath(EDIT_ADDRESS)).click();
        return new AddAddressPage(driver);
    }

    public void removeAddress() {
        WebDriverWait wait5 = new WebDriverWait(driver, 5);
        wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DELETE_ADDRESS))).click();
        driver.findElement(By.xpath(DELETE_BUTTON_MODAL)).click();
        String flashMessage = driver.findElement(By.xpath(FLASH_MESSAGE_XPATH)).getText();
        if (!flashMessage.contains("Your address was removed."))
            throw  new AssertionError();
    }
}
