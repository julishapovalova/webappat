package driver;

import driver.propeprties.BrowserTypes;

public class DriverFactory {

    public static synchronized Driver getInstance(BrowserTypes type) {
        switch (type) {
            case CHROME:
                return new ChromeDriver();
            case FIREFOX:
                return new FireFoxDriver();
        }
        return null;
    }

}
