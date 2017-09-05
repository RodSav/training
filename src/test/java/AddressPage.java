import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddressPage {

    private WebDriver driver;

    public AddressPage(WebDriver driver) {
        this.driver = driver;
    }

    public AddAddressPage openAddAddress() {
        driver.findElement(By.linkText("Add Address")).click();
        return new AddAddressPage(driver);
    }
}
