package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage extends Utility {
    private static final Logger log = LogManager.getLogger(ShoppingCartPage.class.toString());

    public ShoppingCartPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//div[@id = 'content']//h1")
    WebElement shoppingCartText;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a")
    WebElement productName;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[2]/small[1]")
    WebElement deliveryDate;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[3]")
    WebElement model;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[6]")
    WebElement total;
    @CacheLookup
    @FindBy(xpath = "//input[contains(@name, 'quantity')]")
    WebElement qtyField;
    @CacheLookup
    @FindBy(xpath = "//button[contains(@data-original-title, 'Update')]")
    WebElement qtyUpdateBtn;
    @CacheLookup
    @FindBy(xpath = "//div[@id='checkout-cart']/div[1]")
    WebElement successModifiedMessage;

    public String getShoppingCartText() {
        log.info("get shopping cart text" + shoppingCartText.toString());
        return getTextFromElement(shoppingCartText);
    }

    public String getProductName() {
        log.info("get product name" + productName.toString());
        return getTextFromElement(productName);
    }

    public String getDeliveryDate() {
        log.info("get delivery date" + deliveryDate.toString());
        return getTextFromElement(deliveryDate);
    }

    public String getModel() {
        log.info("get model" + model.toString());
        return getTextFromElement(model);
    }

    public String getTotal() {
        log.info("get total" + total.toString());
        return getTextFromElement(total);
    }

    public void clearQty() {
        WebElement qty = driver.findElement(By.cssSelector("input[value='1']"));
        qty.sendKeys(Keys.CONTROL + "a");
        qty.sendKeys(Keys.DELETE);

    }

    public void changeQuantity(String qty) {
        log.info("Enter email " + qty + " to email field " + qtyField.toString());
        clearTextOnElement(qtyField);
        sendTextToElement(qtyField, qty);
    }

    private void clearTextOnElement(WebElement qtyField) {
    }

    public void clickOnQtyUpdateButton() {
        log.info("click on qty update button" + qtyUpdateBtn.toString());
        clickOnElement(qtyUpdateBtn);
    }

    public String getSuccessModifiedMessage() {
        log.info("get success modifies message" + successModifiedMessage.toString());
        return getTextFromElement(successModifiedMessage);
    }


}
