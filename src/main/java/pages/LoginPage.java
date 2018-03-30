package pages;

import driver.propeprties.EnvironmentProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    private WebDriver driver;

    @FindBy(css = "*[data-at=at-mailtbx")
    private WebElement emailTextBox;

    @FindBy(css = "*[data-at=at-passtbx]")
    private WebElement passwordTextBox;

    @FindBy(css = "*[data-at=at-loginbtn]")
    private WebElement loginButton;


    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public MainPage login(String email, String password) {
        emailTextBox.sendKeys(email);
        passwordTextBox.sendKeys(password);
        loginButton.click();

        return new MainPage(driver);
    }


    public LoginPage open() {
        return this;
    }

    public boolean checkIsOpen() {
        return driver.getTitle().contains("Login");
    }
}
