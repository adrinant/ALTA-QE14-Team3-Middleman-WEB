package org.example.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage {
    public static WebDriver webDriver;

    public DashboardPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        webDriver = driver;
    }

    @FindBy(xpath = "//input[@id='input-search']")
    private WebElement searchField;
    @FindBy(xpath = "//div[@class='dropdown dropdown-end mx-2 hidden lg:block']")
    private WebElement profileButton;
    @FindBy(xpath = "//button[@class='btn btn-sm btn-secondary text-white mt-2 p-1']")
    private WebElement logoutButton;
    @FindBy(xpath = "//div[@id='__next']/div[@class='modal']/div[.='LogoutAre you sure you want to logout ?YesNo']")
    private WebElement logoutModal;
    @FindBy(xpath = "//button[@id='btn-yes']")
    private WebElement yesButton;

    @FindBy(xpath = "//button[@class='btn btn-sm btn-primary modal-button text-white font-Roboto']")
    private WebElement addProductButton;
    @FindBy(xpath = "//div[@id='__next']/div[@class='modal']/div[.='Add ProductProduct Image*AddCancel']")
    private WebElement addProductModal;
    @FindBy(xpath = "//div[@id='__next']/div[@class='modal']//input[@id='input-name']")
    private WebElement productNameField;
    @FindBy(xpath = "//div[@id='__next']/div[@class='modal']//input[@id='input-image']")
    private WebElement chooseImageFile;
    @FindBy(xpath = "//div[@id='__next']/div[@class='modal']//input[@id='input-unit']")
    private WebElement unitField;
    @FindBy(xpath = "//div[@id='__next']/div[@class='modal']//input[@id='input-stock']")
    private WebElement stockField;
    @FindBy(xpath = "//div[@id='__next']/div[@class='modal']//input[@id='input-price']")
    private WebElement priceField;
    @FindBy(xpath = "/html/body/div/div[5]/div/form/div[2]/button[@id='btn-add']")
    private WebElement addButton;

    @FindBy(xpath = "//ul[@class='menu menu-horizontal font-Roboto font-medium']//a[@id='to-cart']")
    private WebElement inboundButton;
    @FindBy(xpath = "//ul[@class='menu menu-horizontal font-Roboto font-medium']//a[@id='to-outbound']")
    private WebElement outboundButton;
    @FindBy(xpath = "//button[@id='btn-submit']")
    private WebElement submitButton;
    @FindBy(xpath = "//ul[@class='menu menu-horizontal font-Roboto font-medium']//a[@id='to-my-product']")
    private WebElement myProductButton;

    public boolean verifyDashboardPage() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='input-search']")));
        return searchField.isDisplayed();
    }

    public void clickProfileButtonDropdown() {
        profileButton.click();
    }

    public void selectLogoutButton() {
        logoutButton.click();
    }

    public boolean verifyLogoutPopUp() {
        return logoutModal.isDisplayed();
    }

    public void clickYesButton() {
        yesButton.click();
    }

    public void clickAddProduct() {
        addProductButton.click();
    }

    public boolean verifyAddProductPopUp() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='__next']/div[@class='modal']/div[.='Add ProductProduct Image*AddCancel']")));
        boolean a = addProductModal.isDisplayed();
        boolean b = productNameField.isDisplayed();
        return a && b;
    }

    public void inputImageFile(String namaFile) {
        String filePath = System.getProperty("user.dir") + "/src/main/resources/" + namaFile;
        chooseImageFile.sendKeys(filePath);
    }

    public void inputProductDetails(String productName, String unit, String stock, String price) {
        productNameField.sendKeys(productName);
        unitField.sendKeys(unit);
        stockField.sendKeys(stock);
        priceField.sendKeys(price);
    }

    public void clickAddButton() {
        addButton.click();
    }

    public boolean verifyNewProduct(String productName) {
        String elementXpath = "//h2[.='" + productName + "']";
        // Wait for the element to be present
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        WebElement productNameH2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath)));
        // Return the text of the element
        return productNameH2.isDisplayed();
    }

    public static int currentProductStock;

    public void clickPlusButtonProduct(String productName) {
        String elementXpath = "//h2[.='" + productName + "']/ancestor::div[2]/following-sibling::div/div/button";
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        WebElement productPlusButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath)));
        productPlusButton.click();

        //get Currentstock
        String stockXpath = "//div/div[4]/div/div/div/h2[contains(text(), '" + productName + "')]/following-sibling::h3[contains(text(), 'Stock')]";
        WebElement stockElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(stockXpath)));
        String stockText = stockElement.getText();
        currentProductStock = Integer.parseInt(stockText.replace("Stock: ", ""));
    }

    public void clickInboundButton() {
        inboundButton.click();
    }

    public void clickOutboundButton() {
        outboundButton.click();
    }

    public boolean verifyInboundProduct(String productName) {
        String elementXpath = "//h2[.='" + productName + "']";
        // Wait for the element to be present
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        WebElement productNameH2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath)));
        // Return the text of the element
        return productNameH2.isDisplayed();
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public void clickMyProduct() {
        myProductButton.click();
    }

    public int getNewStock(String productName) {
        //get Newstock
        String stockXpath = "//div/div[4]/div/div/div/h2[contains(text(), '" + productName + "')]/following-sibling::h3[contains(text(), 'Stock')]";
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        WebElement stockElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(stockXpath)));
        String stockText = stockElement.getText();

        int newCurrentProductStock = Integer.parseInt(stockText.replace("Stock: ", ""));
        return newCurrentProductStock;
    }

    public void userClickAddButtonOnProduct(String productName) {
        String addButtonXpath = "//html/body/div/div/div[3]/div/div/div/h1[contains(text(), '" + productName + "')]/following-sibling::button";
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        WebElement addButtonElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(addButtonXpath)));
        addButtonElement.click();
    }

    @FindBy(xpath = "//h2[@class='card-title text-base']")
    private WebElement cardTitleTextBase;

    public boolean verifyProductOnMyCart() {
        return cardTitleTextBase.isDisplayed();
    }

    @FindBy(xpath = "//ul[@class='menu menu-horizontal font-Roboto font-medium']//a[@id='to-inventory']")
    private WebElement userMyProduct;

    public void userClickMyProduct() {
        userMyProduct.click();
    }

    @FindBy(xpath = "//ul[@class='menu menu-horizontal font-Roboto font-medium']//a[@id='to-inventory']")
    private WebElement incomingOrderButton;

    public void clickIncomingOrderButton() {
        incomingOrderButton.click();
    }

    @FindBy(xpath = "//table[@class='w-full table-fluid font-Poppins']")
    private WebElement incomingOrderTable;

    public boolean verifyIncomingOrderPage() {
        return incomingOrderTable.isDisplayed();
    }

    @FindBy(xpath = "//ul[@class='menu menu-horizontal font-Roboto font-medium']//a[@id='to-history-order']")
    private WebElement historyOrderButton;

    public void clickHistoryOrderButton() {
        historyOrderButton.click();
    }

    public boolean verifyOrderPage() {
        String historyOrderH1Xpath = "//h1[@class='text-black font-Roboto font-semibold text-[30px] p-9 text-center md:text-[44px] lg:text-[44px] lg:text-left lg:ml-20']";
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        WebElement historyOrderH1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(historyOrderH1Xpath)));
        return historyOrderH1.isDisplayed();
    }

    public boolean adminVerifyOrderID(String orderID) {
        String xpathID = "//td[.='" + orderID + "']";
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        WebElement xpathIDElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathID)));
        return xpathIDElement.isDisplayed();
    }

    public boolean userVerifyOrderID(String orderID) {
        String xpathID = "//p[.='ID Order : " + orderID + "']";
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        WebElement xpathIDElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathID)));
        return xpathIDElement.isDisplayed();
    }

}