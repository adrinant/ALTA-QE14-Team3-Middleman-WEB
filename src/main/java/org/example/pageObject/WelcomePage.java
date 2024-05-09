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
}
