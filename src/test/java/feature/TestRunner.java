package feature;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(value = Cucumber.class)

@CucumberOptions(

        features = "src/test/java/feature",
        tags = "@run1 or @run2",
        glue={"stepDefinitions"}

)

public class TestRunner  {



}
