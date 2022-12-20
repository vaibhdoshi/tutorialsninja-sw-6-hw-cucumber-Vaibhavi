package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage extends Utility {
    private static final Logger log = LogManager.getLogger(MyAccountPage.class.toString());

    public MyAccountPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//div[@class='col-sm-9']/h1")
    WebElement accountLogoutText;
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Your Account Has Been Created!')]")
    WebElement accountCreatedText;
    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Continue']")
    WebElement continueBtn;
    @CacheLookup
    @FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='My Account']")
    WebElement myAccount;
    @CacheLookup
    @FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
    WebElement logout;


    public String getAccountLogoutText() {
        log.info("get account logout text " + accountLogoutText.toString());
        return getTextFromElement(accountLogoutText);
    }

    public String getYourAccountHasBeenCreatedText() {
        log.info("get your account has been created text " + accountCreatedText.toString());
        return getTextFromElement(accountCreatedText);
    }

    public void clickOnMyAccount() {
        log.info("Clicking on my account" + myAccount.toString());
        clickOnElement(myAccount);
    }

    public void clickOnContinueButton() {
        log.info("Clicking on continue Button " + continueBtn.toString());
        clickOnElement(continueBtn);
    }

    public void clickOnLogoutButton() {
        log.info("click on logout button " + logout.toString());
        clickOnElement(logout);
    }


}
