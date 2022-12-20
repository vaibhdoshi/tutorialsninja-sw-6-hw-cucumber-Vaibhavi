package com.tutorialsninja.cucumber.steps;

import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.LaptopAndNotebooksPage;
import com.tutorialsninja.pages.ProductPage;
import com.tutorialsninja.pages.ShoppingCartPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LaptopSteps {
    @When("^I select currency \\(\"([^\"]*)\"\\)$")
    public void iSelectCurrency(String currency) {
        new HomePage().selectCurrency(currency);
    }

    @Then("^I select Product sortby option\\(\"([^\"]*)\"\\) and I can see products are sorted high to low$")
    public void iSelectProductSortbyOptionAndICanSeeProductsAreSortedHighToLow(String option) {
        new LaptopAndNotebooksPage().selectSortByOption(option);
        List<Double> originalProductsPrice = new LaptopAndNotebooksPage().getProductsPriceList();
        Collections.sort(originalProductsPrice, Collections.reverseOrder());
        ArrayList<Double> afterSortByPrice = new LaptopAndNotebooksPage().getProductsPriceList();
        Assert.assertEquals("Product not sorted by price High to low", originalProductsPrice, afterSortByPrice);
    }

    @And("^Select sortby option\\(\"([^\"]*)\"\\)$")
    public void selectSortbyOption(String option) {
        new LaptopAndNotebooksPage().clickOnSortByPosition();
        new LaptopAndNotebooksPage().selectSortByOption(option);
    }

    @And("^select product\\(\"([^\"]*)\"\\)$")
    public void selectProduct(String product) {
        new LaptopAndNotebooksPage().clickOnProductMacBook(product);
        new LaptopAndNotebooksPage().selectProductByName(product);
    }

    @And("^I verify MacBook text is displyed$")
    public void iVerifyMacBookTextIsDisplyed() {
       String expectedText="MacBook";
       Assert.assertEquals("MacBook Product not display",expectedText,new ProductPage().getProductText());
    }

    @And("^I click on add to cart button$")
    public void iClickOnAddToCartButton() {
        new ProductPage().clickOnAddToCartButton();
    }

    @And("^Verify product added to cart message$")
    public void verifyProductAddedToCartMessage() {
        String expectedText = "Success: You have added MacBook to your shopping cart!";
        Assert.assertEquals("Product not added to cart", expectedText, new ProductPage().getProductAddedSuccessMessage());

    }

    @And("^I click on shopping cart link to message$")
    public void iClickOnShoppingCartLinkToMessage() {
        new ProductPage().clickOnShoppingCartLinkIntoMessage();
    }

    @And("^I verify shopping cart text is displayed$")
    public void iVerifyShoppingCartTextIsDisplayed() {
        String expectedText = "Shopping Cart";
        Assert.assertEquals("Product name not matched", expectedText, new ShoppingCartPage().getShoppingCartText());
    }

    @And("^I verify product name MacBook is displayed$")
    public void iVerifyProductNameMacBookIsDisplayed() {
        String expectedText="MacBook";
        Assert.assertEquals("Product name not matched",expectedText,new ShoppingCartPage().getProductName());

    }

    @And("^I cleared quantity field$")
    public void iClearedQuantityField() {
        new ShoppingCartPage().clearQty();
    }

    @And("^I changed quantity two in quantity field\\(\"([^\"]*)\"\\)$")
    public void iChangedQuantityTwoInQuantityField(String qty) {
        new ShoppingCartPage().changeQuantity(qty);
    }

    @And("^I click on quantity update button$")
    public void iClickOnQuantityUpdateButton() {
        new ShoppingCartPage().clickOnQtyUpdateButton();
    }

    @And("^I verify shopping cart update message is displayed$")
    public void iVerifyShoppingCartUpdateMessageIsDisplayed() {
        String expectedText="Success: You have modified your shopping cart!";
        Assert.assertEquals("not added",expectedText,new ShoppingCartPage().getSuccessModifiedMessage());
    }

    @Then("^I verify total is matched$")
    public void iVerifyTotalIsMatched() {
        String expectedText="£737.45";
        Assert.assertEquals("Total not matched",expectedText,new ShoppingCartPage().getTotal());
    }


}
