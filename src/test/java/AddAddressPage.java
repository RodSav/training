import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddAddressPage {
    private WebDriver driver;

    public AddAddressPage(WebDriver driver) {
        this.driver = driver;
    }

    public AddAddressPage fillNewAddress(UserAddress userAddress) {
        driver.findElement(By.xpath(".//*[@id='address.country']")).click();
        driver.findElement(By.xpath("//*[@id='address.country']")).click();
        driver.findElement(By.xpath("//*[@id='address.country']//option[contains(text(), 'United States')]")).click();
        driver.findElement(By.xpath("//*[@id='address.title']")).click();
        driver.findElement(By.xpath("//*[@id='address.title']//option[contains(text(), 'Mr')]")).click();
        driver.findElement(By.xpath("//*[@id='address.firstName']")).sendKeys(userAddress.getFirstName());
        driver.findElement(By.xpath("//*[@id='address.surname']")).sendKeys(userAddress.getLastName());
        driver.findElement(By.xpath("//*[@id='address.line1']")).sendKeys(userAddress.getAddress1());
        driver.findElement(By.xpath("//*[@id='address.townCity']")).sendKeys(userAddress.getCity());
        driver.findElement(By.xpath("//*[@id='address.region']")).click();
        driver.findElement(By.xpath("//*[@id='address.region']//option[contains(text(), 'New York')]")).click();
        driver.findElement(By.xpath("//*[@id='address.postcode']")).sendKeys(userAddress.getPostcode());
        driver.findElement(By.xpath("//*[@id='address.phone']")).sendKeys(userAddress.getPhone());
        driver.findElement(By.xpath(".//*[@id='addressform_button_panel']/div/div/div[1]/button")).click();
        String flashMessage = driver.findElement(By.xpath("html/body/main/div[3]/div[1]/div")).getText();
        //assertFalse
        if (!flashMessage.contains("Your address was created."))
            throw  new AssertionError();
        return new AddAddressPage(driver);
    }
}
