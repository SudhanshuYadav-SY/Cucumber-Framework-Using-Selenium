package Runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Feature_Files/Search_Product/In_Valid_Product_Search.feature",
        glue = "src/test/java/Steps/search_invalid_product.java"
)
public class invalid_product_search
{

}