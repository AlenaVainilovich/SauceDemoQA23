package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CartTest extends BaseTest {

    @Test
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

    @Test
    public void addedProductNameShouldBeInTheCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.buyProduct("Sauce Labs Bolt T-Shirt");
        productsPage.buyProduct("Sauce Labs Fleece Jacket");
        productsPage.buyProduct("Sauce Labs Bike Light");
        cartPage.open();
        assertEquals(cartPage.getProductName("Sauce Labs Fleece Jacket"),
                "Sauce Labs Fleece Jacket",
                "The selected item is not in the cart");
    }

    @Test
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
