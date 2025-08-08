package com.icbcrm.pages;

import com.icbcrm.base.TestBase;
import com.icbcrm.util.TestUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase
{
    public LoginPage()
    {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="data.email")
    WebElement emailField;

    @FindBy(id = "data.password")
    WebElement passwordField;

    @FindBy(id="data.remember")
    WebElement rememberMeField;

    @FindBy(xpath = "//*[@id=\"form\"]/div[2]/div/button")
    WebElement signInButton;

    public void loginTest(String email, String pass) throws InterruptedException
    {
        emailField.sendKeys(email);
        passwordField.sendKeys(pass);
        TestUtil.signInClick(driver, signInButton);
        Thread.sleep(2000);
    }
}