package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BasePage {
    public static final int WAIT = 120;
    public static WebDriver driver;
    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void clickCenter(WebElement e) {
        Actions actions = new Actions(driver);
        int elementX = e.getLocation().getX() + e.getSize().getWidth() / 2;
        int elementY = e.getLocation().getY() + e.getSize().getHeight() / 2;
        actions.moveToElement(e, elementX, elementY).perform();
        e.click();
    }
    public void click(WebElement e) {
        waitForElementVisible(e);
        waitForElementClickable(e);
        e.click();
    }
    public void doubleClick(WebElement e) {
        waitForElementVisible(e);
        waitForElementClickable(e);
        new Actions(driver)
                .doubleClick(e)
                .perform();
    }
    public void clickByCoordinate(WebElement e) {
        int a = e.getLocation().getX();
        int b = e.getLocation().getY();
        System.out.println("location X : "+ a);
        System.out.println("location Y : "+ b);
        Actions actions = new Actions(driver);
        actions.moveByOffset(a, b).click().build().perform();
    }
    public void zoomInOut(String zoomLevel){
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("document.body.style.zoom='" + zoomLevel + "'");
    }
    public void waitForElementVisible(WebElement e) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT));
        wait.until(ExpectedConditions.visibilityOf(e));
    }
    public void waitForElementClickable(WebElement e) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT));
        wait.until(ExpectedConditions.elementToBeClickable(e));
    }
    public void waitForElementDisappear(WebElement e) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT));
        wait.until(ExpectedConditions.invisibilityOf(e));
    }
    public void sendKeys(WebElement e,String txt) {
        waitForElementVisible(e);
        e.sendKeys(txt);
    }
    public String getText(WebElement e) {
        return e.getText();
    }
    public boolean isDisplayed(WebElement e) {
        waitForElementVisible(e);
        return e.isDisplayed();
    }
    public void scrollIntoView(WebElement e) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(false);", e);
        waitForElementVisible(e);
    }
    public void clear(WebElement e){
        waitForElementClickable(e);
        click(e);
        e.clear();
    }
    public void refreshPage(){
        driver.navigate().refresh();
    }
    public void back(){
        driver.navigate().back();
    }
    public void forward(){
        driver.navigate().forward();
    }
    //switch tab berdasarkan urutan tab
    public void switchToWindow(int index) {
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        System.out.println("Window Handles: " + tabs);
        driver.switchTo().window(tabs.get(index));
        System.out.println("Switched to tab" + index);
    }
    public void openNewTab(String newTabUrl){
        ((JavascriptExecutor) driver).executeScript("window.open(arguments[0], '_blank');", newTabUrl);
    }
    public void inputURL(String URL){
        driver.get(URL);
    }
    public void inputChar(WebElement e, String charKeyboard){
        Actions actions = new Actions(driver);
        actions.sendKeys(e, charKeyboard)
                .perform();
    }
    //tag must be select
    public void selectByVisibleText(WebElement e, String visibleText){
        Select sort = new Select(e);
        sort.selectByVisibleText(visibleText);
    }
    public void selectByIndex(WebElement e, int index){
        Select sort = new Select(e);
        sort.selectByIndex(index);
    }
    public void directToElement(WebElement e){
        Actions action = new Actions(driver);
        action.moveToElement(e).build().perform();
        action.click();
    }
    public void dragAndDrop(WebElement elementStart, WebElement elementFinish){
        new Actions(driver)
                .dragAndDrop(elementStart, elementFinish)
                .perform();
    }
    public void dragAndDropByCoordinate(WebElement elementStart, WebElement elementFinish){
        Rectangle start = elementStart.getRect();
        Rectangle finish = elementFinish.getRect();
        new Actions(driver)
                .dragAndDropBy(elementStart, finish.getX() - start.getX(), finish.getY() - start.getY())
                .perform();
    }
    public void getCoordinate(WebElement e){
        Point location = e.getLocation();
        int x = location.getX();
        int y = location.getY();
        System.out.println("coordinate X =" + x + "coordinate Y ="+ y);
    }
    public void keyDown(String charKeyboard){
        new Actions(driver)
                .keyDown(Keys.SHIFT)
                .sendKeys(charKeyboard)
                .perform();
    }
    public void inputCharOnKeyboard(String inputKeys){
        new Actions(driver)
                .sendKeys(inputKeys)
                .perform();
    }
    public void alertDismiss(){
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }
    public void acceptAlert(){
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    public void getTextAlert(){
        Alert alert = driver.switchTo().alert();
        String text = alert.getText();
        alert.dismiss();
    }
    public void slide(WebElement slider, int x, int y){
        Actions actions = new Actions(driver);
        actions.moveToElement(slider,x,y).perform();
        System.out.println("Element already slide to x : "+ x +" y : "+ y);
    }

}