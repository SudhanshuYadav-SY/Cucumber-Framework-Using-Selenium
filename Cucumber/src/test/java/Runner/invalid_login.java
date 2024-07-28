package Runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Feature_Files/login/invalid_login.feature",
        glue = "src/test/java/Steps/login_with_invalid_credentials.java"
)
public class invalid_login
{

}
