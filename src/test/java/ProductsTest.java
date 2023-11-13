import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProductsTest extends BaseTest {

    @Test
    public void productPriceShouldBeCorrectInTheCart() {
        driver.get("https://www.saucedemo.com");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.xpath("//*[text()='Sauce Labs Onesie']/ancestor::*[contains(@class,'inventory_item')]//button")).click();
        driver.findElement(By.id("shopping_cart_container")).click();
        String price = driver.findElement(By.xpath("//div[@class='inventory_item_name' " +
                "and text()='Sauce Labs Onesie']/following::*[@class='inventory_item_price']")).getText();
        assertEquals(price, "$7.99");

    }

    @Test
    public void addedProductNameShouldBeInTheCart() {
        driver.get("https://www.saucedemo.com");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.name("add-to-cart-sauce-labs-bike-light")).click();
        driver.findElement(By.xpath("//div[@class='inventory_item_name ' and text()='Sauce Labs Fleece Jacket']/following::button")).click();
        driver.findElement(By.id("shopping_cart_container")).click();
        String productJacket = driver.findElement(By.xpath("//div[text()='Sauce Labs Fleece Jacket']")).getText();
        assertEquals(productJacket, "Sauce Labs Fleece Jacket", "The selected item is not in the cart");
    }

    @Test
    public void numberOfProductsAddedToCartOnTheIcon() {
        driver.get("https://www.saucedemo.com");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.xpath("//div[@class='inventory_item']/descendant::*[contains(text(),'Add to cart')]")).click();
        driver.findElement(By.name("add-to-cart-sauce-labs-bike-light")).click();
        driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-onesie")).click();
        String numberOfProducts = driver.findElement(By.cssSelector(".shopping_cart_badge")).getText();
        assertEquals(numberOfProducts, "3", "The number of products on the cart icon is not as expected");
    }

    @Test
    public void continueShoppingFromCart() {
        driver.get("https://www.saucedemo.com");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        driver.get("https://www.saucedemo.com/cart.html");
        driver.findElement(By.cssSelector(".cart_footer .back")).click();
        String title = driver.findElement(By.cssSelector(".title")).getText();
        assertEquals(title, "Products", "Incorrect redirect");
    }
}
