package com.confused.pages;

import com.confused.HelperClasses.Driver;

public class ComputerDatabasePage extends BasePage
{
    public void GoToHomePage()
    {
        Driver.MyDriver.navigateTo(BaseURL);
    }
}
