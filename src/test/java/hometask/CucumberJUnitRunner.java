package hometask;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import io.cucumber.junit.platform.engine.Constants;


@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("hometask")
@ConfigurationParameter(key = Constants.GLUE_PROPERTY_NAME,value = "hometask.steps")
public class CucumberJUnitRunner {

}
