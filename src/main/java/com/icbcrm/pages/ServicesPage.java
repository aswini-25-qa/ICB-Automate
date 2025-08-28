package com.icbcrm.pages;

import com.icbcrm.base.TestBase;
import com.icbcrm.util.TestUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ServicesPage  extends TestBase
{
    //Constructor to initialize WebElements annotated with @FindBy.
    public ServicesPage()
    {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="/html/body/div[1]/aside/nav/ul/li[2]/ul/li[3]/a")
    WebElement servicesMenu;
    @FindBy(xpath="/html/body/div[1]/aside/nav/ul/li[2]/ul/li[1]/a")
    WebElement managersMenu;
    @FindBy(xpath="/html/body/div[1]/aside/nav/ul/li[2]/ul/li[2]/a")
    WebElement customersMenu;
    @FindBy(xpath="/html/body/div[1]/aside/nav/ul/li[2]/ul/li[4]/a")
    WebElement partnerssMenu;
    @FindBy(xpath="/html/body/div[1]/aside/nav/ul/li[2]/ul/li[4]/a")
    WebElement employeessMenu;


    //Action Method
    public void clickServicesMenu() throws InterruptedException
    {
        TestUtil.jsClickMethod(driver, servicesMenu);
        Thread.sleep(2000);
    }
    //Action Method
    public void clickManagersMenu() throws InterruptedException
    {
        TestUtil.jsClickMethod(driver, managersMenu);
        Thread.sleep(2000);
    }
    //Action Method
    public void clickcustomerssMenu() throws InterruptedException
    {
        TestUtil.jsClickMethod(driver, customersMenu);
        Thread.sleep(2000);
    }
    //Action Method
    public void clickPartnersMenu() throws InterruptedException
    {
        TestUtil.jsClickMethod(driver, partnerssMenu);
        Thread.sleep(2000);
    }
    //Action Method
    public void clickEmployeesMenu() throws InterruptedException
    {
        TestUtil.jsClickMethod(driver, employeessMenu);
        Thread.sleep(2000);
    }
}