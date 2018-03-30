package driver;

import driver.propeprties.BrowserTypes;

public class DriverFactory {

    private static final ThreadLocal<Driver> DRIVER = new ThreadLocal<Driver>();

    public static synchronized Driver getInstance(BrowserTypes type) {
        switch (type) {
            case CHROME:
                DRIVER.set(new ChromeDriver());
                return DRIVER.get();
            case FIREFOX:
                if (DRIVER.get() == null) {
                    DRIVER.set(new FireFoxDriver());
                }
                return DRIVER.get();
        }
        return null;
    }


    public static Driver getDriver() {
        return DRIVER.get();
    }

    public void remove() {
        if (DRIVER.get() != null) {
            DRIVER.remove();
        }
    }

}
