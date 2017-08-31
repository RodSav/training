import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class TestOOP {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        TestProject testProject = new TestProject("https://usabb-dev.zaelab.com/");
        User testUser = new User("matheu.silva@rustic-hw.com", "12341234");
        UserAddress userAddress = new UserAddress.UserAddressBuilder()
                .country("United states")
                .title("Mr.")
                .firstName("Some")
                .lastName("Guy")
                .address1("TestOOP Address, 56")
                .city("New York")
                .region("New York")
                .postcode("12345")
                .phone("1122334455")
                .build();

        driver.get(testProject.getUrl());
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.xpath(".//*[@id='j_username']")).sendKeys(testUser.getUsername());
        driver.findElement(By.xpath(".//*[@id='j_password']")).sendKeys(testUser.getPassword());
        driver.findElement(By.xpath(".//*[@id='loginForm']/button")).click();

        // Needs assertion of success login
        driver.findElement(By.linkText("My Account")).click();
        driver.findElement(By.xpath(".//*[@id='accNavComponentDesktopOne']/ul/li[6]/a")).click();
        driver.findElement(By.linkText("Add Address")).click();
        driver.findElement(By.xpath(".//*[@id='address.country']")).click();
        driver.findElement(By.xpath("//*[@id='address.country']")).click();
        driver.findElement(By.xpath("//*[@id='address.country']//option[contains(text(), 'United States')]")).click();
        driver.findElement(By.xpath("//*[@id='address.title']")).click();
        driver.findElement(By.xpath("//*[@id='address.title']//option[contains(text(), 'Mr.')]")).click();
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

        driver.quit();
    }
}
