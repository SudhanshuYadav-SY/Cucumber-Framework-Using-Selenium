package Steps;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class add_product_to_cart
{
    WebDriver driver;

    @Given("User opens Chrome Browser")
    public void user_opens_chrome_browser()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Then("User launches application")
    public void user_launches_application()
    {
        driver.get("https://tutorialsninja.com/demo/");
        driver.findElement(By.xpath("(//*[text()='My Account'])[1]")).click();
        driver.findElement(By.linkText("Login")).click();
    }
    @Then("User signs in to system")
    public void user_signs_in_to_system() throws InterruptedException
    {
        driver.findElement(By.name("email")).sendKeys("amotooricap9@gmail.com");
        Thread.sleep(3000);
        driver.findElement(By.name("password")).sendKeys("1234");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@value=\"Login\"]")).click();
        Thread.sleep(3000);
    }
    @Then("Searches a product")
    public void searches_a_product() throws InterruptedException
    {
        driver.findElement(By.name("search")).sendKeys("HP");
        Thread.sleep(3000);
        driver.findElement(By.name("search")).sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        driver.findElement(By.linkText("HP LP3065")).click();
        Thread.sleep(3000);
    }
    @Then("adds the product to cart")
    public void adds_the_product_to_cart() throws InterruptedException
    {
        driver.findElement(By.name("option[225]")).clear();
        Thread.sleep(3000);
        driver.findElement(By.name("option[225]")).sendKeys("2024-08-11");
        Thread.sleep(3000);
        driver.findElement(By.id("button-cart")).click();
        Thread.sleep(3000);
        String actual_Msg = driver.findElement(By.xpath("//*[@class=\"alert alert-success alert-dismissible\"]")).getText();
        String expect_Msg = "Success: You have added ";
        if (actual_Msg.contains(expect_Msg))
            System.out.println("Product Added to Cart Successfully!!");
        else
            System.out.println("Product NOT Added to Cart Successfully!!");
    }
    @Then("User shuts down chrome")
    public void user_shuts_down_chrome()
    {
        driver.quit();
    }
}