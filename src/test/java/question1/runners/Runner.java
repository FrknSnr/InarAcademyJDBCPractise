package question1.runners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features/question1",
        glue = "question1/stepDefinitions",
        plugin = {"html:target\\cucumber","json:target\\report.json"},
        tags = "@db"
)
public class Runner {
}
