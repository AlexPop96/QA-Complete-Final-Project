package login;

import base.BaseTests;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class LoginTests extends BaseTests {

    @Test
    //Login with standard user and log out (1, 7)
    public void loginTestSuccessful(){
        homePage = loginPage.loginAsStandardUser();
        assertTrue(homePage.getTitleText().contains("Swag Labs"), "Text not found");
        homePage.getMenuButton();
        loginPage = homePage.logoutOption();
        assertTrue(loginPage.isLoginButtonDisplayed(), "You are not logged out");
    }

    @Test
    //Login with wrong user (2)
    public void loginTestFailed() {
        loginPage.setUsernameField("standard_user");
        loginPage.setPasswordField("abracadabra");
        loginPage = loginPage.clickLoginButtonWrongCredentials();
        assertTrue(loginPage.getErrorMessage().contains(
                "Epic sadface: Username and password do not match any user in this service"), "Text not found");
    }

    @Test
    //Login with locked-out-user(3)
    public void loginLockedUser() {
        loginPage.setUsernameField("locked_out_user");
        loginPage.setPasswordField("secret_sauce");
        loginPage = loginPage.clickLoginButtonLockedUser();
        assertTrue(loginPage.getErrorMessage().contains(
                "Epic sadface: Sorry, this user has been locked out."), "Text not found");
        loginPage.clickCloseModalButton();
    }
}