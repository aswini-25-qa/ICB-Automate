package com.icbcrm.base;

import java.io.FileInputStream;
import java.io.IOException;

import java.time.Duration;
import java.util.Properties;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static com.icbcrm.util.TestUtil.IMPLICIT_WAIT;
import static com.icbcrm.util.TestUtil.PAGE_LOAD_WAIT;

public class TestBase
{
    //Declaration of Class Members
    public static WebDriver driver;
    public static Properties prop;

    //Constructor - Loads Configurations
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

    //Initializes Browser
    public static void initialization()
    {
        String browser = prop.getProperty("browser").toLowerCase();
        switch (browser)
        {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-notifications");
                driver = new ChromeDriver(options);
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Invalid browser specified in configuration!");
        }

        //Set Browser Properties
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_WAIT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));

        driver.get(prop.getProperty("url"));
    }
}