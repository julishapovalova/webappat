package driver.propeprties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class EnivormentProperties {

    private static Properties prop;

    private EnivormentProperties() {
    }

    private static void init(String configName) {
        prop = new Properties();
        try {
            prop.load(new FileInputStream(configName));
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }
    }

    public static String getProperty(String propertyName) {
        if (prop == null) {
            String enivormentType = System.getProperty("enivormentType");
            switch (EnivormentTypes.valueOf(enivormentType)){
                case STAGING:
            init("src/main/resources/driver/enivorment/staging.properties");
                    break;
                case UAT:
                    init("src/main/resources/driver/enivorment/uat.properties");
                    break;
                case PRODUCTION:
                    init("src/main/resources/driver/enivorment/production.properties");
                    break;
            }
        }
        return prop.getProperty(propertyName);
    }
}
