package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		//feature file location 
        features = ".//Features/Test.feature",
        //stepdefinitions mention
        glue = {"stepDefinitions"},
        //for reports
        plugin ={"pretty","html:test-output"},
      
        monochrome = true,
        dryRun=false
)

public class TestRun {

}
