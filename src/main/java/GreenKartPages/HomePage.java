package GreenKartPages;

import driverManager.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.PropertiesUtil;

import java.time.Duration;

import static driverManager.DriverManager.getDriver;

public class HomePage extends BasePage
{

    String HomePageURL = PropertiesUtil.getURL();
    //Locators

    By itemvalueLocator = By.xpath("//td[contains(.,'Items')]/following-sibling::td/strong");
    By pricevalueLocator = By.xpath("//td[contains(.,'Price')]/following-sibling::td/strong");

    By BrocolliItemLocator = By.xpath("//h4[contains(.,'Brocolli')]");

    String addToCartXpath = "//h4[contains(.,'$$')]/parent::div//button";
    By cartIconLocator = By.xpath("//a[@class='cart-icon']");
    By proceedtocheckoutlocator =By.xpath("//button [contains (.,'PROCEED TO CHECKOUT')]");


    //methods

    public void navigateToHomePage()
    {
    getDriver().get(HomePageURL);
    }

    public void waitUntilBrocolliElementisVisible()
    {
        explicitWait().until(ExpectedConditions.visibilityOfElementLocated(BrocolliItemLocator));
    }

    public String getTitle()
    {
        return getDriver().getTitle();
    }

    public int getItemsValue()
    {
       return Integer.parseInt(getText(itemvalueLocator));
    }

    public int getPriceValue()
    {
        return Integer.parseInt(getText(pricevalueLocator));
    }

    public void addToCart(String veg)
    {
        click(By.xpath(addToCartXpath.replace("$$", veg)));
    }

    public void openCartIcon()
    {
        click(cartIconLocator);
    }

    public CheckoutPage proceedToCheckout()
    {
        click(proceedtocheckoutlocator);
        return new CheckoutPage();
    }

    public boolean thankYouMsgPresent()
    {
        return getDriver().findElements(By.xpath("//*[contains(.,'Thank you, your order has been placed successfully')]")).size()>0;
    }
}
