package com.confused.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class EditComputerPage extends BasePage
{
    //Field Locators
    private By pageSubheaderLocator = By.xpath(".//*/section/h1");
    private By deleteButtonLocator = By.cssSelector("[type='submit'][value='Delete this computer']");
    private final By DeleteSuccessfulMessageLocator = By.cssSelector("[class='alert-message warning']");

    //Methods
    public boolean CorrectTitleDisplayed()
    {
        String actualHeader = GetVisibleElementByLocator(pageSubheaderLocator).getText();
        String expectedHeader = "Edit computer";

        return actualHeader.equals(expectedHeader);
    }

    public void ClickOnDeleteButton()
    {
        ClickOnElement(deleteButtonLocator);
    }

    public boolean IsDeleteSuccessfulMessageDisplayed()
    {
        WebElement message = GetVisibleElementByLocator(DeleteSuccessfulMessageLocator);
        String actualMessageText = message.getText();
        String expectedMessageText =  "Done! Computer has been deleted";

        return actualMessageText.equals(expectedMessageText);

    }
}
