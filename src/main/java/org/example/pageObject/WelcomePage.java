package org.example.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage {
    public static WebDriver webDriver;

    public WelcomePage(WebDriver driver) {
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

}
