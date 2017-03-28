package com.backbase.assignment.stepdefs;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import static com.backbase.assignment.stepdefs.Hooks.driver;
import static com.backbase.assignment.stepdefs.Hooks.waitForPageLoaded;

public class CantFindComputerStepDefs {

    @Given("^I search non-existent computer$")
    public void iSearchNonExistentComputer()  {
        waitForPageLoaded();
        driver.findElement(By.id("searchbox")).click();
        driver.findElement(By.id("searchbox")).sendKeys("&!Computer7825//98?");
        driver.findElement(By.id("searchsubmit")).click();
    }

    @When("^there is not any search results$")
    public void thereIsNotAnySearchResults() {
        waitForPageLoaded();
    }

    @Then("^information message is displayed$")
    public void informationMessageIsDisplayed() {
        waitForPageLoaded();
        Assert.assertTrue("Couldn't display any results",
                driver.findElement(By.tagName("body")).getText().contains("No computers found"));
    }
}
