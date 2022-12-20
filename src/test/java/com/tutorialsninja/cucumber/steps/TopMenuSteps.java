package com.tutorialsninja.cucumber.steps;

import com.tutorialsninja.pages.ComponentsPage;
import com.tutorialsninja.pages.DesktopPage;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.LaptopAndNotebooksPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class TopMenuSteps {
    @Given("^I am on home page$")
    public void iAmOnHomePage() {
    }

    @When("^I mouse hover on Desktop tab and click$")
    public void iMouseHoverOnDesktopTabAndClick() {

        new HomePage().mouseHoverOnDesktopsLinkAndClick();
    }

    @And("^I click on Show All Desktops$")
    public void iClickOnShowAllDesktops() {
        new HomePage().selectMenu("Show All Desktops");
    }

    @Then("^I should navigate to desktop page successfully$")
    public void iShouldNavigateToDesktopPageSuccessfully() {
        String expectedText = "Desktops";
        String actualText = new DesktopPage().getDesktopsText();
        Assert.assertEquals("Not navigate to Desktop page", expectedText, actualText);
    }


    @When("^I mouse hover on Laptops and notebooks tab and click$")
    public void iMouseHoverOnLaptopsAndNotebooksTabAndClick() {
        new HomePage().mouseHoverOnLaptopsAndNotebooksLinkAndClick();
    }

    @And("^I click on Show all Laptops and Notebooks$")
    public void iClickOnShowAllLaptopsAndNotebooks() {
        new HomePage().selectMenu("Show All Laptops & Notebooks");
    }

    @Then("^I should navigate to Laptops & Notebooks page successfully$")
    public void iShouldNavigateToLaptopsNotebooksPageSuccessfully() {
        String expectedText = "Laptops & Notebooks";
        Assert.assertEquals("Not navigate to Laptops and Notebooks page", expectedText, new LaptopAndNotebooksPage().getLaptopsAndNotebooksText());
    }

    @When("^I mouse hover on Components tab and click$")
    public void iMouseHoverOnComponentsTabAndClick() {
        new HomePage().mouseHoverOnComponentLinkAndClick();
    }

    @And("^I click on Show All Components$")
    public void iClickOnShowAllComponents() {
        new HomePage().selectMenu("Show All Components");

    }

    @Then("^I should navigate to Components page successfully$")
    public void iShouldNavigateToComponentsPageSuccessfully() {
        String expectedText = "Components";
        Assert.assertEquals("Not navigate to Laptops and Notebooks page", expectedText, new ComponentsPage());
    }


}
