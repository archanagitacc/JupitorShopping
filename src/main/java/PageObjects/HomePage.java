package PageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HomePage {
	
	private final WebDriver webDriver;
    public HomePage(WebDriver webDriver) {
    	this.webDriver = webDriver;
        PageFactory.initElements(new AjaxElementLocatorFactory(webDriver, 15), this);
    }

    @FindBy(xpath = "//head/title")
    private WebElement shoppingSiteTitle;

    @FindBy(xpath = "//a[text()='Contact']")
    private WebElement contactButton;
    
    @FindBy(xpath = "//a[text()='Shop']")
    private WebElement shopButton;

    public void clickContactUsButton() {
        contactButton.isEnabled();
        contactButton.click();
    }
    
    public void clickShopButton() {
    	shopButton.isEnabled();
    	shopButton.click();
    }
    
    public boolean shoppingSiteHomePageTitleIsDisplayed() {
    	shoppingSiteTitle.isDisplayed();
        return true;
    }

    public String getshoppingSiteTitle() {
    	System.out.println("Title : "+webDriver.getTitle());
        return webDriver.getTitle();
    }
    
    
}
