package Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class search_invalid_product
{
    WebDriver driver;

    @Given("User opens Automation window")
    public void user_opens_automation_window()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @Then("Navigates to Home Page")
    public void navigates_to_home_page()
    {
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://tutorialsninja.com/demo/");
        driver.findElement(By.xpath("(//*[text()='My Account'])[1]")).click();
        driver.findElement(By.linkText("Login")).click();
    }
    @Then("User Sign in to System using valid credentials")
    public void user_sign_in_to_system_using_valid_credentials() throws InterruptedException
    {
        driver.findElement(By.name("email")).sendKeys("amotooricap9@gmail.com");
        Thread.sleep(3000);
        driver.findElement(By.name("password")).sendKeys("1234");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@value=\"Login\"]")).click();
        Thread.sleep(3000);
        String actual_Text = driver.findElement(By.xpath("(//*[text()='My Account'])[4]")).getText();
        String expect_Text = "My Account";
        if (actual_Text.equals(expect_Text))
        {
            System.out.println("Login is SUCCESSFUL Lets Proceed to Search Product");
        }
        else
        {
            System.out.println("Login NOT Successful And We Can't Proceed to Product Search");
        }
    }
    @Test
    @Then("Search for an InValid Product")
    public void search_for_an_in_valid_product() throws InterruptedException
    {
        driver.findElement(By.name("search")).sendKeys("Dell");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@class=\"btn btn-default btn-lg\"]")).click();
        Thread.sleep(3000);
        String text_Msg = driver.findElement(By.xpath("//*[@id=\"button-search\"]/following::p[1]")).getText();
        String expect_Msg = "There is no product that matches the search criteria.";
        if (text_Msg.equals(expect_Msg))
        {
            System.out.println("Product Searched is UnAvailable Right now");
        }
        else
        {
            System.out.println("Valid Product Searched");
        }
    }
    @Then("User Ends Automation Window")
    public void user_ends_automation_window()
    {
        driver.quit();
    }
}