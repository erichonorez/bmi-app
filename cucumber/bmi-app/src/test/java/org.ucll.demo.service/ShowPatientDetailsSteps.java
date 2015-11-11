package org.ucll.demo.service;

import org.junit.Assert;
import org.ucll.demo.domain.Gender;

import java.text.SimpleDateFormat;
import java.util.Date;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.ucll.demo.service.api.java.PersonServiceJavaApi;
import org.ucll.demo.service.api.java.to.ExaminationDetail;
import org.ucll.demo.service.api.java.to.PersonDetail;

/**
 * Created by eric on 10/11/15.
 */
public class ShowPatientDetailsSteps {

  private static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("yyyy-MM-dd");

  private String socialSecurityNbr;
  private Gender gender = Gender.MALE;
  private Date birthDate;
  private PersonDetail patient;
  private PersonDetail savedPatientDetail;

  private PersonServiceJavaApi personService;

  @Given("^a patient with the social security number (\\d+), gender male and birthdate (\\d+)-(\\d+)-(\\d+)$")
  public void a_patient_with_the_social_security_number_gender_male_and_birthdate(int arg1, int arg2, int arg3, int arg4) throws Throwable {
    this.socialSecurityNbr = Integer.toString(arg1);
    this.gender = Gender.MALE;
    this.birthDate = DATE_FORMATTER.parse(arg2 + "-" + arg3 + "-" + arg4);
    this.patient = new PersonDetail(this.socialSecurityNbr,this.gender,this.birthDate);
  }

  @Given("^on (\\d+)-(\\d+)-(\\d+) the patient had a length of (\\d+) cm and a weight of (\\d+) gr$")
  public void on_the_patient_had_a_length_of_cm_and_a_weight_of_gr(int arg1, int arg2, int arg3, int arg4, int arg5) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    ExaminationDetail examination = new ExaminationDetail(arg4, arg5, DATE_FORMATTER.parse(arg1 + "-" + arg2 + "-" + arg3));
    this.patient.setExaminationDetail(examination);
  }

  @Given("^the patient is registered$")
  public void the_patient_is_registered() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    this.personService = new PersonServiceJavaApi();
    this.personService.addPerson(this.patient);
  }

  @When("^I ask for the details of the patient using his social security number$")
  public void i_ask_for_the_details_of_the_patient_using_his_social_security_number() throws Throwable {
    this.savedPatientDetail = this.personService.getPerson(this.socialSecurityNbr);
  }

  @Then("^the personal details social security number, gender and birthdate are given$")
  public void the_personal_details_social_security_number_gender_and_birthdate_are_given() throws Throwable {
    Assert.assertEquals(this.socialSecurityNbr, this.savedPatientDetail.getSocialSecurityNumber());
    Assert.assertEquals(this.gender, this.savedPatientDetail.getGender());
    Assert.assertEquals(this.birthDate, this.savedPatientDetail.getBirthdate());
    this.savedPatientDetail.getGender().isMale();
  }

  @Then("^the examination details length, weight and last examination date are given$")
  public void the_examination_details_length_weight_and_last_examination_date_are_given() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }

  @Then("^the calculated bmi (\\d+)\\.(\\d+) is given$")
  public void the_calculated_bmi_is_given(int arg1, int arg2) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }

}
