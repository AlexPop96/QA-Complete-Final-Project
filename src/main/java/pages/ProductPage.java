package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {

    private final WebDriver driver;
    private final By backToProducts = By.xpath("//button[@id='back-to-products']");
    private final By addJacket = By.id("add-to-cart");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isBackToProductsEnable(){
        return driver.findElement(backToProducts).isEnabled();
    }

    public void addJacketToCart(){
        driver.findElement(addJacket).click();
    }
}
