Feature: create, update, delete address

  Scenario: Verify address can be created
    Given open the site and login
    When open address book page
    When click on Add Address link
    When filling the form and save address
    Then address is saved
