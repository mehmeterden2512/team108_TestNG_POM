package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    /*
    Bu class configration.properties uzantılı test datalarini
    ihtiyac olan yere getirmesi icin olustutulmustur.
     */
    static Properties properties;
    static {//once calısır
        String dosyaYolu= "configuration.properties";
        try {
            FileInputStream fis= new FileInputStream(dosyaYolu);
            properties= new Properties();
            properties.load(fis);
        } catch (IOException e) {
            System.out.println("properties dosyasi okunamadi");
        }
    }
    public static String getProperty(String key){
        return properties.getProperty(key);
    }
}
