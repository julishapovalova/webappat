package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver=driver;
    }


    public HomePage open(WebDriver driver) {
        return new HomePage(driver);
    }

    public HomePage open() {
        return null;
    }

    public boolean checkIsOpen() {
        return false;

    }
}
