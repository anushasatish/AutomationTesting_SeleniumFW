package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginStepDefinition
{
    WebDriver driver;
    WebDriverWait wait ;

    @Given("user is a valid orange HRM user")
    public void user_is_a_valid_orange_hrm_user() {
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @When("user logs into the HRM portal")
    public void user_logs_into_the_hrm_portal() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@placeholder='Username']")));
        driver.findElement(By.xpath("//*[@placeholder='Username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[contains(.,'Login')]")).click();
    }

    @Then("user should be on homepage")
    public void user_should_be_on_homepage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6")));
        String header = driver.findElement(By.xpath("//h6")).getText();
        Assert.assertEquals(header, "Dashboard");
    }
}
