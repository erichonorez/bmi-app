package org.ucll.demo.service;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;

/**
 * Created by eric on 10/11/15.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
  features = { "src/test/resources/org.ucll.demo.org.ucll.demo.service/ShowPatientDetails.feature" },
  plugin={"html:target/cucumber", "json:target/cucumber.json"}
)
public class ShowPatientDetailsTest {

}
