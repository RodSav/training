Feature: Verify address book can be created, updated and deleted

  Scenario: Check that new address can be created
    Given login to site
    When select Address Book in My Account menu
    When click on add address button
    When submit new address
    Then new address is created

  Scenario: Check that address can be updated
    Given login to site
    When select Address Book in My Account menu
    When click on update address button
    When submit updated address
    Then address is updated

  Scenario: Check that address can be deleted
    Given login to site
    When select Address Book in My Account menu
    When deleting address
    Then address is deleted
