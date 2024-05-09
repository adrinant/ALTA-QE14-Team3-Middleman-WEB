package step_definitions;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pageObject.DashboardPage;
import org.example.pageObject.SignInPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class SignInSteps {
    private final WebDriver driver = Hooks.driver;
    SignInPage signInPage = new SignInPage(driver);
    DashboardPage dashboardPage = new DashboardPage(driver);

    @Given("User is already on Middleman Website")
    public void userIsAlreadyOnMiddlemanWebsite() {
        Assert.assertTrue(signInPage.verifyWelcomePage());
    }

    @Then("User should see an Alert {string}")
    public void userShouldSeeAnAlert(String alert) {
        Assert.assertEquals(alert, signInPage.getRegisterSuccessAlert());
    }

    @When("User clicks OK on alert")
    public void userClicksOKOnAlert() {
        signInPage.clickAlertOk();
    }

    @Then("User should see form {string} HTML Required Validation Message")
    public void userShouldSeeFormHTMLValidationMessage(String elementName) {
        String elementXpath = "//input[@id='input-" + elementName + "']";

        //html validation message bisa diubah-ubah oleh dev dan sudah di handle oleh browser

        //check apakah elementnya memang required
        Assert.assertTrue(signInPage.checkInputFieldRequired(elementName));

        //assert validation message sesuai expected requirement
        String expectedValidationMessage = "Please fill out this field.";
        Assert.assertEquals(expectedValidationMessage, signInPage.getValidationMessage(elementXpath));
    }

    @When("User clicks Sign In Button")
    public void userClicksSignInButton() {
        signInPage.clickSignInButton();
    }

    @And("User input {string} in Email field, {string} in Password field")
    public void userInputEmailPassword(String email, String password) {
        signInPage.inputSignInForm(email, password);
    }

    @And("User clicks Sign In button")
    public void userClicksLoginSignInButton() {
        signInPage.clickLoginSignInButton();
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
        signInPage.verifyWelcomePage();
    }

}
