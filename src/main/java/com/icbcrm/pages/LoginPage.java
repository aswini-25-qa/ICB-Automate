package com.icbcrm.pages;

import com.icbcrm.base.TestBase;
import com.icbcrm.util.TestUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase
{
    //Constructor to initialize all the WebElements using Selenium’s PageFactory.
    public LoginPage()
    {
        PageFactory.initElements(driver, this);
    }

    //Locate elements
    @FindBy(id="data.email")
    WebElement emailField;

    @FindBy(id = "data.password")
    WebElement passwordField;

    @FindBy(id="data.remember")
    WebElement rememberMeField;

    @FindBy(xpath = "//*[@id=\"form\"]/div[2]/div/button")
    WebElement signInButton;
/*
    @FindBy(xpath="/html/body/div[1]/aside/nav/ul/li[2]/ul/li[1]/a")
    WebElement customersMenu;

    @FindBy(xpath="/html/body/div[1]/aside/nav/ul/li[2]/ul/li[3]/a")
    WebElement partnersMenu;

    @FindBy(xpath="/html/body/div[1]/aside/nav/ul/li[2]/ul/li[4]/a")
    WebElement usersMenu;
*/
    public void login(String email, String pass) throws InterruptedException
    {
        emailField.sendKeys(email);
        passwordField.sendKeys(pass);
        TestUtil.jsClickMethod(driver, signInButton);
        Thread.sleep(2000);
    }
}