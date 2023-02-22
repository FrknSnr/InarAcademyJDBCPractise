package question1.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {

      private static Properties prop ;
     static  {
        String path = "config.properties";
        try {
            FileInputStream file = new FileInputStream(path);
            prop = new Properties();
            prop.load(file);
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//    private static Properties prop ;
//    static {
//        String path = "config.properties";
//        try {
//            FileInputStream file = new FileInputStream(path);
//            prop = new Properties();
//            prop.load(file);
//            file.close();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
    public static String getProperty(String key){
        return prop.getProperty(key);
    }
}
