package driver;

import driver.propeprties.EnivormentProperties;
import driver.propeprties.EnivormentTypes;
import driver.propeprties.InstanceProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ChromeDriver extends Driver {

    private WebDriver driver;
    private DesiredCapabilities capabilities;


    ChromeDriver() {
        initChrome();
    }

    @Override
    public WebDriver getDriver() {
        return driver;
    }

    public void close() {
        driver.quit();
    }

    private void initChrome() {
        long implicitlyWait = Long.valueOf(InstanceProperties.getProperty("implicitly_Wait_CHROME"));
        long pageLoadTimeout = Long.valueOf(InstanceProperties.getProperty("page_Load_Timeout"));
        long explicityWait = Long.valueOf(InstanceProperties.getProperty("explicity_Wait_CHROME"));

        capabilities = DesiredCapabilities.chrome();
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new org.openqa.selenium.chrome.ChromeDriver();
        System.out.println("initiate browser " + Thread.currentThread().getId());

        driver.manage().timeouts().implicitlyWait(implicitlyWait, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);

        wait = new WebDriverWait(driver, explicityWait);

        driver.manage().window().maximize();
        driver.get(EnivormentProperties.getProperty("URL"));
    }
}
