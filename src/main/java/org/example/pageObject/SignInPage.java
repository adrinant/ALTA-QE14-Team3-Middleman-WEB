package org.example.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignInPage {

    public static WebDriver webDriver;

    public SignInPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        webDriver = driver;
    }

    //WelcomePage
    @FindBy(xpath = "//img[@alt='logo']")
    private WebElement middlemanLogo;
    @FindBy(xpath = "//img[@alt='store']")
    private WebElement middlemanStore;
    @FindBy(xpath = "//button[@id='to-login']")
    private WebElement signInButton;
    @FindBy(xpath = "//button[@id='to-register']")
    private WebElement signUpButton;

    //RegisterPage
    @FindBy(xpath = "//h1[@class='text-black font-Roboto font-extrabold text-5xl md:text-6xl']")
    private WebElement h1Hi;
    @FindBy(xpath = "//h4[@class='text-black/50 font-Roboto text-2xl italic md:text-3xl']")
    private WebElement h4Create;
    @FindBy(xpath = "//input[@id='input-name']")
    private WebElement shopNameField;
    @FindBy(xpath = "//input[@id='input-email']")
    private WebElement emailField;
    @FindBy(xpath = "//input[@id='input-phone']")
    private WebElement phoneNumberField;
    @FindBy(xpath = "//input[@id='input-password']")
    private WebElement passwordField;
    @FindBy(xpath = "//input[@id='input-address']")
    private WebElement addressField;
    @FindBy(xpath = "//a[@id='to-login']")
    private WebElement registerLoginButton;

    //LoginPage
    @FindBy(xpath = "//h1[@class='text-black font-Roboto font-extrabold text-5xl md:text-6xl']")
    private WebElement h1Welcome;
    @FindBy(xpath = "//h4[@class='text-black/50 font-Roboto text-2xl italic md:text-3xl']")
    private WebElement signInToContinue;
    @FindBy(xpath = "//button[@id='btn-login']")
    private WebElement loginLoginButton;

    public boolean verifyWelcomePage() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='logo']")));
        boolean a = middlemanLogo.isDisplayed();
        boolean b = middlemanStore.isDisplayed();
        boolean c = signInButton.isDisplayed();
        boolean d = signUpButton.isDisplayed();
        return a && b && c && d;
    }

    public void clickSignInButton() {
        signInButton.click();
    }

    public void clickSignUpButton() {
        signUpButton.click();
    }

    public boolean verifyRegisterPage() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='input-name']")));
        boolean a = shopNameField.isDisplayed();
        boolean b = emailField.isDisplayed();
        return a && b;
    }

    public void fillRegisterForm(String shopName, String email, String phoneNumber, String password, String address) {
        shopNameField.sendKeys(shopName);
        emailField.sendKeys(email);
        phoneNumberField.sendKeys(phoneNumber);
        passwordField.sendKeys(password);
        addressField.sendKeys(address);
    }

    public String getRegisterSuccessAlert() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        return webDriver.switchTo().alert().getText();
    }

    public void clickAlertOk() {
        webDriver.switchTo().alert().accept();
    }

    public boolean verifyLoginPage() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='text-black font-Roboto font-extrabold text-5xl md:text-6xl']")));
        boolean a = h1Welcome.isDisplayed();
        boolean b = signInToContinue.isDisplayed();
        boolean c = emailField.isDisplayed();
        boolean d = passwordField.isDisplayed();
        boolean e = loginLoginButton.isDisplayed();
        return a && b && c && d && e;
    }

    public boolean checkInputFieldRequired(String elementName) {
        String elementXpath = "//input[@id='input-" + elementName + "']";
        WebElement inputElement = webDriver.findElement(By.xpath(elementXpath));
        boolean required = Boolean.parseBoolean(inputElement.getAttribute("required"));
        return required;
    }

    public String getValidationMessage(String elementXpath) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5)); // Adjust the timeout as needed
        WebElement inputElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath)));
        String validationMessage = inputElement.getAttribute("validationMessage");
        return validationMessage;
    }

    public void clickRegisterLoginButton() {
        registerLoginButton.click();
    }

    //SignIn
    public void inputSignInForm(String email, String password) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='input-email']")));
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
    }

    public void clickLoginSignInButton() {
        loginLoginButton.click();
    }

}