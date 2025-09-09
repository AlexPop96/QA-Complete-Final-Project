package cart;

import base.BaseTests;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class CartTests extends BaseTests {

    @Test
    //Add and remove product from the cart (4)
    public void addAndRemoveProduct(){
        homePage = loginPage.loginAsStandardUser();
        homePage.addItemToCart();
        cartPage = homePage.viewCart();
        assertEquals(cartPage.getItemName(), "Sauce Labs Backpack", "Text not found");
        cartPage.removeItemFromCart();
    }
}
