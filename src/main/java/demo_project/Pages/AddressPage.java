package demo_project.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

import static demo_project.Locators.AddAddressLocator.FLASH_MESSAGE_XPATH;
import static demo_project.Locators.AddressBookLocators.*;

public class AddressPage {

    private WebDriver driver;

    public AddressPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click add address link")
    public AddAddressPage clickAddAddressLink() {
        driver.findElement(By.linkText("Add Address")).click();
        return new AddAddressPage(driver);
    }

    @Step("Click update address link")
    public AddAddressPage clickUpdateAddressFirstInAList() {
        driver.findElement(By.xpath(EDIT_ADDRESS)).click();
        return new AddAddressPage(driver);
    }

    @Step("Click remove address link")
    public void removeAddress() {
        WebDriverWait wait5 = new WebDriverWait(driver, 5);
        wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DELETE_ADDRESS))).click();
        driver.findElement(By.xpath(DELETE_BUTTON_MODAL)).click();
        String flashMessage = driver.findElement(By.xpath(FLASH_MESSAGE_XPATH)).getText();
        if (!flashMessage.contains("Your address was removed."))
            throw  new AssertionError();
    }

    @Step("Get notification")
    public String getNotification() {
        return driver.findElement(By.xpath(FLASH_MESSAGE_XPATH)).getText();
    }
}
