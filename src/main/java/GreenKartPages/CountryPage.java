package GreenKartPages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CountryPage extends BasePage
{
    //locators
    By countryDropDown = By.xpath("//select");
    By agreeCheckBox = By.xpath("//input [@class='chkAgree']");
    By proceedButton = By.xpath("//button[contains(.,'Proceed')]");

    //methods

    public void selectCountry(String country)
    {
        explicitWait().until(ExpectedConditions.visibilityOfElementLocated(countryDropDown));
        Select select = new Select(getElement(countryDropDown));
        select.selectByVisibleText(country);
    }

    public void agreeTermsAndConditions()
    {
        click(agreeCheckBox);
    }

    public void proceedToFinalPage()
    {
        click(proceedButton);
    }
}
