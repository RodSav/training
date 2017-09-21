package definition_steps;

import Objects.UserAddress;
import Pages.AddressPage;
import Pages.LoginPage;
import Pages.HomePage;
import Pages.AddAddressPage;
import Pages.StartPage;
import Objects.User;

public class Pages {
    public static AddressPage addressPage;
    public static LoginPage loginPage;
    public static HomePage homePage;
    public static AddAddressPage addAddressPage;
    public static StartPage startPage;

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
