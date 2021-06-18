package com.confused.pages;

import com.confused.HelperClasses.Driver;
import io.cucumber.java.After;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AddAComputerPage extends BasePage
{
    //Field locators
    private final By ComputerNameLocator = By.id("name");
    private final By IntroducedDateLocator = By.id("introduced");
    private final By CompanyLocator = By.id("company");
    private final By CreateButtonLocator = By.cssSelector("[value='Create this computer']");
    private final By SuccessMessageLocator = By.cssSelector("[class='alert-message warning']");



    //Methods
    public void GoToHomePage()
    {
        Driver.MyDriver.navigateTo(BaseURL);
    }

    public void EnterComputerDetails(String computerName, String introducedDate, String company)
    {
        EnterText(ComputerNameLocator, computerName,false);
        EnterText(IntroducedDateLocator, introducedDate, false);

        WebElement dropdown = GetClickableElementByLocator(CompanyLocator);
        SelectDropdownByValue(dropdown,company);
    }

    public void ClickCreateButton()
    {
        ClickOnElement(CreateButtonLocator);
    }

    public boolean IsSuccessMessageDisplayed(String computerName)
    {
        WebElement message = GetVisibleElementByLocator(SuccessMessageLocator);
        String actualMessageText = message.getText();
        String expectedMessageText =  "Done! Computer "+computerName+" has been created";

        return actualMessageText.equals(expectedMessageText);

    }

}
