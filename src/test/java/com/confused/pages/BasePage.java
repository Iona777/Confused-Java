package com.confused.pages;

import com.confused.HelperClasses.ConfigHelper;
import com.confused.HelperClasses.Driver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
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
