package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage {

    private final WebDriver driver;
    private final By completeOrder = By.xpath("//h2[@data-test='complete-header']");
    private final By backHome = By.xpath("//button[@id='back-to-products']");

    public CheckoutCompletePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getCompleteOrderMessage(){
        return driver.findElement(completeOrder).getText();
    }

    public HomePage backHomeButton(){
        driver.findElement(backHome).click();
        return new HomePage(driver);
    }
}
