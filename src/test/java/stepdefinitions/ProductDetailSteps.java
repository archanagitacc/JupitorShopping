package stepdefinitions;

import Enums.Context;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.testng.Assert;
import PageObjects.ProductDetailPage;
import Utilities.TestContext;

public class ProductDetailSteps {

    TestContext testContext;
    ProductDetailPage productDetailPage;
    List<Map<String, String>> data;
   

    public ProductDetailSteps(TestContext context) {
        testContext = context;
        productDetailPage = testContext.getPageObjectManager().getProductDetailPage();
    }

    @When("User purchases different items from shopping bucket")
    public void perchaseitems(DataTable table) {
    	data = table.asMaps(String.class, String.class);
        for(int i=0;i<data.size();i++)
        {
        productDetailPage.buyItems(data.get(i).get("items"),data.get(i).get("quantity"),data.get(i).get("price"));
        }
    }
    
    @And("User navigates to Cart page")
    public void navigateToCartPage() {
    	productDetailPage.clickCartButton();
    }
    
    @And("Validate product and bill amount details")
    public void validateProductAndBillDetails() {
    	float expectedTotalAmount=0;
    	for(int i=0;i<data.size();i++)
        {
    		expectedTotalAmount=expectedTotalAmount+productDetailPage.validatePriceAndSubtotalForItemsAndGetTotalAmount(data.get(i).get("items"),data.get(i).get("quantity"),data.get(i).get("price"));
        }
    	productDetailPage.validateTotalAmountForItems(expectedTotalAmount);
    	
    }
}
