package step_definitions;

import hooks.Hooks;
import io.cucumber.java.en.Given;
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
}
