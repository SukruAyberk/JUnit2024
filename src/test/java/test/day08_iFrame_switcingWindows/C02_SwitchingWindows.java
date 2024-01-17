package test.day08_iFrame_switcingWindows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C02_SwitchingWindows extends TestBase {

    @Test
    public void yeniWindowsTesti(){

        /*
            Bir sayfada test yaparken
            driver.switchT().newWindow(.....) kullandığımızda
            yeni window'u driver'a oluşturtduğumuz için
            driver otomatik olarak yeni sayfaya geçer

            driver yeni window'a geçtikten sonra
            eski window'lardan birine dönmesi istenecekse
            dönülecek window'da iken o sayfanın windowHandleDegerini alıp kaydetmeliyiz

            driver.switchTo().window(kaydedilenWindowHandleDegeri) ile
            o sayfaya dönebiliriz
         */

        //● testotomasyonu anasayfa adresine gidin.
        driver.get("https://testotomasyonu.com");

        //● Sayfa’nin window handle degerini String bir degiskene atayin
        String toWindowHandleDegeri = driver.getWindowHandle();

        //● Sayfa title’nin “Otomasyon” icerdigini test edin
        String expectedTitle = "Otomasyon";
        String actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitle));

        //● Yeni bir tab olusturup, acilan tab’da wisequarter.com adresine gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://wisequarter.com");

        //● Sayfa title’nin “wisequarter” icerdigini test edin
        expectedTitle = "Wise Quarter";
        actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitle));
        ReusableMethods.waitFor(2);

        //● Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://walmart.com");

        //● Sayfa title’nin “Walmart” icerdigini test edin

        expectedTitle = "Walmart";
        actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitle));

        //● Ilk acilan sayfaya donun ve testotomasyonu sayfasina dondugunuzu test edin
        driver.switchTo().window(toWindowHandleDegeri);

        expectedTitle = "Otomasyon";
        actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitle));
        ReusableMethods.waitFor(2);
    }

}
