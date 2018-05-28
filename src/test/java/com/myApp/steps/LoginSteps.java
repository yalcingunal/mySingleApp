package com.myApp.steps;

import com.myApp.pages.LoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;


public class LoginSteps {

    private LoginPage loginPage;

    public LoginSteps(LoginPage loginPage) {
        this.loginPage = loginPage;
    }

    @Given("^Visitor is on the HomePage$")
    public void iVisitSsHomepage() throws Throwable {
        loginPage.navigate();
    }

    @When("^Customer login with \"([^\"]*)\" email and \"([^\"]*)\" password$")
    public void customerLoginWithEmailAndPassword(String email, String password) throws Throwable {
        loginPage.goToLoginPage();
        loginPage.loginWithEmailAndPassword(email, password);
    }

    @Then("^Customer should see Name and Surname as \"([^\"]*)\" on Home Page$")
    public void customerShouldSeeNameAndSurnameAsOnHomePage(String nameAndSurname) throws Throwable {
        Assert.assertEquals("Customer did not see name and surname", nameAndSurname, loginPage.getNameAndSurname());
        //Assert.assertEquals("", myAccountPage.getUserName(), nameAndSurname);
    }


}
