package stepdefinitions;

import PageObjects.ContactUsPage;
import PageObjects.HomePage;
import Utilities.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class HomeSteps {

    HomePage homePage;
    ContactUsPage contactUsPage;
    TestContext testContext;

    public HomeSteps(TestContext context) {
        testContext = context;
        homePage = testContext.getPageObjectManager().getHomePage();
        contactUsPage = testContext.getPageObjectManager().getContactUsPage();
    }

    @Then("User launches Jupitor toys shopping website")
    public void homePageIsDisplayed() {
        Assert.assertTrue(homePage.shoppingSiteHomePageTitleIsDisplayed());
        String actualShoppingSiteTitle = homePage.getshoppingSiteTitle();
        Assert.assertEquals(actualShoppingSiteTitle,"Jupiter Toys");
    }
    
    @And("User navigates from Home page to Contact Page")
    public void navigateToContactPage() {
    	homePage.clickContactUsButton();
    	String actualMsg = contactUsPage.getContactPageHeaderMsg();
        Assert.assertEquals("We welcome your feedback", actualMsg);
    }
    
    @And("User navigates from Home page to Shop Page")
    public void navigateToShopPage() {
    	homePage.clickShopButton();
    }
}
