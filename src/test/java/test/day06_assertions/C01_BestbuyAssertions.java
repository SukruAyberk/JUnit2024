package test.day06_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_BestbuyAssertions {

    // ○ https://www.bestbuy.com/ Adresine gidin
    // ○ farkli test method’lari olusturarak asagidaki testleri yapin
    // ○ Sayfa URL’inin https://www.bestbuy.com/ ’a esit oldugunu test edin
    // ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
    // ○ logoTest => BestBuy logosunun görüntülendigini test edin
    // ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin

    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void tearDown() {
        //driver.close();
    }

    @Test
    public void checkUrl() {
        driver.get("https://www.bestbuy.com/");
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.bestbuy.com/";
        Assert.assertEquals(expectedUrl, actualUrl);
    }

    @Test
    public void checkTitle() {
        driver.get("https://www.bestbuy.com/");
        String actualTitle = driver.getTitle();
        String expectedTitle = "Rest";
        Assert.assertFalse(actualTitle.contains(expectedTitle));
    }

    @Test
    public void isLogoVisible() {
        driver.get("https://www.bestbuy.com/");
        WebElement logo = driver.findElement(By.xpath("(//img[@alt='Best Buy Logo'])[1]"));
        Assert.assertTrue(logo.isDisplayed());
    }

    @Test
    public void checkFrenchLang() {
        driver.get("https://www.bestbuy.com/");
        WebElement french = driver.findElement(By.xpath("//*[text()='Français']"));
        Assert.assertTrue(french.isDisplayed());
    }


}
