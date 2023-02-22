package question2.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber", "json:target/report.json"},
        features = "src/test/java/features/Question2.feature",
        glue = {"question2/stepDefs"},
        tags = "@db"
)
public class Runner {

}
