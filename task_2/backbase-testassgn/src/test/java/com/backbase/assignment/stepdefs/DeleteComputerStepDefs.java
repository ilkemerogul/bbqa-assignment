package com.backbase.assignment.stepdefs;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import static com.backbase.assignment.stepdefs.Hooks.driver;
import static com.backbase.assignment.stepdefs.Hooks.waitForPageLoaded;

public class DeleteComputerStepDefs {

    @Given("^I search computer with name `MyComputerToBeDeleted`$")
    public void iSearchComputerWithNameMyComputerToBeDeleted() {
        waitForPageLoaded();
        driver.findElement(By.id("searchbox")).click();
        driver.findElement(By.id("searchbox")).sendKeys("MyComputerToBeDeleted");
        driver.findElement(By.id("searchsubmit")).click();
    }

    @When("^I delete an existing computer$")
    public void iDeleteAnExistingComputer()  {
        waitForPageLoaded();
        driver.findElement(By.linkText("MyComputerToBeDeleted")).click();
        waitForPageLoaded();
        driver.findElement(By.xpath("//input[@value='Delete this computer']")).click();
    }

    @Then("^computer is removed from the list$")
    public void computerIsRemovedFromTheList()  {
        waitForPageLoaded();
        Assert.assertTrue("Successfully deleted",
                driver.findElement(By.tagName("body")).getText().contains("has been deleted"));
    }
}