package com.tutorialsninja.cucumber.steps;

import com.tutorialsninja.pages.DesktopPage;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.ProductPage;
import com.tutorialsninja.pages.ShoppingCartPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;

public class DesktopSteps {

    @When("^I select currency\\(\"([^\"]*)\"\\)$")
    public void iSelectCurrency(String currency) {
        new HomePage().selectCurrency(currency);

    }

    @And("^I hoover mouse and click on DesktopLink$")
    public void iHooverMouseAndClickOnDesktopLink() {
        new HomePage().mouseHoverOnDesktopsLinkAndClick();

    }

    @And("^I select show All Desktops$")
    public void iSelectShowAllDesktops() {
        new HomePage().selectMyAccountOptions("Show All Desktops");
    }

    @And("^I mouse hoover and click on DesktopLink$")
    public void iMouseHooverAndClickOnDesktopLink() {
        new HomePage().mouseHoverOnDesktopsLinkAndClick();
    }


    @Then("^I should see product sorted in Z to A order$")
    public void iShouldSeeProductSortedInZToAOrder() {
        ArrayList<String> originalProductName =
                new DesktopPage().getProductsNameList();
    }

    @And("^I select sortby option name \\(\"([^\"]*)\"\\)$")
    public void iSelectSortbyOptionName(String option) {
        new DesktopPage().selectSortByOption(option);


    }

    @And("^I verfiy products are arranged in Alphabetical order$")
    public void iVerfiyProductsAreArrangedInAlphabeticalOrder() {


    }


    @And("^I select sortby option\\(\"([^\"]*)\"\\)$")
    public void iSelectSortbyOption(String option) {
        new DesktopPage().selectSortByOption(option);

    }

    @And("^I selcet product \\(\"([^\"]*)\"\\)$")
    public void iSelcetProduct(String product) {
        new DesktopPage().selectProductByName(product);

    }

    @And("^I verify product text$")
    public void iVerifyProductText() {
        // new ProductPage().getProductText()
        Assert.assertEquals(new ProductPage().getProductText(), "HP LP3065", "HP LP3065 Product not display");

    }

    @And("^I select delivery date$")
    public void iSelectDeliveryDate() {
        new ProductPage().selectDeliveryDate("30", "11", "2022");

    }

    @And("^I clear quantity in quantity field$")
    public void iClearQuantityInQuantityField() {
        new ProductPage().clearQuantity();
    }

    @And("^I enter quantity \\(\"([^\"]*)\"\\)$")
    public void iEnterQuantity(String quantity) {
        new ProductPage().enterQuantity(quantity);

    }

    @And("^I click add to cart button$")
    public void iClickAddToCartButton() {
        new ProductPage().clickOnAddToCartButton();
    }


    @And("^I click on shopping cart link into message$")
    public void iClickOnShoppingCartLinkIntoMessage() {
        new ProductPage().clickOnShoppingCartLinkIntoMessage();


    }

    @And("^I verify message \"([^\"]*)\"$")
    public void iVerifyMessage(String arg0) {

    }

    @And("^I verify product name \"([^\"]*)\"$")
    public void iVerifyProductName(String arg0) {
        Assert.assertTrue(new ShoppingCartPage().getShoppingCartText().contains("Shopping Cart"));

    }


    @Then("^I verify total is displyed$")
    public void iVerifyTotalIsDisplyed() {
        Assert.assertEquals(new ShoppingCartPage().getTotal(), "£74.73", "Total not matched");


    }

    @And("^I verfiy Success: You have added product to your shopping cart message$")
    public void iVerfiySuccessYouHaveAddedProductToYourShoppingCartMessage() {
        String expectedText = "Success: You have added HP LP3065 to your shopping cart!";
        Assert.assertEquals(new ProductPage().getProductAddedSuccessMessage(), expectedText, "Product not added to cart");

    }

    @And("^I verify product is displyed$")
    public void iVerifyProductIsDisplyed() {
        Assert.assertEquals(new ShoppingCartPage().getProductName(), "HP LP3065", "Product name not matched");
    }

    @Given("^I am on homepage$")
    public void iAmOnHomepage() {
    }



    @And("^I select product$")
    public void iSelectProduct() {
        new DesktopPage().selectProductByName("HP LP3065");
    }
}
