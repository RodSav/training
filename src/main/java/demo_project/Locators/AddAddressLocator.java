package demo_project.Locators;

public class AddAddressLocator {
    public static String ADDRESS_COUNTRY_DROPDOWN_XPATH = ".//*[@id='address.country']";
    public static String UNITED_STATES_XPATH = "//*[@id='address.country']//option[contains(text(), 'United States')]";
    public static String TITLE_DROPDOWN_XPATH = "//*[@id='address.title']";
    public static String TITLE_MR_XPATH = "//*[@id='address.title']//option[contains(text(), 'Mrs')]";
    public static String FIRSTNAME_FIELD_XPATH = "//*[@id='address.firstName']";
    public static String LASTNAME_FIELD_XPATH = "//*[@id='address.surname']";
    public static String ADDRESS1_FIELD_XPATH = "//*[@id='address.line1']";
    public static String CITY_XPATH = "//*[@id='address.townCity']";
    public static String REGION_DROPDOWN_XPATH = "//*[@id='address.region']";
    public static String NEW_YORK_DROPDOWN_XPATH  = "//*[@id='address.region']//option[contains(text(), 'New York')]";
    public static String POSTCODE_FIELD_XPATH = "//*[@id='address.postcode']";
    public static String PHONE_FIELD_XPATH = "//*[@id='address.phone']";
    public static String SUBMIT_BUTTON_XPATH = ".//*[@id='addressform_button_panel']/div/div/div[1]/button";
    public static String FLASH_MESSAGE_XPATH = "html/body/main/div[3]/div[1]/div";
}
