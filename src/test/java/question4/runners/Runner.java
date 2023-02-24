package question4.runners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features/Question4.feature",
        glue = {"question4/stepDefs"},
        plugin = {"html:target/cucumber","json:target/report.json"},
        tags = "@db"
)
public class Runner {
}
