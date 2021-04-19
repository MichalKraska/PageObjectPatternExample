package pl.coderslab.pageobjectpatternexample.test;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.coderslab.pageobjectpatternexample.pageobject.MyStorePage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.assertNotEquals;

public class MyStoreProductSearchTest {
    private WebDriver driver;
    private MyStorePage myStorePage;

    @Before
    public void before(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.get("https://prod-kurs.coderslab.pl/index.php");
        this.myStorePage = new MyStorePage(this.driver);
    }

    @Test
    public void shouldSearchOnlyProductsContainingSearchQuery() throws IOException {
        this.myStorePage.searchCatalog("Mug");
        TakesScreenshot screenshot = (TakesScreenshot)driver;
//Saving the screenshot in desired location
        File source = screenshot.getScreenshotAs(OutputType.FILE);
//Path to the location to save screenshot
        Files.copy(source.toPath(), Paths.get("path", "to", "your", "Screenshot.png"));

        List<String> displayedProductsNames = this.myStorePage.getDisplayedProductsNames();
        assertNotEquals(0, displayedProductsNames.size());
    }
}
