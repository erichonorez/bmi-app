package org.ucll.demo.service;

import com.codeborne.selenide.Selectors;

import org.openqa.selenium.By;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

/**
 * Created by eric on 10/11/15.
 */
public class AuthenticationSteps {

  private String login;
  private String password;

  @Given("^a retailer with login \"([^\"]*)\" and password \"([^\"]*)\"$")
  public void a_retailer_with_login_and_password(String arg1, String arg2) throws Throwable {
    this.login = arg1;
    this.password = arg2;
  }

  @When("^I click on login$")
  public void i_click_on_login() throws Throwable {
    open("https://acc.buyway.be/retailsolution");
    $(By.id("username")).setValue(this.login);
    $(By.id("password")).setValue(this.password);
    $(By.id("loginButton")).click();
  }

  @Then("^I am on the home page$")
  public void i_am_on_the_home_page() throws Throwable {
    $(By.id("topbar_retailer_name")).shouldHave(text(this.login));
  }

}
