package demo_project.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;

import static demo_project.Locators.HomePageLocators.*;

public class HomePage {
    private WebDriver driver;
    private String projectUrl;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage(WebDriver driver, String projectUrl) {
        this.driver = driver;
        this.projectUrl = projectUrl;
        this.driver.get(projectUrl);
    }

    @Step("Open home page")
    public HomePage open() {
        driver.get(projectUrl);
        return this;
    }

    @Step("Open login page")
    public LoginPage openLoginPage() {
        driver.get(driver.getCurrentUrl() + "powertools/en/USD/login");
        return new LoginPage(driver);
    }

    @Step("Open address page")
    public AddressPage openAddressPage() {
        driver.findElement(By.linkText("My Account")).click();
        driver.findElement(By.xpath(ADDRESS_BOOK_MY_ACCOUNT)).click();
        return new AddressPage(driver);
    }
}
