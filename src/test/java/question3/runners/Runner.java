package question3.runners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features/Question3.feature",
        glue = {"question3/stepDefs"},
        plugin = {"html:target/cucumber","json:target/report.json"},
        tags = "@db"
)
public class Runner {
}
