package com.confused.stepDefs;

import com.confused.HelperClasses.ConfigHelper;
import com.confused.HelperClasses.Driver;
import com.confused.pages.AddAComputerPage;
import com.confused.pages.ComputerDatabasePage;
import com.confused.pages.EditComputerPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import static com.confused.HelperClasses.Driver.MyDriver.driver;

public class CompDbSteps
{
    //Class level variables
    private ComputerDatabasePage _theComputerDatabasePage;
    private AddAComputerPage _theAddComputerPage;
    private EditComputerPage _theEditCompterPage;

    //Constructor
    public CompDbSteps()
    {
        _theComputerDatabasePage = new ComputerDatabasePage();
        _theAddComputerPage = new AddAComputerPage();
        _theEditCompterPage = new EditComputerPage();
    }

    @Before
    public static void StartBrowser()
    {
        ConfigHelper config = new ConfigHelper();
        Driver.MyDriver.getDriver(config.getProperty("browser"));
    }

    @Given("I have navigated to the Computer Database page")
    public void i_have_navigated_to_the_computer_database_page()
    {
        _theComputerDatabasePage.GoToHomePage();
    }

    @When("I click on the Add a new computer button")
    public void i_click_on_the_add_a_new_computer_button() {
        _theComputerDatabasePage.ClickAddButton();
    }

    @When("I enter new computer details {string}, {string}, {string}")
    public void i_enter_new_computer_details(String computerName, String introducedDate, String company)
    {
        _theAddComputerPage.EnterComputerDetails(computerName, introducedDate, company);
        _theAddComputerPage.ClickCreateButton();
    }

    @Then("Then I get a success message for {string}")
    public void then_i_get_a_success_message_for(String computerName)
    {
        Assert.assertTrue("Success message not displayed",_theAddComputerPage.IsSuccessMessageDisplayed(computerName));
    }

    @When("I select row {int}")
    public void i_select_row(Integer enteredRow)
    {
        //Rows are zero referenced
        int row = enteredRow-1;

        _theComputerDatabasePage.ClickComputerNameOnNthRow(row);
    }

    @Then("the Edit computer screen is displayed")
    public void the_edit_computer_screen_is_displayed()
    {
        Assert.assertTrue("Correct title for edit computer screen not displayed",_theEditCompterPage.CorrectTitleDisplayed());
    }

    @When("I click on Delete this computer button")
    public void i_click_on_delete_this_computer_button()
    {
        _theEditCompterPage.ClickOnDeleteButton();
    }

    @Then("Then I get a deletion successful message")
    public void then_i_get_a_deletion_successful_message()
    {
        Assert.assertTrue("The correct deletion successful message is not displayed",
                _theEditCompterPage.IsDeleteSuccessfulMessageDisplayed());
    }

    @When("I filter by {string}")
    public void i_filter_by(String filter)
    {
        _theComputerDatabasePage.FilterByComputerName(filter);
    }

    @Then("list is filtered by name {string}")
    public void list_is_filtered_by_name(String filter)
    {
        Assert.assertTrue("Filter list is not correct",_theComputerDatabasePage.IsFilterCorrect(filter));
    }


    @After
    public static void StopBrowser()
    {
        driver.quit();
        System.out.println("Browser stopped");
    }

}
