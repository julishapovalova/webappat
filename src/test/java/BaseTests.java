import driver.Driver;
import driver.DriverFactory;
import driver.propeprties.BrowserTypes;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import pages.LoginPage;

public class BaseTests {

    public Driver driver;

    @BeforeSuite
    public void setUpBeforeSuite() {

    }

    @BeforeMethod(alwaysRun = true)
    public void setUpBeforeMethod() {

        driver = DriverFactory.getInstance(BrowserTypes.CHROME);
        System.out.println("Before" + Thread.currentThread().getId());
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownAfterMethod() {
        driver.getInstance().quit();
        System.out.println("After" + Thread.currentThread().getId());
    }


}
