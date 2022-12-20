package com.tutorialsninja.cucumber.steps;

import com.tutorialsninja.pages.AccountLoginPage;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.MyAccountPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.junit.Assert;

public class AccountLoginSteps {

    @And("^I select from my account options Login link$")
    public void iSelectFromMyAccountOptionsLoginLink() {
        new HomePage().selectMyAccountOptions("Login");
    }

    @Then("^I should navigate to login page successfully$")
    public void iShouldNavigateToLoginPageSuccessfully() {
        String expectedText = "Returning Customer";
        Assert.assertEquals("Login page not displayed", expectedText, new AccountLoginPage().getReturningCustomerText());

    }

    @And("^i enter email address$")
    public void iEnterEmailAddress() {
        new AccountLoginPage().enterEmailAddress("viaan123@gmail.com");
    }

    @And("^I enter password$")
    public void iEnterPassword() {
        new AccountLoginPage().enterPassword("viaan123");
    }

    @And("^I click on Login Button$")
    public void iClickOnLoginButton() {
        new AccountLoginPage().clickOnLoginButton();
    }

    @And("^I click on my account tab$")
    public void iClickOnMyAccountTab() {
        new MyAccountPage().clickOnMyAccount();

    }

    @And("^I click on log out tab$")
    public void iClickOnLogOutTab() {
        new MyAccountPage().clickOnLogoutButton();
    }

    @And("^verify logout text$")
    public void verifyLogoutText() {
        String expectedText = "Account Logout";
        Assert.assertEquals("Not logged out", expectedText, new MyAccountPage().getAccountLogoutText());


    }


}

