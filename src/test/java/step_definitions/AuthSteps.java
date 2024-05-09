package step_definitions;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pageObject.DashboardPage;
import org.example.pageObject.HomePage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class AuthSteps {

    private final WebDriver driver = Hooks.driver;
    HomePage welcomePage = new HomePage(driver);
    DashboardPage dashboardPage = new DashboardPage(driver);

    @Given("User is already on Middleman Website")
    public void userIsAlreadyOnMiddlemanWebsite() {
        Assert.assertTrue(welcomePage.verifyWelcomePage());
    }

    @When("User clicks the sign-up button")
    public void userClicksTheSignUpButton() {
        welcomePage.clickSignUpButton();
    }

    @Then("User is redirected to the registration page")
    public void userIsRedirectedToTheRegistrationPage() {
        Assert.assertTrue(welcomePage.verifyRegisterPage());
    }

    @When("User inputs {string} in Shop Name field, {string} in Email field, {string} in Phone Number field, {string} in Password field, {string} in Address field")
    public void userInputsRegisterForm(String shopName, String email, String phoneNumber, String password, String address) {
        welcomePage.fillRegisterForm(shopName, email, phoneNumber, password, address);
    }

    @Then("User should see an Alert {string}")
    public void userShouldSeeAnAlert(String alert) {
        Assert.assertEquals(alert, welcomePage.getRegisterSuccessAlert());
    }

    @When("User clicks OK on alert")
    public void userClicksOKOnAlert() {
        welcomePage.clickAlertOk();
    }

    @Then("User is redirected to login page")
    public void userIsRedirectedBackToHomepage() {
        Assert.assertTrue(welcomePage.verifyLoginPage());
    }

    @Then("User should see form {string} HTML Required Validation Message")
    public void userShouldSeeFormHTMLValidationMessage(String elementName) {
        String elementXpath = "//input[@id='input-" + elementName + "']";

        //html validation message bisa diubah-ubah oleh dev dan sudah di handle oleh browser

        //check apakah elementnya memang required
        Assert.assertTrue(welcomePage.checkInputFieldRequired(elementName));

        //assert validation message sesuai expected requirement
        String expectedValidationMessage = "Please fill out this field.";
        Assert.assertEquals(expectedValidationMessage, welcomePage.getValidationMessage(elementXpath));
    }

    @When("User clicks the Login button")
    public void userClicksTheLoginButton() {
        welcomePage.clickRegisterLoginButton();
    }

    @When("User clicks Sign In Button")
    public void userClicksSignInButton() {
        welcomePage.clickSignInButton();
    }

    @And("User input {string} in Email field, {string} in Password field")
    public void userInputEmailPassword(String email, String password) {
        welcomePage.inputSignInForm(email, password);
    }

    @And("User clicks Sign In button")
    public void userClicksLoginSignInButton() {
        welcomePage.clickLoginSignInButton();
    }

    @Then("User redirected to Middleman Dashboard")
    public void userRedirectedToMiddlemanDashboard() {
        Assert.assertTrue(dashboardPage.verifyDashboardPage());
    }

    @When("User clicks profile button")
    public void userClicksProfileButton() {
        dashboardPage.clickProfileButtonDropdown();
    }

    @And("User clicks logout button")
    public void userClicksLogoutButton() {
        dashboardPage.selectLogoutButton();
    }

    @Then("User should see Logout confirmation Pop-Up")
    public void userShouldSeeLogoutConfirmationPopUp() {
        dashboardPage.verifyLogoutPopUp();
    }

    @When("User clicks Yes Button")
    public void userClicksYesButton() {
        dashboardPage.clickYesButton();
    }

    @Then("User redirected back to welcome page")
    public void userRedirectedBackToWelcomePage() {
        welcomePage.verifyWelcomePage();
    }

}