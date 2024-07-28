package Steps;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Price_in_empty_cart
{
    WebDriver driver;

    @Given("User is at Home Page")
    public void user_is_at_home_page()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://tutorialsninja.com/demo/");
    }
    @Then("User logs in successfully")
    public void user_logs_in_successfully() throws InterruptedException {
        driver.findElement(By.xpath("(//*[text()='My Account'])[1]")).click();
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.name("email")).sendKeys("amotooricap9@gmail.com");
        Thread.sleep(3000);
        driver.findElement(By.name("password")).sendKeys("1234");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@value=\"Login\"]")).click();
        Thread.sleep(3000);
    }
    @Then("Check Price in Cart")
    public void check_price_in_cart()
    {
        String actual_Web_element = driver.findElement(By.xpath("//*[@id=\"cart-total\"]")).getText();
        String empty_cart_price = "$0.00";
        if (actual_Web_element.contains(empty_cart_price))
            System.out.println("Price of Empty Cart is Validated");
        else
            System.out.println("Price of Cart is NOT Validated");
    }
    @Then("User ends the Session")
    public void user_ends_the_session()
    {
        driver.quit();
    }
}