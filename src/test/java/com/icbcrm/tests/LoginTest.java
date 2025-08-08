package com.icbcrm.tests;

import com.icbcrm.base.TestBase;
import com.icbcrm.pages.LoginPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest  extends TestBase
{
    LoginPage loginPage ;

    @BeforeMethod
    public void openAdminPortal()
    {
        initialization();
        loginPage = new LoginPage();
    }

    @Test
    public void testLoginWithValidCredentials() throws InterruptedException
    {
        switch (prop.getProperty("role"))
        {
            case "admin":
                loginPage.loginTest(prop.getProperty("adminMailId"), prop.getProperty("adminPassword"));
                break;
            case "partner":
                loginPage.loginTest(prop.getProperty("partnerMailId"), prop.getProperty("partnerPassword"));
                break;
            case "customer":
                loginPage.loginTest(prop.getProperty("customerMailId"), prop.getProperty("customerPassword"));
                break;
            case "manager":
                loginPage.loginTest(prop.getProperty("managerMailId"), prop.getProperty("managerPassword"));
                break;
            case "employee":
                loginPage.loginTest(prop.getProperty("employeeMailId"), prop.getProperty("employeePassword"));
                break;
            default:
                throw new IllegalArgumentException("Invalid role specified in configuration!");
        }

        Thread.sleep(2000);

        String redirectedPage = driver.getTitle();
        String expectedPageRedirected="Dashboard - icb";

        Assert.assertEquals(redirectedPage,expectedPageRedirected, "Login not successful!");
    }

   /* @Test
    public void testLoginWithInvalidCredentials() throws InterruptedException
    {
        loginPage.loginTest(prop.getProperty("adminMailId"), prop.getProperty("adminPassword"));
        Thread.sleep(2000);

        String redirectedPage = driver.getTitle();
        String expectedPageRedirected="Dashboard - icb";

        Assert.assertEquals(redirectedPage,expectedPageRedirected, "Login not successful!");
    }
*/
   /* @AfterMethod
    public void closeBrowser()
    {
        driver.quit();
    }*/
}