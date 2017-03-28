package com.backbase.assignment.stepdefs;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import static com.backbase.assignment.stepdefs.Hooks.driver;
import static com.backbase.assignment.stepdefs.Hooks.waitForPageLoaded;

public class UpdateComputerStepDefs {

    @Given("^I search computer with name `MyComputerToBeUpdated`$")
    public void iSearchComputerWithNameMyComputer()  {
        waitForPageLoaded();
        driver.findElement(By.id("searchbox")).click();
        driver.findElement(By.id("searchbox")).sendKeys("MyComputerToBeUpdated");
        driver.findElement(By.id("searchsubmit")).click();
    }

    @When("^I update existing information$")
    public void iUpdateExistingInformation() {
        waitForPageLoaded();
        driver.findElement(By.linkText("MyComputerToBeUpdated")).click();
        waitForPageLoaded();
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys("MyComputerChanged");
        driver.findElement(By.xpath("//input[@value='Save this computer']")).click();
    }

    @Then("^computer information is updated$")
    public void computerInformationIsUpdated() {
        waitForPageLoaded();
        Assert.assertTrue("Successfully updated",
                driver.findElement(By.tagName("body")).getText().contains("has been updated"));
    }
}
