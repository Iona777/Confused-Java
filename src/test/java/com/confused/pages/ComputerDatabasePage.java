package com.confused.pages;

import com.confused.HelperClasses.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ComputerDatabasePage extends BasePage
{
    //Field locators
    private final By AddButtonLocator = By.id("add");
    //private final By TableRowsLocator = By.xpath(".//table/*/tr/a");
    private final By ComputerLinksLocator = By.xpath(".//table/*/tr/td/a");

    //Methods
    public void GoToHomePage()
    {
        Driver.MyDriver.navigateTo(BaseURL);
    }

    public void ClickAddButton()
    {
        ClickOnElement(AddButtonLocator);
    }

    public void ClickComputerNameOnNthRow(int row)
    {
        //Get all links
        List<WebElement> linksList = GetLinks(ComputerLinksLocator);

        WebElement requiredLink = linksList.get(row);
        requiredLink.click();
    }
}
