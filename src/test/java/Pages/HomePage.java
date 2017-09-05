package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private String projectUrl;

    public HomePage(WebDriver driver, String projectUrl) {
        this.driver = driver;
        this.projectUrl = projectUrl;
        this.driver.get(projectUrl);
    }

    public LoginPage openLoginPage() {
        driver.findElement(By.linkText("Sign in")).click();
        return new LoginPage(driver);
    }

    public AddressPage openAddressPage() {
        driver.findElement(By.linkText("My Account")).click();
        driver.findElement(By.xpath(".//*[@id='accNavComponentDesktopOne']/ul/li[6]/a")).click();
        return new AddressPage(driver);
    }
}
