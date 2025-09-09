package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.*;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class BaseTests {

    private WebDriver driver;
    protected LoginPage loginPage;
    protected HomePage homePage;
    protected CartPage cartPage;
    protected ProductPage productPage;
    protected CheckoutInformationPage checkoutInformationPage;
    protected CheckoutOverviewPage checkoutOverviewPage;
    protected CheckoutCompletePage checkoutCompletePage;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");

        ChromeOptions chromeOption = new ChromeOptions();
        chromeOption.addArguments("--remote-allow-origins=*");
        chromeOption.addArguments("--ignore-certificate-errors");
        chromeOption.addArguments("--disable-infobars");
        chromeOption.addArguments("--disable-popup-blocking");
        chromeOption.addArguments("--disable-default-apps");
        chromeOption.addArguments("--no-first-run");
        chromeOption.addArguments("--no-default-browser-check");
        chromeOption.addArguments("--disable-search-engine-choice-screen");
        chromeOption.addArguments("--disable-notifications");
        chromeOption.addArguments("--disable-extensions");
        chromeOption.addArguments("--password-store=basic");
        chromeOption.addArguments("--disable-blink-features=PasswordCredential");
        chromeOption.addArguments("--disable-save-password-bubble");
        chromeOption.addArguments("--disable-features=PasswordCheck,AutofillAssistant,PasswordManagerOnboarding");
        chromeOption.addArguments("--incognito");
        chromeOption.addArguments("--guest");

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        chromeOption.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(chromeOption);
        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        loginPage = new LoginPage(driver);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
