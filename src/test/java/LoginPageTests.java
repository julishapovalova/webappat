import driver.DriverFactory;
import driver.propeprties.EnivormentProperties;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;

public class LoginPageTests extends BaseTests {

    @DataProvider(name = "users", parallel = true)
    public Object[][] loginData() {

        return new Object[][]{
                {EnivormentProperties.getProperty("email"), EnivormentProperties.getProperty("password")}
        };
    }

    @Test(dataProvider = "users")
    public void canLogin(String email, String password) {
        System.out.println("Tests " + Thread.currentThread().getId());
        MainPage mainPage = new LoginPage()
                .open()
                .login(email, password);

        DriverFactory.getInstance().wait.until(ExpectedConditions.textToBe(mainPage.username(), email));
    }
}
