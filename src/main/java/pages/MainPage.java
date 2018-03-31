package pages;

import driver.DriverFactory;
import org.openqa.selenium.By;

public class MainPage extends BasePage {

    public MainPage() {
        super(DriverFactory.getInstance());
    }

    public By username() {
        return By.cssSelector("*[data-at=at-emailtxt]");
    }

    public String getUsername() {
        return driver.findElement(By.cssSelector("*[data-at=at-emailtxt]")).getText();
    }
}
