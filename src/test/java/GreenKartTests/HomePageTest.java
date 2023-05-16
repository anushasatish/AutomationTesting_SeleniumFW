package GreenKartTests;

import GreenKartPages.HomePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static driverManager.DriverManager.InitiateDriver;
import static driverManager.DriverManager.quitBrowser;



public class HomePageTest extends BaseTest
{
    HomePage homepage = new HomePage();


    @Test
    public void PageTitleTest()
    {
        homepage.navigateToHomePage();
        homepage.waitUntilBrocolliElementisVisible();

        String ActualTitle = homepage.getTitle();

        String ExpectedTitle = "GreenKart - veg and fruits kart";
        Assert.assertEquals(ActualTitle,ExpectedTitle,"Title not as expected");
    }

    @Test
    public void DefaultItemsPriceTest()
    {
        homepage.navigateToHomePage();
        homepage.waitUntilBrocolliElementisVisible();

        Assert.assertEquals(homepage.getItemsValue(),0,"Items default not 0");
        Assert.assertEquals(homepage.getPriceValue(),0,"Price default not 0");

    }
}
