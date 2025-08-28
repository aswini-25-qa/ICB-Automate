package com.icbcrm.tests;

import com.icbcrm.base.TestBase;
import com.icbcrm.pages.LoginPage;
import com.icbcrm.pages.ServicesPage;
import org.testng.Assert;
import org.testng.annotations.*;

import static sun.security.jgss.GSSUtil.login;

public class LoginTest  extends TestBase
{
    //Instance Variables
    LoginPage loginPage ;
    ServicesPage servicesPage;

    @BeforeMethod
    public void openLoginPortal()
    {
        initialization();
        loginPage = new LoginPage();
        servicesPage=new ServicesPage();
    }

    public void openServicePortal()
    {
        initialization();
        loginPage = new LoginPage();
        servicesPage=new ServicesPage();
    }
   /* @DataProvider(name = "invalidLoginData")
    public Object[][] getInvalidLoginData()
    {
        return LoginUtility.getTestData(System.getProperty("user.dir")+"/src/main/java/com/icbcrm/resources/ICBCREDENTIALS.xlsx", "Sheet1");
    }*/

    @Test(priority = 1)
    public void testLogin() throws InterruptedException, IllegalArgumentException
    {
        switch (prop.getProperty("role"))
        {
            case "admin":
                loginPage.login(prop.getProperty("adminMailId"), prop.getProperty("adminPassword"));
            break;
            case "partner":
                loginPage.login(prop.getProperty("partnerMailId"), prop.getProperty("partnerPassword"));
            break;
            case "customer":
                loginPage.login(prop.getProperty("customerMailId"), prop.getProperty("customerPassword"));
            break;
            case "manager":
                loginPage.login(prop.getProperty("managerMailId"), prop.getProperty("managerPassword"));
            break;
            case "employee":
                loginPage.login(prop.getProperty("employeeMailId"), prop.getProperty("employeePassword"));
            break;
            default:
                throw new IllegalArgumentException("Invalid role specified in configuration!");
        }

        Thread.sleep(2000);

        String redirectedPage = driver.getTitle();
        String expectedPageRedirected="Dashboard - icb";

        Assert.assertEquals(redirectedPage,expectedPageRedirected, "Login not successful!");
    }

    @Test(priority = 2)
    public void testClickOnServices() throws InterruptedException
    {
        login();
        servicesPage.clickServicesMenu();
    }


   /* @Test(dataProvider = "invalidLoginData")
    public void testLoginWithInvalidCredentials(String username, String password) throws InterruptedException
    {
        System.out.println(username);
        System.out.println(password);
        if (prop.getProperty("role").equals("admin"))
        {
            loginPage.loginTest(username, password);
            Thread.sleep(2000);
        }
        else
        {
            throw new IllegalArgumentException("Invalid role specified in configuration!");
        }
        String redirectedPage = driver.getTitle();
        String expectedPageRedirected = "Dashboard - icb";

        Assert.assertEquals(redirectedPage, expectedPageRedirected, "Login not successful!");
    }
*/

    @AfterTest
    public void closeBrowser()
    {
        driver.quit();
    }
}