package test.day07_jsAlerts_iFrame;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C02_JSAlerts extends TestBase {

    @Test
    public void test01() {
        //1. Test
        // - https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");
        // - 1.alert’e tiklayin
        WebElement alertButton = driver.findElement(By.xpath("//*[text()='Click for JS Alert']"));
        alertButton.click();
        // - Alert’deki yazinin “I am a JS Alert” oldugunu test edin
        String actulAlertMessage = driver.switchTo().alert().getText();
        String expectedAlertMessage = "I am a JS Alert";
        Assert.assertEquals(expectedAlertMessage, actulAlertMessage);
        // - OK tusuna basip alert’i kapatin
        driver.switchTo().alert().accept();
    }

    @Test
    public void test02() {
        //2.Test
        // - https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");
        // - 2.alert’e tiklayalim
        WebElement alertButton = driver.findElement(By.xpath("//*[text()='Click for JS Confirm']"));
        alertButton.click();
        // - Cancel’a basip, cikan sonuc yazisinin “You clicked: Cancel” oldugunu test edin
        driver.switchTo().alert().dismiss();
        String expectedMessage = "You clicked: Cancel";
        String actualMessage = driver.findElement(By.xpath("//*[text()='You clicked: Cancel']")).getText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void test03() {
        //3.Test
        // - https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");
        // - 3.alert’e tiklayalim
        WebElement alertButton = driver.findElement(By.xpath("//*[text()='Click for JS Prompt']"));
        alertButton.click();
        // - Cikan prompt ekranina “Abdullah” yazdiralim
        String expectedData = "Abdullah";
        driver.switchTo().alert().sendKeys(expectedData);
        // - OK tusuna basarak alert’i kapatalim
        driver.switchTo().alert().accept();
        // - Cikan sonuc yazisinin Abdullah icerdigini test edelim
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement result = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='You entered: Abdullah']")));
        String actualData = result.getText();
        Assert.assertTrue(actualData.contains(expectedData));
    }

}
