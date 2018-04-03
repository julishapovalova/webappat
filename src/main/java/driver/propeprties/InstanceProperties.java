package driver.propeprties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class InstanceProperties {

    private static Properties prop;

    private InstanceProperties() {
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
            init("src/main/resources/driver/instance.properties");
        }
        return prop.getProperty(propertyName);
    }
}
