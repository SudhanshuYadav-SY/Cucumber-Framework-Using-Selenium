package Runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Feature_Files/Change_Password/Change_User_Password.feature",
        glue = "src/test/java/Steps/change_password.java"
)
public class change_password
{

}
