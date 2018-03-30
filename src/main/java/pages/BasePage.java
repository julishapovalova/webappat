package pages;

import org.openqa.selenium.WebDriver;

public class BasePage {

    private final WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public BasePage open() {
        return this;
    }

    public boolean checkIsOpen(String expectedTitle) {
        return driver.getTitle().contains(expectedTitle);
    }

}
