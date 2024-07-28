package Runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Feature_Files/Cart_Functionality/add_product_then_empty.feature",
        glue = "src/test/java/Steps/Dismiss_Added_Product.java"
)
public class dismiss_product_from_cart
{

}