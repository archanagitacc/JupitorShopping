package stepdefinitions;

import PageObjects.ContactUsPage;
import Utilities.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;


public class ContactUsSteps {

    TestContext testContext;
    ContactUsPage contactUsPage;

    public ContactUsSteps(TestContext context) {
        testContext = context;
        contactUsPage = testContext.getPageObjectManager().getContactUsPage();
    }

    
    @And("User clicks submit button on contact form")
    public void submitContactForm() {
    	contactUsPage.clickSubmitButton();
    }
    
    @And("Validate error messages for mandatory fields")
    public void contactPageMandatoryErrorMessageValidation() {
    	contactUsPage.validateMandatoryErrorMessages();
    }

    @When("User populate mandatory fields forename as {string} and email as {string} and message as {string}")
    public void populateMandatoryFieldsInContactForm(String foreName, String email, String message) {
        System.out.println("---" + foreName);
        System.out.println("---" + email);
        System.out.println("---" + message);
        contactUsPage.fillContactFormData(foreName,email,message);
    }

    @Then("Validate mandatory error messages are not visible to the user")
    public void validateErrorMessageAreNotDisplayed() {
    	contactUsPage.validateMandatoryErrorMsgNotDisplayed();
    }
    
    @And("Validate successful feedback message for user {string}")
    public void validateFeedbackMessage(String forename) {
    	String actualMsg = contactUsPage.getFeedbackMsg();
        Assert.assertEquals("Thanks "+forename+", we appreciate your feedback.",actualMsg);
    }
    
  

}
