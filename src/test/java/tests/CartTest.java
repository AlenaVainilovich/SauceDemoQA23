package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CartTest extends BaseTest {

    @Test(description = "Product price should be correct in the cart", retryAnalyzer = Retry.class)
    public void productPriceShouldBeCorrectInTheCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.buyProduct("Sauce Labs Bolt T-Shirt");
        productsPage.buyProduct("Sauce Labs Fleece Jacket");
        productsPage.buyProduct("Sauce Labs Bike Light");
        productsPage.goToCart();
        assertEquals(cartPage.getProductPrice("Sauce Labs Bike Light"),
                "$9.99",
                "The price of the product does not match its name.");

    }

    @Test(description = "The added product should appear in the cart", retryAnalyzer = Retry.class)
    public void addedProductShouldBeInTheCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.buyProduct("Sauce Labs Bolt T-Shirt");
        productsPage.buyProduct("Sauce Labs Fleece Jacket");
        productsPage.buyProduct("Sauce Labs Bike Light");
        cartPage.open();
        assertTrue(cartPage.isProductExistInTheCart("Sauce Labs Fleece Jacket"),
                "The selected item is not in the cart");
    }

    @Test(description = "Continue shopping", retryAnalyzer = Retry.class)
    public void continueShoppingFromCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.buyProduct("Sauce Labs Bolt T-Shirt");
        productsPage.buyProduct("Sauce Labs Fleece Jacket");
        productsPage.buyProduct("Sauce Labs Bike Light");
        cartPage.open();
        cartPage.continueShoppingButton();
        assertEquals(productsPage.getTitle(),
                "Products",
                "Incorrect redirect");
    }
}
