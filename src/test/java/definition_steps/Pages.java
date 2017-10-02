package definition_steps;

import demo_project.Objects.User;
import demo_project.Objects.UserAddress;
import demo_project.Pages.AddressPage;
import demo_project.Pages.AddAddressPage;
import demo_project.Pages.HomePage;
import demo_project.Pages.LoginPage;

public class Pages {
    public static LoginPage loginPage;
    public static HomePage homePage;
    public static AddressPage addressPage;
    public static AddAddressPage addAddressPage;


    public static User testUser = new User("matheu.silva@rustic-hw.com", "12341234");
    public static UserAddress userAddress = new UserAddress.UserAddressBuilder()
                .country("United states")
                .title("Mr")
                .firstName("Some")
                .lastName("Guy")
                .address1("TestTestNG Address, 56")
                .city("New York")
                .region("New York")
                .postcode("12345")
                .phone("1122334455")
                .build();
}

