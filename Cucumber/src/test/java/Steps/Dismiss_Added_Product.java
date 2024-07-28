package Steps;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Dismiss_Added_Product
{
    WebDriver driver;

    @Given("User opened Home Page")
    public void user_opened_home_page()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://tutorialsninja.com/demo/");
        driver.findElement(By.xpath("(//*[text()='My Account'])[1]")).click();
        driver.findElement(By.linkText("Login")).click();
    }
    @Then("User logged in")
    public void user_logged_in() throws InterruptedException
    {
        driver.findElement(By.name("email")).sendKeys("amotooricap9@gmail.com");
        Thread.sleep(3000);
        driver.findElement(By.name("password")).sendKeys("1234");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@value=\"Login\"]")).click();
        Thread.sleep(3000);
    }
    @Then("User Add Product to Cart")
    public void user_add_product_to_cart() throws InterruptedException
    {
        driver.findElement(By.name("search")).sendKeys("HP");
        Thread.sleep(3000);
        driver.findElement(By.name("search")).sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        driver.findElement(By.linkText("HP LP3065")).click();
        Thread.sleep(3000);
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
    @Then("User removes Product from Cart")
    public void user_removes_product_from_cart() throws InterruptedException
    {
        driver.findElement(By.id("cart-total")).click();
        driver.findElement(By.linkText("shopping cart")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@class='fa fa-times-circle']")).click();
        Thread.sleep(3000);
        String msg = driver.findElement(By.xpath("//*[@id='content']")).getText();
        driver.findElement(By.linkText("Continue")).click();
        Thread.sleep(3000);
    }
    @Then("User shuts chrome")
    public void user_shuts_chrome()
    {
        driver.quit();
    }
}