package com.backbase.assignment.stepdefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import static com.backbase.assignment.stepdefs.Hooks.driver;
import static com.backbase.assignment.stepdefs.Hooks.waitForPageLoaded;

public class MainPageNextStepDefs {

    @Given("^I open computer database website$")
    public void iOpenComputerDatabaseWebsite() {
        waitForPageLoaded();
        driver.get("http://computer-database.herokuapp.com/computers");
    }

    @When("^I click on the next button at the bottom of the page$")
    public void iClickOnTheNextButtonAtTheBottomOfThePage() {
        waitForPageLoaded();
        driver.findElement(By.linkText("Next →")).click();
    }

    @Then("^next page should be displayed$")
    public void nextPageShouldBeDisplayed() {
        waitForPageLoaded();
        Assert.assertTrue("Previous button should be enabled, so that i can verify that next button worked",
                driver.findElement(By.linkText("← Previous")).isEnabled());
    }

}
