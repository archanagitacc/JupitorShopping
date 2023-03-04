package PageObjects;

import java.util.NoSuchElementException;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Utilities.Wait;

public class ContactUsPage {
	
	 private final WebDriver webDriver;

    public ContactUsPage(WebDriver webDriver) {
    	this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    
    @FindBy(xpath = "//div[@id='header-message']/descendant::strong")
    private WebElement contactHeaderMsg;
    
    @FindBy(xpath = "//a[text()='Submit']")
    private WebElement submitButton;
    
    @FindBy(id = "forename-err")
    private WebElement forenameErrorMsg;
    
    @FindBy(id = "email-err")
    private WebElement emailErrorMsg;
    
    @FindBy(id = "message-err")
    private WebElement messageErrorMsg;
    
    @FindBy(id = "forename")
    private WebElement forenameField;
    
    @FindBy(id = "email")
    private WebElement emailField;
    
    @FindBy(id = "message")
    private WebElement messageField;
    
    @FindBy(xpath = "//div[@class='alert alert-success']")
    private WebElement feedbackMsg;
    

    
    
    public String getFeedbackMsg() {
    	Wait.untilElementIsVisible(webDriver, feedbackMsg, 15L);
    	feedbackMsg.isDisplayed();
        return feedbackMsg.getText();
    }
    
    public String getContactPageHeaderMsg() {
    	contactHeaderMsg.isDisplayed();
        return contactHeaderMsg.getText();
    }
    
    public void validateMandatoryErrorMessages() {
    	String actualForeNameMsg = forenameErrorMsg.getText();
        Assert.assertEquals("Forename is required", actualForeNameMsg);
    	
        String actualEmailMsg = emailErrorMsg.getText();
        Assert.assertEquals("Email is required", actualEmailMsg);
        
        String actualMessageMsg = messageErrorMsg.getText();
        Assert.assertEquals("Message is required", actualMessageMsg);
    }


    public void fillContactFormData(String foreName,String email,String message) {
    	forenameField.clear();
    	forenameField.sendKeys(foreName);
    	emailField.clear();
    	emailField.sendKeys(email);
    	messageField.clear();
    	messageField.sendKeys(message);
    }
    
    public void validateMandatoryErrorMsgNotDisplayed() {
    	boolean isVisible=false;
    	
    	isVisible = invisibilityOf(forenameErrorMsg);
		if (isVisible)
			System.out.println("forename error msg is not visible");
		
		isVisible = invisibilityOf(emailErrorMsg);
		if (isVisible)
			System.out.println("email error msg is not visible");
		
		isVisible = invisibilityOf(messageErrorMsg);
		if (isVisible)
			System.out.println("message error msg is not visible");
    }
    
    
    public void clickSubmitButton() {
    	submitButton.isEnabled();
    	submitButton.click();
    }
    
    public static boolean invisibilityOf(WebElement element)
	{
    	 try {
    		 element.isDisplayed();
		        return true;
		    } catch (org.openqa.selenium.NoSuchElementException e) {
		        return false;
		    }
	}
}
