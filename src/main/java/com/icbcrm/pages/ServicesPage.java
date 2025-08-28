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

    @FindBy(xpath="/html/body/div[1]/aside/nav/ul/li[2]/ul/li[2]/a")
    WebElement servicesMenu;

    //Action Method
    public void clickServicesMenu() throws InterruptedException
    {
        TestUtil.jsClickMethod(driver, servicesMenu);
        Thread.sleep(2000);
    }
}