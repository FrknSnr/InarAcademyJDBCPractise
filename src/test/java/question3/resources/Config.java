package question3.resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {

    private static final Properties prop;

    static {
        String path = "configQuestion3.properties";
        try {
            prop = new Properties();
            FileInputStream file = new FileInputStream(path);
            prop.load(file);
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getProperty(String key) {
        return prop.getProperty(key);
    }
}
