package test.day13_ExcelOtomasyon;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C04_GetScreenShot extends TestBase {

    @Test
    public void test01() throws IOException {
        // Test otomasyon anasayfasına gidin
        driver.get("https://testotomasyonu.com");

        //nutella için arama yapın
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("nutella" + Keys.ENTER);

        // arama sonucunda ürün bulunamadığını test edin
        WebElement aramaSonucuElementi = driver.findElement(By.xpath("//*[@*='product-count-text']"));

        String expectedSonucYazisi = "0 Products Found";
        String actualSonucYazisi = aramaSonucuElementi.getText();

        Assert.assertEquals(expectedSonucYazisi,actualSonucYazisi);

        // testlerimiz sırasında istersek tüm sayfanın
        // istersen bir web elementin görüntüsünü kaydedebiliriz


        ReusableMethods.waitFor(1);
        // Eğer tüm sayfa screenShot almak isterseniz

        // 1- bir TakesScrenShoot objesi oluşturun ve değer alarak driver'i atayin

        TakesScreenshot tss = (TakesScreenshot) driver;

        // 2- screenShot'ı kaydedeceğimiz bir dosya oluşturalım

        File kursScreenShot = new File("target/kursScreenShots/screenShot.jpeg");

        // 3- tss objesini kullanarak screenShot alın ve bir file olarak kaydedin

        File geciciDosya = tss.getScreenshotAs(OutputType.FILE);

        // 4- geçiçi dosyayı değer olarak asıl kaydedilecek File'a kopyalayın

        FileUtils.copyFile(geciciDosya,kursScreenShot);

        ReusableMethods.waitFor(2);
    }
}
