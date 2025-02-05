package pl.inpost.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "pl.inpost.steps",
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        monochrome = false
)
public class ApiRunnerTests {
}
