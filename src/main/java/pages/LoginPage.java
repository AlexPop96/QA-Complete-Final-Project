package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final WebDriver driver;
    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By loginErrorMessage = By.xpath("//div[@class='error-message-container error']");
    private final By closeButton = By.xpath("//div[@class='error-message-container error']//button");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void setUsernameField(String username){
        driver.findElement(usernameField).sendKeys(username);
    }

    public void setPasswordField(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public HomePage clickLoginButton(){
        driver.findElement(loginButton).click();
        return new HomePage(driver);
    }

    public LoginPage clickLoginButtonWrongCredentials(){
        driver.findElement(loginButton).click();
        return new LoginPage(driver);
    }

    public LoginPage clickLoginButtonLockedUser(){
        driver.findElement(loginButton).click();
        return new LoginPage(driver);
    }

    public void clickCloseModalButton(){
        driver.findElement(closeButton).click();
    }

    public String getErrorMessage(){
        return driver.findElement(loginErrorMessage).getText();
    }

    public boolean isLoginButtonDisplayed(){
        return driver.findElement(loginButton).isDisplayed();
    }

    //Method for login with standard user
    public HomePage loginAsStandardUser(){
        setUsernameField("standard_user");
        setPasswordField("secret_sauce");
        return clickLoginButton();
    }
}
