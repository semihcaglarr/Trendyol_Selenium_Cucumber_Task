package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import utilities.GWD;

@CucumberOptions
        (
                tags = "@RegressionTest or @SmokeTest",
                features = {"src/test/java/featureFiles"},
                glue = {"stepDefinitions"}
        )

public class TestRunnerParallel extends AbstractTestNGCucumberTests {

    @BeforeClass
    @Parameters("browserType")
    public void beforeClass(String browserName){
        GWD.threadBrowserName.set(browserName);
    }
}
