package org.example.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
    WebDriver ldriver;

    public loginPage(WebDriver rdriver){
        ldriver = rdriver;
        PageFactory.initElements(rdriver,this);
    }

    @FindBy(xpath = "//input[@id='user-name']")
    WebElement username;

    @FindBy(xpath = "//input[@id='password']")
    WebElement password;

    @FindBy(xpath = "//input[@id='login-button']")
    WebElement loginBtn;

    @FindBy(xpath = "//button[contains(text(),'Open Menu')]")
    WebElement openMenuLink;

    @FindBy(xpath = "//a[@id='logout_sidebar_link']")
    WebElement logoutLink;

    public void enterEmail(String uName){
        username.clear();
        username.sendKeys(uName);
    }
    public void enterPassword(String pwd){
        password.clear();
        password.sendKeys(pwd);
    }
    public void clickLogin(){
        loginBtn.click();
    }
    public void clickLogout() throws InterruptedException {

        openMenuLink.click();
        Thread.sleep(3000);
        logoutLink.click();
    }

}
