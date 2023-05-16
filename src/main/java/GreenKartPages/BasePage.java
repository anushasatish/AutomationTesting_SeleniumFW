package GreenKartPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.PropertiesUtil;

import java.time.Duration;

import static driverManager.DriverManager.getDriver;

public class BasePage
{
    public void click (By by)
    {
        getDriver().findElement(by).click();
    }

    public String getText(By by)
    {
        return getDriver().findElement(by).getText().trim();
    }

    public WebDriverWait explicitWait()
    {
    return new WebDriverWait(getDriver(), Duration.ofSeconds(PropertiesUtil.getExplicitTimeOutInSec()));
    }

    public WebElement getElement(By by)
    {
        return getDriver().findElement(by);
    }
}
