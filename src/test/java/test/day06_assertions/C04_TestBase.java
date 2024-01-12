package test.day06_assertions;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

public class C04_TestBase extends TestBase {

    //test otomasyonu sayfasına git "https://testotomasyonu.com/form"
    //syafaya gittiğini test et

    @Test
    public void test() throws InterruptedException {
        driver.get("https://testotomasyonu.com/form");
        Thread.sleep(1000);
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://testotomasyonu.com/form";
        Assert.assertEquals(expectedUrl, actualUrl);
    }

}
