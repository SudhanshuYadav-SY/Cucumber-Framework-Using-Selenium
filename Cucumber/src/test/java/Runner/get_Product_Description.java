package Runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Feature_Files/Cart_Functionality/get_product_description.feature",
        glue = "src/test/java/Steps/get_Product_Description.java"
)
public class get_Product_Description
{

}