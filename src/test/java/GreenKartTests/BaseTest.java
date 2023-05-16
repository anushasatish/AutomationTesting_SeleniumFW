package GreenKartTests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static driverManager.DriverManager.InitiateDriver;
import static driverManager.DriverManager.quitBrowser;

public class BaseTest
{
    @BeforeMethod
    public void setup()
    {
        InitiateDriver();
    }

    @AfterMethod
    public void teardown()
    {
        quitBrowser();
    }

}
