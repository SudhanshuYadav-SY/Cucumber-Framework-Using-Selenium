package Steps;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class get_Product_Description
{
    WebDriver driver;
    @Given("User is currently on the home page")
    public void user_is_currently_on_the_home_page()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @Then("User accesses the home page")
    public void user_accesses_the_home_page()
    {
        driver.get("https://tutorialsninja.com/demo/");
        driver.findElement(By.xpath("(//*[text()='My Account'])[1]")).click();
        driver.findElement(By.linkText("Login")).click();
    }
    @Then("User completes a successful login")
    public void user_completes_a_successful_login() throws InterruptedException
    {
        driver.findElement(By.name("email")).sendKeys("amotooricap9@gmail.com");
        Thread.sleep(3000);
        driver.findElement(By.name("password")).sendKeys("1234");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@value='Login']")).click();
        Thread.sleep(3000);
    }
    @Then("the user looks up a valid product")
    public void the_user_looks_up_a_valid_product() throws InterruptedException
    {
        driver.findElement(By.name("search")).sendKeys("HP");
        Thread.sleep(3000);
        driver.findElement(By.name("search")).sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        driver.findElement(By.linkText("HP LP3065")).click();
        Thread.sleep(3000);
    }
    @Test
    @Then("User gets product description")
    public void user_gets_product_description()
    {
        String actual_Description = driver.findElement(By.xpath("//*[@id='tab-description']/p")).getText();
        System.out.println(actual_Description);
    }
    @Then("user shuts chrome down")
    public void user_shuts_chrome_down()
    {
        driver.quit();
    }
}