package driverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import util.PropertiesUtil;

public class DriverManager
{
    private static WebDriver driver;

    public static void InitiateDriver()
    {
        String browser = PropertiesUtil.getBrowser();
        if (browser.equals("chrome")) {
            driver = new ChromeDriver();
        }else{
            driver = new SafariDriver();
        }
        driver.manage().window().maximize();
    }

    public static WebDriver getDriver()
    {
        return driver;
    }

    public static void quitBrowser()
    {
        driver.quit();
    }
}
