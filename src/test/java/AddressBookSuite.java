import cucumber.api.CucumberOptions;
import cucumber.api.java.Before;
import runners.CucumberTestsRunner;

@CucumberOptions(
        features = "src/test/resources/features/address_book_features/")

public class AddressBookSuite extends CucumberTestsRunner {

    @Before
    public void setIt() {
        System.out.println("start");
    }
}
