package order;

import base.BaseTests;
import enums.CheckoutInformationEnums;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class OrderProductTest extends BaseTests {

    @Test
    //Complete an order for one product (5)
    public void completeOrderOfAProduct() throws InterruptedException {
        homePage = loginPage.loginAsStandardUser();
        productPage = homePage.openFleeceJacket();
        assertTrue(productPage.isBackToProductsEnable(), "Button is not enable!");
        productPage.addJacketToCart();
        cartPage = homePage.viewCart();
        assertTrue(cartPage.getJacketName().contains("Sauce Labs Fleece Jacket"), "Text not found");
        checkoutInformationPage = cartPage.clickCheckoutButton();
        assertTrue(checkoutInformationPage.getCheckoutPageMessage().contains("Checkout: Your Information"), "Text not found");
        checkoutInformationPage.fillField(CheckoutInformationEnums.FIRST_NAME, "Alex");
        checkoutInformationPage.fillField(CheckoutInformationEnums.LAST_NAME, "Pop");
        checkoutInformationPage.fillField(CheckoutInformationEnums.POSTAL_CODE, "437295");
        checkoutOverviewPage = checkoutInformationPage.clickContinueButton();
        assertTrue(checkoutOverviewPage.getShippingInformation().contains("Free Pony Express Delivery!"), "Text not found");
        checkoutCompletePage = checkoutOverviewPage.clickFinishButton();
        assertTrue(checkoutCompletePage.getCompleteOrderMessage().contains("Thank you for your order!"), "Text not found");
        checkoutCompletePage.backHomeButton();
    }
}
