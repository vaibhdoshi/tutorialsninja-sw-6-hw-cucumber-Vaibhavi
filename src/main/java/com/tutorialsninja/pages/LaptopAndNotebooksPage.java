package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import java.util.ArrayList;
import java.util.List;

public class LaptopAndNotebooksPage extends Utility {
    private static final Logger log = LogManager.getLogger(LaptopAndNotebooksPage.class.getName());

    public LaptopAndNotebooksPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Laptops & Notebooks')]")
    WebElement laptopsAndNotebooksText;
    @CacheLookup
    @FindBy(xpath = "//p[@class ='price']")
    List<WebElement> productsPrices;
    @CacheLookup
    @FindBy(xpath = "//select[@id='input-sort']")
    List<WebElement> productsList;
    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement sortBy;
    @CacheLookup
    @FindBy(linkText = "MacBook")
    WebElement productMacBook;

    public String getLaptopsAndNotebooksText() {
        log.info("getlaptops and notebooks text" + laptopsAndNotebooksText.toString());
        return getTextFromElement(laptopsAndNotebooksText);
    }

    public ArrayList<Double> getProductsPriceList() {
        List<WebElement> products = getListOfElements(productsPrices);
        ArrayList<Double> originalProductsPrice = new ArrayList<>();
        for (WebElement e : products) {
            String[] arr = e.getText().split("Ex Tax:");
            originalProductsPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        return originalProductsPrice;
    }

    private List<WebElement> getListOfElements(List<WebElement> productsPrices) {
        return productsPrices;
    }

    public void selectSortByOption(String option) {
        Reporter.log("select sort by option" + sortBy.toString());
        selectByVisibleTextFromDropDown(sortBy, option);
    }

    public void selectProductByName(String product) {
        clickOnElement(productsList);
        List<WebElement> products = getListOfElements(productsList);
        for (WebElement e : products) {
            if (e.getText().equals(product)) {
                e.click();
                break;
            }
        }
    }

    private void clickOnElement(List<WebElement> productsList) {
    }

    public void clickOnSortByPosition() {
        clickOnElement(sortBy);
        log.info("Clicking on Login Button " + sortBy.toString());
    }
    public void clickOnProductMacBook(String productName) {
        clickOnElement(productMacBook);
        log.info("Select "+productName+  productMacBook.toString());
    }

}
