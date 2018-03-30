package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

    }


    public By username() {
        return By.cssSelector("*[data-at=at-emailtxt]");
    }
}
