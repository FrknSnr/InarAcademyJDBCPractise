package question4.resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {

    private static Properties prop;

    static {
        String path = "configQuestion4.properties";
        try {
            FileInputStream file = new FileInputStream(path);
            prop = new Properties();
            prop.load(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String getProperty(String key) throws IOException {
        return prop.getProperty(key);
    }
}
