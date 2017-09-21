package definition_steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GlobalElementsStepDefs extends Pages {

    @Given("^open the site and login$")
    public void openTheSiteAndLogin() {
        startPage.open();
        loginPage = startPage.openLoginPage();
        loginPage = loginPage.loginAs(testUser);
    }

    @When("^open address book page$")
    public void clickOnLinkInHeader() {
        homePage.openAddressPage();
    }

    @When("^click on Add Address link$")
    public void clickOnAddAddressLink() {
        addAddressPage = addressPage.clickAddAddressLink();
    }

    @When("^filling the form and save address$")
    public void fillingTheForm() {
        addAddressPage.fillNewAddress(userAddress);
    }

    @Then("^address is saved$")
    public void addressIsSaved() {
        assert(addAddressPage.getNotification().contains("Your address was created."));
    }
}
