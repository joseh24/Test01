package stepdefinitions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.LoginPage;
import org.openqa.selenium.WebDriver;
import utilities.BaseTest;

public class LoginSteps extends BaseTest {
    WebDriver driver;
    LoginPage login;

    @Before
    public void Initialize() {
        BaseTest.setUp();
        driver = BaseTest.driver;
    }

    @After
    public void quit() {
        BaseTest.tearDown();
    }

    @When("I launch the page")
    public void launchURl() {
        driver.get("https://www.saucedemo.com/");
        login = new LoginPage(driver);
    }

    @When("I enter username {string} and password {string}")
    public void enterCredentialsForLogin(String username, String password) {
        login.enterUsername(username);
        login.enterPassword(password);
        login.clickLogin();
    }

    @Then("I should be logged in successfully and inventory list displayed")
    public void verify_login() {
        Assert.assertTrue(login.isInvertoryListDisplayed());
    }

    @Then("I should get error message as {string}")
    public void verifyInvalidLoginErrorMesasge(String message){
        Assert.assertEquals(message,login.getLoginErrorMesage());

    }
    @Then("I add {string} and {string} to the cart")
    public void userAddProductToCart(String product1, String product2) {
        login.addItemsToCart(product1);
        login.addItemsToCart(product2);
    }
    @Then("I should see {string} and {string} in the cart")
    public void verifyItemAddedToCart(String item1,String item2){
        login.verifyTheAddedItemInCart(item1,item2);
    }

    @Then("I should checkout the items")
    public void checkoutProduct(){
        login.clickOnCheckoutButton();
    }
    @Then("I should enter {string} in {string}")
    public void enterValueInField(String value, String fieldName){
        login.enterText(value,fieldName);
    }
    @Then("I should click {string}")
    public void clickOnTheField(String fieldName){
        login.click(fieldName);
    }

    @When("I sort products by {string}")
    public void sortProducts(String sortType) {
       login.sortingProduct(sortType);
    }

    @Then("The products should be sorted by price in low to high order")
    public void verifySortedByPrice() {
        login.verifyProductSortedByPriceLowToHigh();
    }

}
