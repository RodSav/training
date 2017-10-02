package definition_steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddressStepDefs extends Pages{

    @Given("^login to site$")
    public void loginToSite() {
        homePage.open();
        loginPage = homePage.openLoginPage();
        loginPage.loginAs(testUser);
    }

    @When("^select Address Book in My Account menu$")
    public void selectAddressBookInMyAccountMenu() {
        addressPage = homePage.openAddressPage();
    }

    @When("^click on add address button$")
    public void clickOnAddAddressButton() {
        addAddressPage = addressPage.clickAddAddressLink();
    }


    @When("^submit new address$")
    public void fillInAddressForm() {
        addAddressPage.fillNewAddress(userAddress);
    }

    @Then("^new address is created$")
    public void newAddressIsCreated() {
        String flashMsg = addAddressPage.getNotification();
        if (!flashMsg.contains("Your address was created."))
            throw  new AssertionError();
    }

    @When("^click on update address button$")
    public void clickOnUpdateAddressButton() {
        addAddressPage = addressPage.clickUpdateAddressFirstInAList();
    }

    @When("^submit updated address$")
    public void submitUpdatedAddress() {
        addAddressPage.updateAddress();
    }

    @Then("^address is updated$")
    public void addressIsUpdated() {
        String flashMsg = addAddressPage.getNotification();
        if (!flashMsg.contains("Your address was updated."))
            throw  new AssertionError();
    }

    @When("^deleting address$")
    public void deletingAddress() {
        addressPage.removeAddress();
    }

    @Then("^address is deleted$")
    public void addressIsDeleted() {
        String flashMsg = addressPage.getNotification();
        if (!flashMsg.contains("Your address was removed."))
            throw  new AssertionError();
    }
}
