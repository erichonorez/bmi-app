package org.ucll.demo.service;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * Created by eric on 10/11/15.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
  features = { "src/test/resources/be.buyway.retailsolution/Authentication.feature" },
  plugin={"html:target/cucumber", "json:target/cucumber.json"}

)
public class AuthenticationTest {

}
