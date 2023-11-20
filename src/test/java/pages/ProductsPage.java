package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductsPage extends BasePage {
    private final By TITLE = By.cssSelector(".title");
    private final String PRODUCT = "//*[text()='%s']/ancestor::*[contains(@class,'inventory_item')]//button";
    private final By CART = By.id("shopping_cart_container");
    private final By COUNT_OF_PRODUCTS_ICON = By.cssSelector(".shopping_cart_badge");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL + "inventory.html");
    }

    public String getTitle() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE));
        return driver.findElement(TITLE).getText();
    }

    public void buyProduct(String product_name) {
        driver.findElement(By.xpath(String.format(PRODUCT, product_name))).click();
    }

    public void goToCart() {
        driver.findElement(CART).click();
    }

    public String getCountOfAddedProductsCartIcon() {
        return driver.findElement(COUNT_OF_PRODUCTS_ICON).getText();
    }
}
