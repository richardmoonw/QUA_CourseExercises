package mx.tec.lab;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		strict= true,
		features="src/test/resources"
)
public class TestBddApplicationTests {

}
