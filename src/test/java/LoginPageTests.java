import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;

public class LoginPageTests extends BaseTests {

    @DataProvider(name = "users", parallel = true)
    public Object[][] loginData() {
        return new Object[][]{
                {"bqa10", "p"},
                {"bqa9", "p"}
        };
    }

    @Test(dataProvider = "users")
    public void canLogin(String email, String password) {
        System.out.println("Tests " + Thread.currentThread().getId());
        MainPage mainPage = new LoginPage(driver.getInstance())
                .open()
                .login(email, password);

        driver.wait.until(ExpectedConditions.textToBe(mainPage.username(), email));
    }
}
