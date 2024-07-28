package Steps;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

public class login_with_invalid_credentials
{
    WebDriver driver;

    @Given("User on home page")
    public void user_on_home_page()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://tutorialsninja.com/demo/");
    }
    @Then("User reaches Login Page")
    public void user_reaches_login_page()
    {
        driver.findElement(By.xpath("(//*[text()='My Account'])[1]")).click();
        driver.findElement(By.linkText("Login")).click();
    }
    @Then("Enters Invalid Credentials")
    public void enters_invalid_credentials() throws InterruptedException
    {
        driver.findElement(By.name("email")).sendKeys("amotooricap1@gmail.com");
        Thread.sleep(3000);
        driver.findElement(By.name("password")).sendKeys("1234");
        Thread.sleep(3000);
    }

    @When("User Tries to Login")
    public void user_tries_to_login() throws InterruptedException
    {
        driver.findElement(By.xpath("//*[@value=\"Login\"]")).click();
        Thread.sleep(3000);
    }
    @Test
    @When("Gets Error Message")
    public void gets_error_message()
    {
        String actual_Error_Msg = driver.findElement(By.xpath("//*[@class=\"alert alert-danger alert-dismissible\"]")).getText();

        String expect_Error_Msg = "Warning: No match for E-Mail Address and/or Password.";

        if (actual_Error_Msg.equals(expect_Error_Msg))
            System.out.println("Error Message Verified!! And Error Message is \n"+actual_Error_Msg);
        else
            System.out.println("Error Message Not Verified !!");
    }
    @Then("User shuts chrome down")
    public void user_shuts_chrome_down()
    {
        driver.quit();
    }
}