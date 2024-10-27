package org.example.stepDefinition;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.example.pageObjects.cartPage;
import org.example.pageObjects.loginPage;
import org.testng.Assert;

public class loginSteps {
    static WebDriver driver;
    public loginPage lgnpage;
    public cartPage cartpage;
    public static Logger logger;
    @BeforeAll
    public static void setUp(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        logger = Logger.getLogger(loginSteps.class);
        PropertyConfigurator.configure("log4j.properties");
    }

    @When("User opens url {string}")
    public void user_opens_url(String url) {

        lgnpage = new loginPage(driver);
        driver.get(url);
        logger.info("url opened");
    }

    @When("User enters Email as {string} and password as {string}")
    public void user_enters_email_as_and_password_as(String email, String password) {

        lgnpage.enterEmail(email);
        logger.info("email entered");
        lgnpage.enterPassword(password);
        logger.info("password entered");
    }

    @When("Click on login")
    public void click_on_login() {

        lgnpage.clickLogin();
        logger.info("login clicked");
    }

    @Then("The page title should be {string}")
    public void the_page_title_should_be(String expctTitle) {
        String actualTitle = driver.getTitle();
        if (actualTitle.equals(expctTitle)){
            logger.info("title matched");
            Assert.assertTrue(true);
        }else {
            logger.info("title not matched");
            Assert.assertTrue(false);
        }
    }

    @When("user click logout link")
    public void user_click_logout_link() throws InterruptedException {

        lgnpage.clickLogout();
        logger.info("logged out website");
    }

    @And("Add items to cart")
    public void add_items_to_cart() {

        cartpage = new cartPage(driver);
        cartpage.addItemsToCart();
        logger.info("added items to cart");

    }

    @Then("Checkout the items in cart")
    public void checkout_the_items_in_cart() {
        cartpage.clickAddToCartBtn();
    }

    @And("Fill customer details")
    public void fill_customer_details() {
        logger.info("entering customer details");
        cartpage.addDetails("shakib","hasan","581003");

    }

    @Then("Finish the order")
    public void finish_the_order() {
        cartpage.checkoutAndFinish();
        logger.info("finished order");
    }

    @Then("Verify the msg {string}")
    public void verify_the_msg(String expMsg) {
        String txt = cartpage.verifyMsg();

        if (txt.equals(expMsg)){
            logger.info("msg verified");
            Assert.assertTrue(true);
        }else {
            logger.info("msg not verified");
            Assert.assertTrue(false);
        }

    }
    @AfterAll
    public static void tearDown(){
        driver.quit();
    }



}
