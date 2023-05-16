package GreenKartTests;

import GreenKartPages.CheckoutPage;
import GreenKartPages.CountryPage;
import GreenKartPages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static driverManager.DriverManager.InitiateDriver;


public class EndToEndTests extends BaseTest
{

    HomePage homepage = new HomePage();

    @Test
    public void GreenKartEndToEndTest()
    {
       homepage.navigateToHomePage();
       homepage.waitUntilBrocolliElementisVisible();

       List <String> veggies = List.of("Orange","Almonds");
       for(String veg:veggies)
       {
           homepage.addToCart(veg);
       }

       //Assert 1 - check item count
       int actualItemCount = homepage.getItemsValue();
       int expectedItemCount = veggies.size();
       Assert.assertEquals(actualItemCount,expectedItemCount,"veg count not as expected");

       homepage.openCartIcon();

       CheckoutPage checkOutPage = homepage.proceedToCheckout();

       //Assert 2 - check discounts
       checkOutPage.verifyPromoCodeIsApplied();
       int ActualDiscount = checkOutPage.getDiscount();
       int ExpectedDiscount = 10;
       Assert.assertEquals(ActualDiscount,ExpectedDiscount);

       List <String> actualProductFromTable = checkOutPage.getProductsFromTable();
       Assert.assertTrue(actualProductFromTable.containsAll(veggies), "List does not contain all veggies.");

        CountryPage countrypage = checkOutPage.placeOrder();
        countrypage.selectCountry("Canada");
        countrypage.agreeTermsAndConditions();
        countrypage.proceedToFinalPage();

        Assert.assertTrue (homepage.thankYouMsgPresent(),"Msg not present");
        homepage.waitUntilBrocolliElementisVisible();
        Assert.assertEquals(homepage.getTitle(),"GreenKart - veg and fruits kart", "Did not navigate to Home Page");

    }
}
