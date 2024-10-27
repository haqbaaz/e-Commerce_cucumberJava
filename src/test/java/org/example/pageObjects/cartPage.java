package org.example.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class cartPage {
    WebDriver ldriver;

    public cartPage(WebDriver rdriver){
        ldriver = rdriver;
        PageFactory.initElements(rdriver,this);
    }

    @FindBy(xpath = "//div[@class='inventory_list']//div[1]//div[3]//button[1]")
    WebElement sauceLabBagAddToCartBtn;

    @FindBy(xpath = "//body//div[@id='page_wrapper']//div[@id='inventory_container']//div[@id='inventory_container']//div[2]//div[3]//button[1]")
    WebElement sauceLabBikeLightBtn;

    @FindBy(xpath = "//*[name()='path' and contains(@fill,'currentCol')]")
    WebElement cartBtn;

    @FindBy(xpath = "//a[contains(text(),'CHECKOUT')]")
    WebElement checkoutBtn;

    @FindBy(xpath = "//input[@id='first-name']")
    WebElement txtFirstName;

    @FindBy(xpath = "//input[@id='last-name']")
    WebElement txtLastName;

    @FindBy(xpath = "//input[@id='postal-code']")
    WebElement txtZipcode;

    @FindBy(xpath = "//input[@value='CONTINUE']")
    WebElement continueBtn;

    @FindBy(xpath = "//a[contains(text(),'FINISH')]")
    WebElement finishBtn;

    @FindBy(xpath = "//h2[contains(text(),'THANK YOU FOR YOUR ORDER')]")
    WebElement thankYouMsg;

    public void addItemsToCart(){
        sauceLabBagAddToCartBtn.click();
        sauceLabBikeLightBtn.click();
    }
    public void clickAddToCartBtn(){
        cartBtn.click();
        checkoutBtn.click();
    }
    public void addDetails(String firstname,String lastname, String zip){

        txtFirstName.sendKeys(firstname);
        txtLastName.sendKeys(lastname);
        txtZipcode.sendKeys(zip);
    }
    public void checkoutAndFinish(){
        continueBtn.click();
        finishBtn.click();
    }
    public String  verifyMsg(){

        String txtMsg = thankYouMsg.getText();
        return txtMsg;
    }

}
