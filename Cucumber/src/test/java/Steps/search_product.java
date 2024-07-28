package Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class search_product
{
    WebDriver driver;
    @Given("user launch web browser")
    public void user_launch_web_browser()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @Then("User opens home page")
    public void user_opens_home_page()
    {
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://tutorialsninja.com/demo/");
        driver.findElement(By.xpath("(//*[text()='My Account'])[1]")).click();
        driver.findElement(By.linkText("Login")).click();
    }
    @Then("User logs in using valid credentials")
    public void user_logs_in_using_valid_credentials() throws InterruptedException
    {
        driver.findElement(By.name("email")).sendKeys("amotooricap9@gmail.com");
        Thread.sleep(3000);
        driver.findElement(By.name("password")).sendKeys("1234");
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
    @Then("User search a valid product")
    public void user_search_a_valid_product() throws InterruptedException
    {
        driver.findElement(By.name("search")).sendKeys("HP");
        Thread.sleep(3000);
        driver.findElement(By.name("search")).sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        driver.findElement(By.linkText("HP LP3065")).click();
        Thread.sleep(3000);
    }
}