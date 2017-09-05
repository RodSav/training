import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage loginAs (User testUser) {
        driver.findElement(By.xpath(".//*[@id='j_username']")).sendKeys(testUser.getUsername());
        driver.findElement(By.xpath(".//*[@id='j_password']")).sendKeys(testUser.getPassword());
        driver.findElement(By.xpath(".//*[@id='loginForm']/button")).click();
        return new LoginPage(driver);
    }
}
