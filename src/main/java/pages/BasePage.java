package pages;

import driver.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    public WebDriver driver;
    public WebDriverWait wait;

    public BasePage(Driver driver) {
        this.driver = driver.getDriver();
        wait = driver.wait;
        PageFactory.initElements(this.driver, this);

    }

    public BasePage open() {
        return this;
    }

    public boolean checkIsOpen(String expectedTitle) {
        return driver.getTitle().contains(expectedTitle);
    }

}
