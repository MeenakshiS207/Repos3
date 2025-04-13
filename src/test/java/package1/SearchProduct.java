package package1;

import PageObjectModel.WebPage;
import Utils.ExcelUtils;
import dataproviders.SearchDataProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class SearchProduct {

    @Test(dataProviderClass = SearchDataProvider.class,dataProvider = "search")
    public void SearchTest(String searchQuery) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().fullscreen();
        driver.get("https://www.elc.co.uk/");




        System.out.println("Input from Excel: " + searchQuery);

        WebPage wp = new WebPage(driver);
//        wp.acceptCookies();
        wp.searchInput(searchQuery);
        wp.clickFirstOption();
        wp.verifySearchProduct();


    }



}


