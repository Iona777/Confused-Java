package com.confused.stepDefs;

import com.confused.HelperClasses.ConfigHelper;
import com.confused.HelperClasses.Driver;
import com.confused.pages.ComputerDatabasePage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;

public class CompDbSteps
{
    //Class leverl variables
    private ComputerDatabasePage _theComputerDatabasePage;

    //Constructor
    public CompDbSteps()
    {
        _theComputerDatabasePage = new ComputerDatabasePage();
    }

    @Before
    public static void StartBrowser()
    {
        ConfigHelper config = new ConfigHelper();
        Driver.MyDriver.getDriver(config.getProperty("browser"));
    }

    @Given("I have navigated to the Computer Database page")
    public void i_have_navigated_to_the_computer_database_page() {
        System.out.println("started");
        _theComputerDatabasePage.GoToHomePage();
    }

}
