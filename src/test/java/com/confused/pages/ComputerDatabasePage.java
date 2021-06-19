package com.confused.pages;

import com.confused.HelperClasses.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class ComputerDatabasePage extends BasePage
{
    //Field locators
    private final By AddButtonLocator = By.id("add");
    private final By ComputerLinksLocator = By.xpath(".//table/*/tr/td/a");
    private final By FilterFieldLocator = By.id("searchbox");
    private final By FilterButtonLocator = By.id("searchsubmit");

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
        List<WebElement> linksList = GetLinks(ComputerLinksLocator);

        WebElement requiredLink = linksList.get(row);
        requiredLink.click();
    }

    public void FilterByComputerName(String filter)
    {
        EnterText(FilterFieldLocator, filter, false);
        ClickOnElement(FilterButtonLocator);
    }

    public boolean IsFilterCorrect(String filter)
    {
        List<WebElement> linksList = GetLinks(ComputerLinksLocator);
        WebElement requiredLink = linksList.get(0);
        String expectedName = filter;
        String actualName = requiredLink.getText();

        return expectedName.equals(actualName);
    }
}
