package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Utilities.Wait;

import java.text.DecimalFormat;
import java.util.List;

public class ProductDetailPage {

    private final WebDriver webDriver;
    String item;
    int quantity;
    float price;
    private static final DecimalFormat decimal2 = new DecimalFormat("0.00");

    public ProductDetailPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//h4[text()='Stuffed Frog']/following-sibling::p/a")
    private WebElement stuffedFrogBuyButton;

    @FindBy(xpath = "//h4[text()='Fluffy Bunny']/following-sibling::p/a")
    private WebElement fluffyBunnyBuyButton;
    
    @FindBy(xpath = "//h4[text()='Valentine Bear']/following-sibling::p/a")
    private WebElement valentineBearBuyButton;
    
    @FindBy(xpath = "//a[contains(text(),'Cart')]")
    private WebElement cartButton;

    public void buyItems(String item, String quantity,String amount) {
    	
    	this.item=item;
        this.quantity=Integer.parseInt(quantity);
        this.price=Float.parseFloat(amount);
        
    	for(int i=0;i<this.quantity;i++)
    	{
    		switch (this.item) {
    		  case "Stuffed Frog":
    			    Wait.untilElementIsVisible(webDriver, stuffedFrogBuyButton, 15L);
    		        stuffedFrogBuyButton.click();
    		    break;
    		  case "Fluffy Bunny":
    			    Wait.untilElementIsVisible(webDriver, fluffyBunnyBuyButton, 15L);
    			    fluffyBunnyBuyButton.click();
    		    break;
    		  case "Valentine Bear":
    			    Wait.untilElementIsVisible(webDriver, valentineBearBuyButton, 15L);
    			    valentineBearBuyButton.click();
    		    break;
    		}
    	   
    	}
    }
    
    public void clickCartButton() {
    	cartButton.isEnabled();
    	cartButton.click();
    }
    
    public float validatePriceAndSubtotalForItemsAndGetTotalAmount(String item, String quantity,String expectedAmount) {
    	this.item=item;
        this.quantity=Integer.parseInt(quantity);
        this.price=Float.parseFloat(expectedAmount);
        String expectedSubTotal=decimal2.format(this.quantity* this.price);
        float actualAmount=0;
        float actualSubTotal=0;
        switch (this.item) {
		  case "Stuffed Frog":
			  actualAmount=Float.parseFloat(webDriver.findElement(By.xpath("//td[text()=' Stuffed Frog']/parent::tr/td[2]")).getText().substring(1));
			  actualSubTotal=Float.parseFloat(webDriver.findElement(By.xpath("//td[text()=' Stuffed Frog']/parent::tr/td[4]")).getText().substring(1));
		    break;
		  case "Fluffy Bunny":
			  actualAmount=Float.parseFloat(webDriver.findElement(By.xpath("//td[text()=' Fluffy Bunny']/parent::tr/td[2]")).getText().substring(1));
			  actualSubTotal=Float.parseFloat(webDriver.findElement(By.xpath("//td[text()=' Fluffy Bunny']/parent::tr/td[4]")).getText().substring(1));
		    break;
		  case "Valentine Bear":
			  actualAmount=Float.parseFloat(webDriver.findElement(By.xpath("//td[text()=' Valentine Bear']/parent::tr/td[2]")).getText().substring(1));
			  actualSubTotal=Float.parseFloat(webDriver.findElement(By.xpath("//td[text()=' Valentine Bear']/parent::tr/td[4]")).getText().substring(1));
		    break;
		}
        
        Assert.assertEquals(actualAmount, this.price);
        Assert.assertEquals(actualSubTotal,Float.parseFloat(expectedSubTotal));
        return actualSubTotal;
    }
    
    public void validateTotalAmountForItems(float expectedTotalAmount) {
    	String actualTotalValue=webDriver.findElement(By.xpath("//td/strong[contains(text(),'Total')]")).getText();
    	String[] actualTotal = actualTotalValue.split(" ");
    	String actualTotalAmt=actualTotal[1];
    	float actualTotalAmount=Float.parseFloat(actualTotalAmt);
    	Assert.assertEquals(actualTotalAmount,expectedTotalAmount);
    }
    
    
}
