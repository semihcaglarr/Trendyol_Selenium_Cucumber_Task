package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.GWD;

public class Hooks {

    @Before // Cucumber's Annotation
    public void Before() {

    }

    @After // Cucumber's Annotation
           // Runs after each scenario
    public void After() {

        GWD.quitDriver();
    }
}
