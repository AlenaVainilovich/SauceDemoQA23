package tests;

import org.testng.annotations.Test;


import static org.testng.Assert.assertEquals;

public class ProductsTest extends BaseTest {
    @Test
    public void numberOfProductsAddedToCartOnTheIcon() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.buyProduct("Sauce Labs Bolt T-Shirt");
        productsPage.buyProduct("Sauce Labs Fleece Jacket");
        productsPage.buyProduct("Sauce Labs Bike Light");
        assertEquals(productsPage.getCountOfAddedProductsCartIcon(),
                "3",
                "The number of products on the cart icon is not as expected");
    }
}
