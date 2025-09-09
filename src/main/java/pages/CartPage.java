package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage{

    private final WebDriver driver;
    private final By itemName = By.xpath("//div[@data-test='inventory-item-name']");
    private final By removeItem = By.xpath("//button[@id='remove-sauce-labs-backpack']");
    private final By jacketName = By.xpath("//div[@data-test='inventory-item-name']");
    private final By checkoutButton = By.xpath("//button[@id='checkout']");

    public CartPage(WebDriver driver){
        this.driver = driver;
    }

    public String getItemName(){
        return driver.findElement(itemName).getText();
    }

    public void removeItemFromCart(){
        driver.findElement(removeItem).click();
    }

    public String getJacketName(){
        return driver.findElement(jacketName).getText();
    }

    public CheckoutInformationPage clickCheckoutButton(){
        driver.findElement(checkoutButton).click();
        return new CheckoutInformationPage(driver);
    }
}
