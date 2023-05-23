package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class HeaderList {
    WebDriver driver;
    WebDriverWait wait ;
    @Given("user is a valid OrangeHRMPage user")
    public void user_is_a_valid_orange_hrm_page_user() {
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @When("user logs into the OrangeHRM portal")
    public void user_logs_into_the_orange_hrm_portal() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@placeholder='Username']")));
        driver.findElement(By.xpath("//*[@placeholder='Username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[contains(.,'Login')]")).click();
    }

    @Then("user should be on homepage and see list of Header elements")
    public void user_should_be_on_homepage_and_see_list_of_header_elements() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6")));
        String header = driver.findElement(By.xpath("//h6")).getText();
        Assert.assertEquals(header, "Dashboard");

        List<WebElement> HeaderElements = driver.findElements(By.xpath("//li[@class='oxd-main-menu-item-wrapper']"));
        List<String> headers = new ArrayList<>();
        for (WebElement element : HeaderElements)
        {
            headers.add(element.getText());
        }

        System.out.println(headers);
        driver.quit();

    }


}
