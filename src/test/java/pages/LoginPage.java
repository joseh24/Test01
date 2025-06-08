package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.*;
import java.util.stream.Collectors;

public class LoginPage {
    WebDriver driver;
    Map<String, By> fieldLocators = new HashMap<>();
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        fieldLocators.put("FirstName",firstName);
        fieldLocators.put("LastName",lastName);
        fieldLocators.put("PostalCode",postalCode);
        fieldLocators.put("CheckOutContinueButton",continueButton);
        fieldLocators.put("FinishButton",finishButton);
    }
//Locators
    By usernameField = By.id("user-name");
    By passwordField = By.id("password");
    By loginBtn = By.id("login-button");
    By loginErrorMesage =By.xpath("//div[@class='error-message-container error']");
    By inventoryList =By.id("inventory_container");
    By checkoutButton =By.id("checkout");
    By firstName= By.id("first-name");
    By lastName=By.id("last-name");
    By postalCode=By.id("postal-code");
    By continueButton =By.id("continue");
    By finishButton =By.id("finish");



    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginBtn).click();
    }

    public String getLoginErrorMesage(){
        return driver.findElement(loginErrorMesage).getText();
    }
    public boolean isInvertoryListDisplayed(){
       return driver.findElement(inventoryList).isDisplayed();
    }

    public void addItemsToCart(String productName) {
        WebElement addButton = driver.findElement(By.xpath("//div[text()='" + productName + "']/ancestor::div[@class='inventory_item']//button"));
        addButton.click();
    }
    public void verifyTheAddedItemInCart(String product1, String product2) {
        driver.findElement(By.className("shopping_cart_link")).click();
        List<WebElement> cartItems = driver.findElements(By.className("inventory_item_name"));

        List<String> productNames = cartItems.stream()
                .map(WebElement::getText)
                .toList();

        Assert.assertTrue(productNames.contains(product1));
        Assert.assertTrue(productNames.contains(product2));
    }
    public void clickOnCheckoutButton() {
        WebElement button = driver.findElement(checkoutButton);
        button.click();
    }

    public void enterText(String value,String fieldName){
        WebElement field= driver.findElement(fieldLocators.get(fieldName));
        field.sendKeys(value);
    }

    public void click(String fieldName){
        WebElement field= driver.findElement(fieldLocators.get(fieldName));
        field.click();
    }

   public void sortingProduct(String sortType) {
        Select sortDropdown = new Select(driver.findElement(By.className("product_sort_container")));
        sortDropdown.selectByVisibleText(sortType);
    }

    public void verifyProductSortedByPriceLowToHigh(){
        List<WebElement> priceElements = driver.findElements(By.className("inventory_item_price"));

        List<Double> actualPrices = priceElements.stream()
                .map(e -> Double.parseDouble(e.getText().replace("$", "")))
                .collect(Collectors.toList());

        List<Double> sortedPrices = new ArrayList<>(actualPrices);
        Collections.sort(sortedPrices);

        Assert.assertEquals("Prices are not sorted correctly", sortedPrices, actualPrices);
    }

}
