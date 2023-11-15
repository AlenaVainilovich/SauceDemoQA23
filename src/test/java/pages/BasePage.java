package pages;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    public final String BASE_URL= "https://www.saucedemo.com/";

    WebDriver driver;

    BasePage(WebDriver driver) {
        this.driver = driver;
    }
}
