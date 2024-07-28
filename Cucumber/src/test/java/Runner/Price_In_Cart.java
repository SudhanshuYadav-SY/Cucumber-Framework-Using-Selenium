package Runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Feature_Files/Cart_Functionality/check_price_just_after_login.feature",
        glue = "src\\test\\java\\Steps\\Price_in_empty_cart.java"
)
public class Price_In_Cart
{

}
