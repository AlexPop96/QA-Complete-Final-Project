package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class HomePage {

    private final WebDriver driver;
    private final By titleText = By.xpath("//div[@class='app_logo']");
    private final By addToCart = By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']");
    private final By menuButton = By.xpath("//button[@id='react-burger-menu-btn']");
    private final By logoutButton = By.id("logout_sidebar_link");
    private final By cartButton = By.xpath("//div[@id='shopping_cart_container']");
    private final By filterDropdown = By.xpath("//select[@data-test='product-sort-container']");
    private final By fleeceJacket = By.id("item_5_title_link");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitleText(){
        return driver.findElement(titleText).getText();
    }

    public void addItemToCart(){
        driver.findElement(addToCart).click();
    }

    public CartPage viewCart(){
        driver.findElement(cartButton).click();
        return new CartPage(driver);
    }

    public void getMenuButton(){
        driver.findElement(menuButton).click();
    }

    public LoginPage logoutOption(){
        driver.findElement(logoutButton).click();
        return new LoginPage(driver);
    }

    public void selectFromDropdown(String option){
        findDropdownElement().selectByValue(option);
    }

    private Select findDropdownElement(){
        return new Select(driver.findElement(filterDropdown));
    }

    public int getSelectedDropdownIndex(){
        return findDropdownElement().getOptions().indexOf(findDropdownElement().getFirstSelectedOption());
    }

    public String getSelectedDropdownText(){
        return findDropdownElement().getFirstSelectedOption().getText();
    }

    public ProductPage openFleeceJacket(){
        driver.findElement(fleeceJacket).click();
        return new ProductPage(driver);
    }
}
