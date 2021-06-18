package com.confused.pages;

import com.confused.HelperClasses.ConfigHelper;
import com.confused.HelperClasses.Driver;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class BasePage
{
    //By setting these here, Base Page does not need to go to Driver class  each time
    protected int BaseTimout;
    protected String BaseURL;
    protected WebDriver BaseDriver = Driver.MyDriver.driver;
    protected String ScreenShotsDir;

    public BasePage()
    {
        ConfigHelper config = new ConfigHelper();
        BaseURL = config.getProperty("baseUrl");
        BaseTimout = Integer.parseInt(config.getProperty("defaultTimeout")) ;
        ScreenShotsDir = config.getProperty("screenshotsDir");
    }

    public WebElement GetElementByVisibleText(String searchText)
    {
        WebDriverWait wait = new WebDriverWait(BaseDriver, BaseTimout);

        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[contains(text(),'" + searchText + "')]")));
    }

    public boolean IsElementDisplayedByLocator(By locator)
    {
        try
        {
            return GetClickableElementByLocator(locator).isDisplayed();
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public WebElement GetClickableElementByLocator(By elementLocator)
    {

        WebDriverWait wait = new WebDriverWait(BaseDriver, BaseTimout);

        return wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
    }

    public WebElement GetVisibleElementByLocator(By elementLocator)
    {

        WebDriverWait wait = new WebDriverWait(BaseDriver, BaseTimout);

        return wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
    }

    public void ClickOnElement(By elementLocator)
    {
        WebElement ele =
                GetClickableElementByLocator(elementLocator);
        ele.click();
    }

    public void EnterText(By elementLocator, String value, Boolean clear)
    {
        WebElement element = GetClickableElementByLocator(elementLocator);
        if (clear.equals(true))
            element.clear();

        element.sendKeys(value);
    }

    public void SelectDropdownByValue(WebElement dropdownlist, String value)
    {
        Select selector = new Select(dropdownlist);
        selector.selectByValue(value);

    }

    protected List<WebElement> GetLinks(By by)
    {
        return Driver.MyDriver.driver.findElements(by);
    }
}
