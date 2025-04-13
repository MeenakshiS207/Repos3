package PageObjectModel;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.List;


public class WebPage {


    WebDriver ld;
    Actions action;

    private static final By Cookies_Btn = By.xpath("//button[contains(text(),'Accept All Cookies')]");

    private static final By Close_Btn = By.xpath("//div[@class='dy-lb-close']");
    private static final By Search_Bar = By.xpath("//input[@type='search']");

    private static final By First_Item = By.xpath("//li[@id='autocomplete-0-query-item-0']");

    private static final By Search_Item = By.xpath("//li[@class='active']");

    private static final By Shop_By_Age = By.xpath("//a[normalize-space()='Shop by age']");
    private static final By Category = By.xpath("//a[text() = '0-3 months']");

    private static final By Price_Option = By.xpath("//div[contains(text(),'Price')]");
    private static final By Brands_Option = By.xpath("//div[contains(text(),'Brands')]");
    private static final By Show_More_Option = By.xpath("//div[contains(text(),'Brands')]/following::button[1]");


    private static final By Paw_Patrol = By.xpath("//span[normalize-space()='Paw Patrol']");

    private static final By price = By.xpath("//span[normalize-space()='£15 - £29.99']");

    private static final By productCount = By.xpath("//span[contains(.,'Products found')]");

    private static final By Offers_Menu = By.xpath("//a[normalize-space()='Offers']");

    private static final By Product_List = By.xpath("//div[@id='hits']//ol");

    private static final By Product_Details = By.xpath("//div[@class='details']");



    public WebPage(WebDriver rdriver) {

        ld = rdriver;
        ld.manage().window().fullscreen();
        ld.findElement(Cookies_Btn).click();
        ld.findElement(Close_Btn).click();

    }


//    public void acceptCookies()
//    {
//        ld.findElement(Cookies_Btn).click();
//        ld.findElement(Close_Btn).click();
//
//    }

    public void searchInput(String input) {

        ld.findElement(Search_Bar).clear();

        ld.findElement(Search_Bar).sendKeys(input);
    }

    public void clickFirstOption() {
        ld.findElement(First_Item).click();
    }

    public void verifySearchProduct() {
        WebElement Item = ld.findElement(Search_Item);
        Assert.assertTrue(Item.getText().toLowerCase().contains("peppa"),"Mismatched");

    }

    public void clickShopByAge() {
        action = new Actions(ld);
        ld.manage().window().fullscreen();
        WebElement menu = ld.findElement(Shop_By_Age);
        action.moveToElement(menu).build().perform();
        ld.findElement(Category).click();

        action.scrollToElement(ld.findElement(Price_Option)).build().perform();
        ld.findElement(price).click();
        System.out.println("There are " + ld.findElement(productCount).getText());

    }

    public void clickOffers() {
        action = new Actions(ld);
        ld.manage().window().fullscreen();
        ld.findElement(Offers_Menu).click();
        action.scrollToElement(ld.findElement(Brands_Option)).build().perform();
        ld.findElement(Show_More_Option).click();
        String chosenBrand = ld.findElement(Paw_Patrol).getText();
        ld.findElement(Paw_Patrol).click();
        List<WebElement> productNames = ld.findElements(Product_List); // Change selector as needed

        // Verify each product contains the brand name
        for (WebElement product : productNames) {
            String productName = product.getText();
            Assert.assertTrue(productName.toLowerCase().contains(chosenBrand.toLowerCase()),
                    "Product does not belong to brand: " + productName);

        }


////div[@class='details']


    }
}


