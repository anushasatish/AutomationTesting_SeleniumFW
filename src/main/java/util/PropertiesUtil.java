package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil
{
    static Properties properties;
static {
    //loading property files
    properties = new Properties();
    String propertiesFilePath = "/Users/dank/Downloads/IntellijProjects/AutomationTesting_SeleniumFW/src/test/resources/framework.properties";
    FileInputStream fis;
    try {
        fis = new FileInputStream(propertiesFilePath);
    } catch (FileNotFoundException e) {
        throw new RuntimeException(e);
    }
    try {
        properties.load(fis);
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}
    public static String getURL()
    {
        return properties.getProperty("url","https://www.google.com");

    }

    public static String getBrowser()
    {
        return properties.getProperty("browser","chrome");
    }

    public static int getExplicitTimeOutInSec()
    {
        return Integer.parseInt(properties.getProperty("explicitTime","5"));

    }

}
