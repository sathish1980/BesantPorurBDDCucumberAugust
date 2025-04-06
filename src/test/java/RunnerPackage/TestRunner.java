package RunnerPackage;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"C:\\Users\\DELL\\eclipse-workspace\\BesantPorurBDDCucumberAugust\\src\\test\\java\\Features\\Sample.feature","C:\\Users\\DELL\\eclipse-workspace\\BesantPorurBDDCucumberAugust\\src\\test\\java\\Features\\MakeMyTripSearchPorur.feature"}
		,glue="StepDefenition",publish=true)
public class TestRunner {

}
