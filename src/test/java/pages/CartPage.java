package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
    private final String PRODUCT_PRICE = "//div[@class='inventory_item_name' " +
            "and text()='%s']/following::*[@class='inventory_item_price']";
    private final String PRODUCT_NAME = "//div[text()='%s']";
    private final By CONTINUE_SHOPPING_BUTTON = By.cssSelector(".cart_footer .back");


    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL + "cart.html");
    }

    public String getProductPrice(String product_name) {
        return driver.findElement(By.xpath(String.format(PRODUCT_PRICE, product_name))).getText();
    }

    public String getProductName(String product_name) {
        return driver.findElement(By.xpath(String.format(PRODUCT_NAME, product_name))).getText();
    }

    public void continueShoppingButton() {
        driver.findElement(CONTINUE_SHOPPING_BUTTON).click();
    }
}
