package driver.propeprties;

public abstract interface BaseDataProvider {
    String envPropertiesFile = "src/test/resources/properties/instance.properties";
    String URL = "https://trading.superbinary.com/";
    long implicitlyWaitCHROME = 1;
    long implicitly_Wait_FIREFOX = 1;
    long page_Load_Timeout=30;
}
