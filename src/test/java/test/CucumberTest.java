package test;

import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(io.cucumber.junit.Cucumber.class)
@CucumberOptions(
        glue = {"test"},
        features = {"src/test/resources"},
        plugin = {"pretty","html:reports/cucumber.html", "json:reports/cucumber.json"}
//
)
public class CucumberTest {
}
