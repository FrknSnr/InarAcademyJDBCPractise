package question5.resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {

    static Properties prop = new Properties();

    static {
        String path = "configQuestion5.properties";
        try {
            FileInputStream file = new FileInputStream(path);
            prop.load(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String getProperty(String key){
        return prop.getProperty(key);
    }
}
