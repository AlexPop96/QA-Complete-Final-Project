package filter;

import base.BaseTests;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class FilterProductsTest extends BaseTests {

    @Test
    //Filter products based on options from dropdown (6)
    public void selectOptionTest() {
        homePage = loginPage.loginAsStandardUser();
        homePage.selectFromDropdown("hilo");
        assertEquals(homePage.getSelectedDropdownText(), "Price (high to low)", "Selection by text failed");
        homePage.selectFromDropdown("za");
        assertEquals(homePage.getSelectedDropdownIndex(), 1, "Dropdown index mismatch");
    }
}
