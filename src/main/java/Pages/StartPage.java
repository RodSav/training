package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class StartPage {
    private WebDriver driver;
    private String startUrl;

    public StartPage(WebDriver driver) {
        this.driver = driver;
    }

    public StartPage(WebDriver driver, String projectUrl) {
        this.driver = driver;
        this.startUrl = projectUrl;
        this.driver.get(startUrl);
    }

    public StartPage open() {
        driver.get(startUrl);
        return this;
    }

    public LoginPage openLoginPage() {
        driver.findElement(By.linkText("Sign in")).click();
        return new LoginPage(driver);
    }
}

