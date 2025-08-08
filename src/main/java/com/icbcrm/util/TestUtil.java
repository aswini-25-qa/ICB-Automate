package com.icbcrm.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class TestUtil
{
    public static final long PAGE_LOAD_WAIT = 30;
    public static final long IMPLICIT_WAIT = 30;

    public static void signInClick(WebDriver driver, WebElement element)
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }
}