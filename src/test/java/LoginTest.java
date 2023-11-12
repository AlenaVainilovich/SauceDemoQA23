import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test
    public void successfulLogin() {
        driver.get("https://www.saucedemo.com");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        String title = driver.findElement(By.cssSelector(".title")).getText();
        assertEquals(title, "Products", "User is not logged in or wrong page is opened");
    }

    @Test
    public void requiredFields() {
        driver.get("https://www.saucedemo.com");
        driver.findElement(By.id("user-name")).sendKeys("");
        driver.findElement(By.id("password")).sendKeys("");
        driver.findElement(By.id("login-button")).click();
        String errorMessage = driver.findElement(By.cssSelector("[data-test='error']")).getText();
        assertEquals(errorMessage, "Epic sadface: Username is required", "Fields are required");
    }

    @Test
    public void lockedOutUser() {
        driver.get("https://www.saucedemo.com");
        driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        String errorMessage = driver.findElement(By.cssSelector("[data-test='error']")).getText();
        assertEquals(errorMessage, "Epic sadface: Sorry, this user has been locked out.", "User is locked");
    }

    @Test
    public void requiredPassword() {
        driver.get("https://www.saucedemo.com");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("");
        driver.findElement(By.id("login-button")).click();
        String errorMessage = driver.findElement(By.cssSelector("[data-test='error']")).getText();
        assertEquals(errorMessage, "Epic sadface: Password is required", "Password is required");
    }

    @Test
    public void wrongPassword() {
        driver.get("https://www.saucedemo.com");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("123123");
        driver.findElement(By.id("login-button")).click();
        String errorMessage = driver.findElement(By.cssSelector("[data-test='error']")).getText();
        assertEquals(errorMessage, "Epic sadface: Username and password do not match any user in this service",
                "Invalid user-password pair");
    }

}
