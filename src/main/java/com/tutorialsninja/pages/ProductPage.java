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

import java.util.List;

public class ProductPage extends Utility {
    private static final Logger log = LogManager.getLogger(ProductPage.class.toString());
    public ProductPage() {PageFactory.initElements(driver, this);}
    @CacheLookup
    @FindBy(xpath = "//div[@id = 'content']//h1")
    WebElement productText;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'input-group date']//button")
    WebElement calendarButton;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'datepicker']/div[1]//th[@class='picker-switch']")
    WebElement monthAndYearText;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'datepicker']/div[1]//th[@class='next']")
    WebElement nextButton;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'datepicker']/div[1]//tbody/tr/td[@class = 'day']")
    List<WebElement> dateList;
    @CacheLookup
    @FindBy(xpath = "/html/body/div[2]/div/div/div/div[2]/div[2]/div[2]/input[1]")
    WebElement qty;
    @CacheLookup
    @FindBy(css = "#input-quantity")
    WebElement qtyField;
    @CacheLookup
    @FindBy(xpath = "//button[@id='button-cart']")
    WebElement addToCartButton;
    @CacheLookup
    @FindBy(css = "body:nth-child(2) div.container:nth-child(4) > div.alert.alert-success.alert-dismissible")
    WebElement successMessage;
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'shopping cart')]")
    WebElement shoppingCartLink;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'input-group date']//button")
    WebElement datePicker;


    public String getProductText() {
        log.info("get product text" + productText.toString());
        return getTextFromElement(productText);
    }

    public void selectDeliveryDate(String day, String month, String year) {
        clickOnElement(datePicker);
        while (true) {
            String monthAndYear = getTextFromElement(By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='picker-switch']"));
            String[] arr = monthAndYear.split(" ");
            String mon = arr[0];
            String yer = arr[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(nextButton);
            }
        }
        List<WebElement> allDates = getListOfElements(dateList);
        for (WebElement e : allDates) {
            if (e.getText().equalsIgnoreCase(day)) {
                e.click();
                break;
            }
        }
    }

    private List<WebElement> getListOfElements(List<WebElement> dateList) {
        return null;
    }

    public void clickOnAddToCartButton() {
        log.info("click on add to cart button" + addToCartButton.toString());
        clickOnElement(addToCartButton);
    }

    public String getProductAddedSuccessMessage() {
        log.info("get product added success message" + successMessage.toString());
        return getTextFromElement(successMessage);
    }

    public void clickOnShoppingCartLinkIntoMessage() {
        log.info("click on shopping cart link into message" + shoppingCartLink.toString());
        clickOnElement(shoppingCartLink);
    }

    public void clearQuantity() {
        WebElement qty= driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/div[2]/input[1]"));
        qty.sendKeys(Keys.CONTROL + "a");
        qty.sendKeys(Keys.DELETE);
    }

    public void enterQuantity(String qty) {
        log.info("enter qty" + qtyField.toString());
        clearTextOnElement(qtyField);
        sendTextToElement(qtyField, qty);
    }

    private void clearTextOnElement(WebElement qtyField) {
    }


}
