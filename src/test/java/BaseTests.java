import driver.Driver;
import driver.DriverFactory;
import driver.propeprties.BrowserTypes;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTests {

    public Driver driver;

    @BeforeSuite
    public void setUpBeforeSuite() {

    }

    @BeforeMethod
    public void setUpBeforeMethod() {
        driver = DriverFactory.getInstance(BrowserTypes.CHROME);

    }

    @AfterMethod
    public void tearDownAfterMethod() {
        driver.getInstance().quit();
    }


}
