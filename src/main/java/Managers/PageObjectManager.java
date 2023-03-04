package Managers;

import PageObjects.ContactUsPage;
import PageObjects.HomePage;
import org.openqa.selenium.WebDriver;
import PageObjects.ProductDetailPage;

public class PageObjectManager {

    private final WebDriver webDriver;
    private HomePage homePage;
    private ProductDetailPage productDetailPage;
    private ContactUsPage contactUsPage;

    public PageObjectManager(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    
    public ContactUsPage getContactUsPage() {

        if (contactUsPage == null) {
        	contactUsPage = new ContactUsPage(webDriver);
        }
        return contactUsPage;
    }

    public HomePage getHomePage() {
        return (homePage == null) ? homePage = new HomePage(webDriver) : homePage;
    }


    public ProductDetailPage getProductDetailPage() {
        if (productDetailPage == null) productDetailPage = new ProductDetailPage(webDriver);
        return productDetailPage;
    }
}
