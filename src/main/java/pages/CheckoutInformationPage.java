package pages;

import enums.CheckoutInformationEnums;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutInformationPage {

    private final WebDriver driver;
    private final By firstNameField = By.id("first-name");
    private final By lastNameField = By.id("last-name");
    private final By postalCodeField = By.id("postal-code");
    private final By continueButton = By.xpath("//input[@id='continue']");
    private final By checkoutPageMessage = By.xpath("//span[@data-test='title']");

    public CheckoutInformationPage(WebDriver driver) {
        this.driver = driver;
    }

    private By getFieldLocator(CheckoutInformationEnums field){
        return switch (field) {
            case FIRST_NAME -> firstNameField;
            case LAST_NAME -> lastNameField;
            case POSTAL_CODE -> postalCodeField;
        };
    }

    public void fillField(CheckoutInformationEnums field, String value){
        By locator = getFieldLocator(field);
        driver.findElement(locator).sendKeys(value);
    }

    public CheckoutOverviewPage clickContinueButton(){
        driver.findElement(continueButton).click();
        return new CheckoutOverviewPage(driver);
    }

    public String getCheckoutPageMessage(){
        return driver.findElement(checkoutPageMessage).getText();
    }
}
