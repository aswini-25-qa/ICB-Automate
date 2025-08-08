package com.icbcrm.base;
import java.io.FileInputStream;
import java.io.IOException;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import static com.icbcrm.util.TestUtil.IMPLICIT_WAIT;
import static com.icbcrm.util.TestUtil.PAGE_LOAD_WAIT;

public class TestBase
{
    public static WebDriver driver;
    public static Properties prop;

    public TestBase() throws IllegalArgumentException
    {
        try
        {
            prop = new Properties();
            FileInputStream ip = new FileInputStream("src/main/java/com/icbcrm/config/config.properties");
            prop.load(ip);
        }
        catch (IOException e)
        {
            throw new IllegalArgumentException(e);
        }
    }

    public static void initialization()
    {
        switch (prop.getProperty("browser"))
        {
            case "chrome":
                WebDriverManager.chromedriver().setup();

                ChromeOptions options = getChromeOptions ( );

                driver = new ChromeDriver(options);
                break;
            case "fireFox":
                driver = new FirefoxDriver();
                break;
            case "edgeBrowser":
                driver = new EdgeDriver();
                break;
            case "internetExplorer":
                driver = new InternetExplorerDriver();
                break;
            default:
                throw new IllegalArgumentException("Invalid browser specified in configuration!");
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_WAIT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
        driver.get(prop.getProperty("url"));
    }

    private static
    ChromeOptions getChromeOptions ( ) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-popup-blocking");

        // Disable password manager & password leak detection
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.password_manager_leak_detection", false); // key for breach alert
        options.setExperimentalOption("prefs", prefs);
        return options;
    }
}