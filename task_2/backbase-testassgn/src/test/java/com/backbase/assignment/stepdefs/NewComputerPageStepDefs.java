package com.backbase.assignment.stepdefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import static com.backbase.assignment.stepdefs.Hooks.driver;
import static com.backbase.assignment.stepdefs.Hooks.waitForPageLoaded;

public class NewComputerPageStepDefs {

    @When("^I click to add a new computer$")
    public void iClickToAddANewComputer() {
        waitForPageLoaded();
        driver.findElement(By.id("add")).click();
    }

    @When("^I enter valid computer information$")
    public void iEnterValidComputerInformation() {
        waitForPageLoaded();
        driver.findElement(By.id("name")).sendKeys("MyComputer");
        driver.findElement(By.id("introduced")).sendKeys("1990-10-10");
        driver.findElement(By.id("discontinued")).sendKeys("1991-10-10");
        new Select(driver.findElement(By.id("company"))).selectByVisibleText("Thinking Machines");
    }

    @When("^I click create this computer$")
    public void iClickCreateThisComputer() {
        driver.findElement(By.xpath("//input[@value='Create this computer']")).click();
    }

    @Then("^the computer is registered$")
    public void theComputerIsRegistered() {
        waitForPageLoaded();
        Assert.assertTrue("Successfully registered",
                driver.findElement(By.tagName("body")).getText().contains("Done! Computer"));
    }

    @And("^I enter valid computer name$")
    public void iEnterValidComputerName() {
        waitForPageLoaded();
        driver.findElement(By.id("name")).sendKeys("MyComputer");
    }

    @And("^'(.*)' and '(.*)' as introduced and discontinued dates$")
    public void introducedAndDiscontinuedAsIntroducedAndDiscontinuedDates(String introduced, String discontinued) {
        driver.findElement(By.id("introduced")).sendKeys(introduced);
        driver.findElement(By.id("discontinued")).sendKeys(discontinued);
    }

    @Then("^I got error for date fields$")
    public void iGotErrorForDateFields() throws Throwable {
        waitForPageLoaded();
        Assert.assertTrue(driver.findElement(By.cssSelector("div.clearfix:nth-child(2)")).isDisplayed());
    }

    @And("^there is a computer with name '(.*)'$")
    public void thereIsAComputerWithNameMyComputerToBeDeleted(String computerName) {
        iClickToAddANewComputer();
        waitForPageLoaded();
        driver.findElement(By.id("name")).sendKeys(computerName);
        new Select(driver.findElement(By.id("company"))).selectByVisibleText("Apple Inc.");
        iClickCreateThisComputer();
        theComputerIsRegistered();
    }
}
