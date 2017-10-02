package demo_project.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import demo_project.Objects.*;
import ru.yandex.qatools.allure.annotations.Step;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Login as {0}.")
    public LoginPage loginAs (User testUser) {
        driver.findElement(By.xpath(".//*[@id='j_username']")).sendKeys(testUser.getUsername());
        driver.findElement(By.xpath(".//*[@id='j_password']")).sendKeys(testUser.getPassword());
        driver.findElement(By.xpath(".//*[@id='loginForm']/button")).click();
        return new LoginPage(driver);
    }
}
