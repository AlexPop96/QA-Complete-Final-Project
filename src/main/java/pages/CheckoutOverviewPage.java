package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage {

    private final WebDriver driver;
    private final By finishButton = By.xpath("//button[@id='finish']");
    private final By shippingInformation = By.xpath("//div[@data-test='shipping-info-value']");

    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getShippingInformation(){
        return driver.findElement(shippingInformation).getText();
    }

    public CheckoutCompletePage clickFinishButton(){
        driver.findElement(finishButton).click();
        return new CheckoutCompletePage(driver);
    }
}
