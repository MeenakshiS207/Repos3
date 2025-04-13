package package1;

import PageObjectModel.WebPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class FiltersProductByBrand {

    @Test
    public void FilterByBrand() {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://www.elc.co.uk/");

        WebPage wp = new WebPage(driver);

        wp.clickOffers();

    }
}

