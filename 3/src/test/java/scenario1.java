import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class scenario1 {
    private WebDriver googleDriver;
    private WebDriver firefoxDriver;
    private ChromeOptions options;
    private FirefoxOptions profile;
    private final static String CHROME_NOTIFICATION = "profile.default_content_setting_values.notifications";
    private final static String FIREFOX_NOTIFICATION = "dom.webnotifications.enabled";
    private final static String EXPECTED_TITLE = "Sklep komputerowy - Komputronik Mamy to!";
    private final static String URL = "https://www.komputronik.pl/";
    private final static String COOKIE_DIALOG = "onetrust-button-group-parent";
    private final static String COOKIE_ACCEPT_DIALOG = "onetrust-button-group";
    private final static String SEARCH_BAR = ".at-input-search";
    private final static String INPUT = "HP Victus";
    private final static String RESULT = "Produkt dodany do koszyka";

    @BeforeAll
    static void setupBrowserDrivers(){
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
    }

    @BeforeEach
    public void setup(){
        Map<String, Object> prefs = new HashMap<String, Object>();
        options = new ChromeOptions();
        prefs.put(CHROME_NOTIFICATION, 2);
        options.setExperimentalOption("prefs", prefs);
        googleDriver = new ChromeDriver(options);

        profile = new FirefoxOptions();
        profile.setProfile(new FirefoxProfile());
        profile.addPreference(FIREFOX_NOTIFICATION, false);
        firefoxDriver = new FirefoxDriver(profile);
    }

    @AfterEach
    public void close(){
        googleDriver.quit();
        firefoxDriver.quit();
    }

    @Test
    public void addToBasketChrome() {
        String currentTitle = "";
        googleDriver.get(URL);

        currentTitle = googleDriver.getTitle();
        Assertions.assertEquals(currentTitle, EXPECTED_TITLE);

        try {
            WebDriverWait wait = new WebDriverWait(googleDriver, Duration.ofMillis(5000));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(COOKIE_DIALOG)));
        } catch (TimeoutException ignored){}

        if (googleDriver.findElement(By.id(COOKIE_DIALOG)).isDisplayed())
            googleDriver.findElement(By.id(COOKIE_ACCEPT_DIALOG)).click();

        WebElement searchBar = googleDriver.findElement(By.cssSelector(SEARCH_BAR));
        searchBar.sendKeys(INPUT);
        searchBar.sendKeys(Keys.ENTER);

        try {
            WebDriverWait wait = new WebDriverWait(googleDriver, Duration.ofMillis(5000));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("products-list")));
        } catch (TimeoutException e) {
            throw new TimeoutException("product list not found");
        }

        WebElement searchItem = googleDriver.findElement(By.cssSelector(".at-product-name-0"));
        searchItem.click();

        googleDriver.findElement(By.cssSelector(".at-add-to-cart")).click();

        try {
            WebDriverWait wait = new WebDriverWait(googleDriver, Duration.ofMillis(5000));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".layer-promotions")));
        } catch (TimeoutException e) {
            throw new TimeoutException("promotion list not found");
        }
        googleDriver.findElement(By.className("close")).click();

        String addedToBasket = googleDriver.findElement(By.className("caption")).getText();
        Assertions.assertEquals(addedToBasket, RESULT);
    }

    @Test
    public void addToBasketFirefox() {
        String currentTitle = "";
        firefoxDriver.get(URL);

        currentTitle = firefoxDriver.getTitle();
        Assertions.assertEquals(currentTitle, EXPECTED_TITLE);

        try {
            WebDriverWait wait = new WebDriverWait(firefoxDriver, Duration.ofMillis(5000));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("onetrust-group-container")));
        } catch (TimeoutException ignored){}

        if (firefoxDriver.findElement(By.id("onetrust-group-container")).isDisplayed())
            firefoxDriver.findElement(By.id("onetrust-accept-btn-handler")).click();

        WebElement searchBar = firefoxDriver.findElement(By.cssSelector(SEARCH_BAR));
        searchBar.sendKeys(INPUT);
        searchBar.sendKeys(Keys.ENTER);

        try {
            WebDriverWait wait = new WebDriverWait(firefoxDriver, Duration.ofMillis(5000));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("products-list")));
        } catch (TimeoutException e) {
            throw new TimeoutException("product list not found");
        }

        WebElement searchItem = firefoxDriver.findElement(By.cssSelector(".at-product-name-0"));
        searchItem.click();

        firefoxDriver.findElement(By.cssSelector(".at-add-to-cart")).click();

        try {
            WebDriverWait wait = new WebDriverWait(firefoxDriver, Duration.ofMillis(5000));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".layer-promotions")));
        } catch (TimeoutException e) {
            throw new TimeoutException("promotion list not found");
        }
        firefoxDriver.findElement(By.className("close")).click();

        String addedToBasket = firefoxDriver.findElement(By.className("caption")).getText();
        Assertions.assertEquals(addedToBasket, RESULT);
    }

}
