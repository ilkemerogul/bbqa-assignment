package com.backbase.assignment.stepdefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import static com.backbase.assignment.stepdefs.Hooks.driver;
import static com.backbase.assignment.stepdefs.Hooks.waitForPageLoaded;

public class MainPagePreviousStepDefs {

    @Given("^I locate previous button at the bottom of the page$")
    public void iLocatePreviousButtonAtTheBottomOfThePage()  {
        waitForPageLoaded();
        driver.findElement(By.linkText("← Previous"));
    }

    @When("^I click on the previous button$")
    public void iClickOnThePreviousButton() {
        waitForPageLoaded();
        driver.findElement(By.linkText("← Previous")).click();
    }

    @Then("^previous page should be displayed$")
    public void previousPageShouldBeDisplayed() {
        waitForPageLoaded();
        Assert.assertTrue("Counter starts from 1, so that I can verify that previous button worked",
                driver.findElement(By.tagName("body")).getText().contains("Displaying 1 to"));

    }
}
