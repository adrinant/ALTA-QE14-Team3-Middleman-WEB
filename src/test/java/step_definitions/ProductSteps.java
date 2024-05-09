package step_definitions;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pageObject.DashboardPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class ProductSteps {
    private final WebDriver driver = Hooks.driver;
    WelcomePage welcomePage = new WelcomePage(driver);
    DashboardPage dashboardPage = new DashboardPage(driver);

    @When("User clicks Add Product button")
    public void userClicksAddProductButton() {
        dashboardPage.clickAddProduct();
    }

    @Then("User should see Add Product Pop-Up")
    public void userShouldSeeAddProductPopUp() {
        Assert.assertTrue(dashboardPage.verifyAddProductPopUp());
    }

    @When("User choose {string} for product image")
    public void userChooseFileForProductImage(String namaFile) {
        dashboardPage.inputImageFile(namaFile);
    }

    @And("User input {string} in Product Name Field, {string} in Unit field, {string} in Stock field, {string} in Price field")
    public void userInputInProductNameFieldInUnitFieldInStockFieldInPriceField(String productName, String unit, String stock, String price) {
        dashboardPage.inputProductDetails(productName, unit, stock, price);
    }

    @And("User clicks Add Button")
    public void userClicksAddButton() {
        dashboardPage.clickAddButton();
    }

    @Then("User should see product {string} HTML Required Validation Message")
    public void userShouldSeeProductHTMLRequiredValidationMessage(String elementName) throws InterruptedException {
        //html validation message bisa diubah-ubah oleh dev dan sudah di handle oleh browser
        String elementXpath = "//div[@id='__next']/div[@class='modal']//input[@id='input-" + elementName + "']";

        //check apakah elementnya memang required
        Assert.assertTrue(welcomePage.checkInputFieldRequired(elementName));
        String expectedValidationMessage;

        if (elementName == "image") {
            expectedValidationMessage = "Please select a file.";
        } else {
            expectedValidationMessage = "Please fill out this field.";
        }

        //assert validation message sesuai expected requirement
        Assert.assertEquals(expectedValidationMessage, welcomePage.getValidationMessage(elementXpath));
    }

    @Then("User should see the {string} in My Product page")
    public void userShouldSeeTheProductInMyProductPage(String productName) {
        Assert.assertTrue(dashboardPage.verifyNewProduct(productName));
    }

    @When("User clicks + button on the {string}")
    public void userClicksButtonOnTheProduct(String productName) {
        dashboardPage.clickPlusButtonProduct(productName);
    }

    @When("User clicks Inbound Menu")
    public void userClicksInboundMenu() {
        dashboardPage.clickInboundButton();
    }

    @When("User clicks Outbound Menu")
    public void userClicksOutboundMenu() {
        dashboardPage.clickOutboundButton();
    }

    @Then("User should see the {string} that has just been added")
    public void userShouldSeeTheThatHasJustBeenAdded(String productName) {
        dashboardPage.verifyInboundProduct(productName);
    }

    @When("User clicks Submit Button")
    public void userClicksSubmitButton() {
        dashboardPage.clickSubmitButton();
    }

    @Then("User should see that the {string} stock is increased")
    public void userShouldSeeThatTheStockIsIncreased(String productName) {
        //+1 dari value stock lama
        Assert.assertEquals(DashboardPage.currentProductStock + 1, dashboardPage.getNewStock(productName));
    }

    @Then("User should see that the {string} stock is decreased")
    public void userShouldSeeThatTheStockIsDecreased(String productName) {
        //+1 dari value stock lama
        Assert.assertEquals(DashboardPage.currentProductStock - 1, dashboardPage.getNewStock(productName));
    }

    @When("User clicks Add button of {string}")
    public void userClicksAddButtonOf(String productName) {
        dashboardPage.userClickAddButtonOnProduct(productName);
    }

    @When("User clicks My Cart")
    public void userClicksMyCart() {
        dashboardPage.clickInboundButton();
    }

    @Then("User should see the product that have been just added")
    public void userShouldSeeTheProductThatHaveBeenJustAdded() {
        Assert.assertTrue(dashboardPage.verifyProductOnMyCart());
    }

    @When("User refresh the Middleman Dashboard")
    public void userRefreshTheMiddlemanDashboard() {
        dashboardPage.userClickMyProduct();
    }

    @When("User clicks Incoming Order button")
    public void userClicksIncomingOrderButton() {
        dashboardPage.clickIncomingOrderButton();
    }

    @Then("User should be redirected to incoming order page")
    public void userShouldBeRedirectedToIncomingOrderPage() {
        Assert.assertTrue(dashboardPage.verifyIncomingOrderPage());
    }

    @And("User should see any order placed by Users")
    public void userShouldSeeAnyOrderPlacedByUsers() {
        Assert.assertTrue(dashboardPage.verifyProductOnMyCart());
    }

    @When("User clicks History order button")
    public void userClicksHistoryOrderButton() {
        dashboardPage.clickHistoryOrderButton();
    }

    @Then("User should be redirected to History Order page")
    public void userShouldBeRedirectedToHistoryOrderPage() {
        Assert.assertTrue(dashboardPage.verifyOrderPage());
    }


    @And("Admin should see {string} in the History Order")
    public void adminShouldSeeInTheHistoryOrder(String orderID) {
        dashboardPage.adminVerifyOrderID(orderID);
    }

    @And("User should see {string} in the History Order")
    public void userShouldSeeInTheHistoryOrder(String orderID) {
        dashboardPage.userVerifyOrderID(orderID);
    }
}
