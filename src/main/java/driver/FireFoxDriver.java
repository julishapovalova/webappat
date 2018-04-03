package driver;

import driver.propeprties.EnivormentProperties;
import driver.propeprties.InstanceProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class FireFoxDriver extends Driver {

    private WebDriver driver;
    private DesiredCapabilities capabilities;

    public FireFoxDriver() {
        initFireFox();
    }

    @Override
    public WebDriver getDriver() {
        return driver;
    }

    public void close() {
        driver.quit();
    }

    private void initFireFox() {
        long implicitlyWait = Long.valueOf(InstanceProperties.getProperty("implicitly_Wait_FIREFOX"));
        long pageLoadTimeout = Long.valueOf(InstanceProperties.getProperty("page_Load_Timeout"));
        long explicityWait = Long.valueOf(InstanceProperties.getProperty("explicity_Wait_FIREFOX"));


        capabilities = DesiredCapabilities.firefox();
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(implicitlyWait, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);

        wait = new WebDriverWait(driver, explicityWait);
        driver.manage().window().maximize();
        driver.get(EnivormentProperties.getProperty("URL"));
    }
}
