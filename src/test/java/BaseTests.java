import driver.DriverFactory;
import driver.propeprties.BrowserTypes;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTests {

    @BeforeMethod(alwaysRun = true)
    public void setUpBeforeMethod() {
        DriverFactory.inititateDriver(BrowserTypes.CHROME);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownAfterMethod() {
        DriverFactory.removeDriver();
    }

}
