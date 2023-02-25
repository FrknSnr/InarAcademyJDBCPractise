package question5.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber","json:target/report.json"},
        features = "src/test/java/features/Question5.feature",
        glue = {"question5/stepDefs"},
        tags = "@db"
)
public class Runner {
}
