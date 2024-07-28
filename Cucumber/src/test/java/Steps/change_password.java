package Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class change_password
{
    WebDriver driver;
    @Given("User at Home Page")
    public void user_at_home_page()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://tutorialsninja.com/demo/");
    }
    @Then("User logs in")
    public void user_logs_in() throws InterruptedException {
        driver.findElement(By.xpath("(//*[text()='My Account'])[1]")).click();
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.name("email")).sendKeys("amotooricap9@gmail.com");
        Thread.sleep(3000);
        driver.findElement(By.name("password")).sendKeys("1234");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@value=\"Login\"]")).click();
        Thread.sleep(3000);
    }
    @Then("User navigates to Change Password")
    public void user_navigates_to_change_password() throws InterruptedException {
        driver.findElement(By.linkText("Password")).click();
        Thread.sleep(3000);
    }
    @Test
    @Then("User changes Password")
    public void user_changes_password() throws InterruptedException {
        driver.findElement(By.name("password")).sendKeys("12345");
        Thread.sleep(3000);
        driver.findElement(By.name("confirm")).sendKeys("12345");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@value=\"Continue\"]")).click();
        String actual_Update_Msg = driver.findElement(By.xpath("//*[@class=\"alert alert-success alert-dismissible\"]")).getText();
        String expect_Update_Msg = "Success: Your password has been successfully updated.";
       if (actual_Update_Msg.equals(expect_Update_Msg))
           System.out.println("Password is CHANGED Successfully!!");
        else
           System.out.println("Password is NOT Changed");
    }
    @Then("User closes browser")
    public void user_closes_browser()
    {
        driver.quit();
    }
}