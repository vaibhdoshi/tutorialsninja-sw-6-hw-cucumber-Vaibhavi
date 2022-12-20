package com.tutorialsninja.cucumber.steps;

import com.tutorialsninja.pages.AccountsRegisterPage;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.MyAccountPage;
import com.tutorialsninja.utility.Utility;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class AccountRegisterSteps {
    @When("^I click on my account link$")
    public void iClickOnMyAccountLink() {
        new HomePage().clickOnMyAccountTab();
    }

    @And("^I select from my account options Register$")
    public void iSelectFromMyAccountOptionsRegister() {
        new HomePage().selectMyAccountOptions("Register");

    }

    @Then("^I should navigate to register page successfully$")
    public void iShouldNavigateToRegisterPageSuccessfully() {
        String expectedText = "Register Account";
        String actualText = new AccountsRegisterPage().getRegisterAccountText();
        Assert.assertEquals("Register page not displayed", expectedText, actualText);

    }


    @And("^I enter first name \"([^\"]*)\"$")
    public void iEnterFirstName(String fName) {
        new AccountsRegisterPage().enterFirstName("Raha" + Utility.getRandomString(4));
    }

    @And("^I enter last name \"([^\"]*)\"$")
    public void iEnterLastName(String lName) {
        new AccountsRegisterPage().enterLastName("Doshi"+ Utility.getRandomString(5));
    }


    @And("^I enter email$")
    public void iEnterEmail() {
        new AccountsRegisterPage().enterEmail("raha1234" + Utility .getRandomString(8) + "@gmail.com");
    }

    @And("^I enter telephone number\"([^\"]*)\"$")
    public void iEnterTelephoneNumber(String telephone) {
        new AccountsRegisterPage().enterTelephone(telephone);

    }

    @When("^I enter password \"([^\"]*)\"$")
    public void i_enter_password(String password) {
        new AccountsRegisterPage().enterPassword(password);

    }

    @And("^I enter confirm password \"([^\"]*)\"$")
    public void iEnterConfirmPassword(String cPassword) {
        new AccountsRegisterPage().enterConfirmPassword(cPassword);
    }

    @And("^I select subscribe yes radio button$")
    public void iSelectSubscribeYesRadioButton() {
        new AccountsRegisterPage().selectSubscription("yes");
    }

    @And("^I click on privacy policy checkbox$")
    public void iClickOnPrivacyPolicyCheckbox() {
        new AccountsRegisterPage().clickOnPrivacyPolicyCheckBox();
    }

    @And("^I click on continue button$")
    public void iClickOnContinueButton() {
        new AccountsRegisterPage().clickOnContinueButton();
    }

    @Then("^I should create register account successfully$")
    public void iShouldCreateRegisterAccountSuccessfully() {
        String expectedText = "Your Account Has Been Created!";
        Assert.assertEquals("Account not created", expectedText, new MyAccountPage().getYourAccountHasBeenCreatedText());
    }

    @And("^I click on account continue button$")
    public void iClickOnAccountContinueButton() {
        new MyAccountPage().clickOnContinueButton();
    }

    @And("^I click on my account$")
    public void iClickOnMyAccount() {
        new MyAccountPage().clickOnMyAccount();
    }

    @And("^I click on log out button$")
    public void iClickOnLogOutButton() {
        new MyAccountPage().clickOnLogoutButton();
    }

    @Then("^I should be able to logout successfully$")
    public void iShouldBeAbleToLogoutSuccessfully() {
        String expectedText = "Account Logout";
        Assert.assertEquals("Not logged out", expectedText, new MyAccountPage().getAccountLogoutText());
    }


}

