package driver;

import driver.propeprties.BrowserTypes;

public class DriverFactory {

    private static final ThreadLocal<Driver> DRIVER = new ThreadLocal<Driver>();

    public static Driver getInstance() {
        return DRIVER.get();
    }

    public static void inititateDriver(BrowserTypes browser) {
        if (DRIVER.get() == null) {
            switch (browser) {
                case CHROME:
                    DRIVER.set(new ChromeDriver());
                    break;
                case FIREFOX:
                    DRIVER.set(new FireFoxDriver());
                    break;
            }
        }
    }

    public static void removeDriver() {
     //   if (DRIVER.get() == null) {
            DRIVER.get().close();
            DRIVER.remove();
    //    }
    }
}
