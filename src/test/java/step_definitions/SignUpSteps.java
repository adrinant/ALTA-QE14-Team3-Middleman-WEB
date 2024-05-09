package step_definitions;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pageObject.SignUpPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class SignUpSteps {
    private final WebDriver driver = Hooks.driver;
    SignUpPage signUpPage = new SignUpPage(driver);
    @Given("User is already on Middleman Website")
    public void userIsAlreadyOnMiddlemanWebsite() {
        Assert.assertTrue(signUpPage.verifyWelcomePage());
    }
    @When("User clicks the sign-up button")
    public void userClicksTheSignUpButton() {
        signUpPage.clickSignUpButton();
    }

    @Then("User is redirected to the registration page")
    public void userIsRedirectedToTheRegistrationPage() {
        Assert.assertTrue(signUpPage.verifyRegisterPage());
    }

    @When("User inputs {string} in Shop Name field, {string} in Email field, {string} in Phone Number field, {string} in Password field, {string} in Address field")
    public void userInputsRegisterForm(String shopName, String email, String phoneNumber, String password, String address) {
        signUpPage.fillRegisterForm(shopName, email, phoneNumber, password, address);
    }

    @Then("User should see an Alert {string}")
    public void userShouldSeeAnAlert(String alert) {
        Assert.assertEquals(alert, signUpPage.getRegisterSuccessAlert());
    }

    @When("User clicks OK on alert")
    public void userClicksOKOnAlert() {
        signUpPage.clickAlertOk();
    }

    @Then("User is redirected to login page")
    public void userIsRedirectedBackToHomepage() {
        Assert.assertTrue(signUpPage.verifyLoginPage());
    }

    @Then("User should see form {string} HTML Required Validation Message")
    public void userShouldSeeFormHTMLValidationMessage(String elementName) {
        String elementXpath = "//input[@id='input-" + elementName + "']";

        //html validation message bisa diubah-ubah oleh dev dan sudah di handle oleh browser

        //check apakah elementnya memang required
        Assert.assertTrue(signUpPage.checkInputFieldRequired(elementName));

        //assert validation message sesuai expected requirement
        String expectedValidationMessage = "Please fill out this field.";
        Assert.assertEquals(expectedValidationMessage, signUpPage.getValidationMessage(elementXpath));
    }
    @When("User clicks the Login button")
    public void userClicksTheLoginButton() {
        signUpPage.clickRegisterLoginButton();
    }

}
