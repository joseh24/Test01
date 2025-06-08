package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;


public class BaseTest {
    public static WebDriver driver;

    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false); // Disables prompt to save passwords
        prefs.put("profile.password_manager_enabled", false); // Disables password manager
        prefs.put("profile.password_manager_leak_detection", false); // Disables "password found in data breach" warning
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("--headless"); // Run in headless mode
        driver = new ChromeDriver(options);
        driver.get("https://www.saucedemo.com");
        driver.manage().window().maximize();
    }

    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
