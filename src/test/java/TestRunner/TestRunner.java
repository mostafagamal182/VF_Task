package TestRunner;

import Steps.StepDef;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"features"},
        glue = {"Steps"},
        dryRun = true
)
public class TestRunner {

}
