package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;


import static pages.RegistrationPage.*;


public class Reg {
    public static String email = "abdoo@gmail.com";
    public static String pass = "123456789";
    public static String firstName = "mohamed";
    public static String lastName = "abdo";

    @Given("open the registration page")
    public void goToUrl(){
        registerLink().click();
    }
    @When("enter valid data")
    public void enterValidData(){
        genderMale().click();
        firstName().sendKeys(firstName);
        lastName().sendKeys(lastName);
        dateOfBirthDay();
        dateOfBirthMonth();
        dateOfBirthYear();
        emailAddress().sendKeys(email);
        enterPassword().sendKeys(pass);
        enterConfirmPassword().sendKeys(pass);

    }
    @And("click registration button")
    public void clickRegistrationButton(){
        clickRegisterButton().click();
    }
    @Then("message is displayed")
    public void messageIsDisplayed(){
        String expectedResult = "Your registration completed";
        Assert.assertTrue(message().getText().contains(expectedResult), "Error Message: User couldn't register successfully");

    }
    @And("log out")
    public void clickLogOut(){
        clickLogoutButton().click();
    }

}
