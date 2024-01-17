package test.day08_iFrame_switcingWindows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.Set;

public class C03_KontrolsuzAcilanWindowaGecis extends TestBase {

    @Test
    public void kontrolsuzWindowsTesti() {
        //1- https://testotomasyonu.com/discount adresine gidin
        driver.get("https://testotomasyonu.com/discount");

        //2- Elektronics Products yazisinin gorunur olduğunu test edin
        WebElement elektronicsProductElementi = driver.findElement(By.xpath("(//iframe)[1]"));
        driver.switchTo().frame(elektronicsProductElementi);

        WebElement electronicYaziElementi = driver.findElement(By.xpath("//*[text()='Electronics Products']"));

        Assert.assertTrue(electronicYaziElementi.isDisplayed());

        //3- Dell bilgisayar urun isminin ‘DELL Core I3 11th Gen’ olduğunu test edin

        WebElement delBilgisayarYaziElementi = driver.findElement(By.xpath("//*[text()='DELL Core I3 11th Gen ']"));

        String expectedUrunIsmi = "DELL Core I3 11th Gen";
        String actualUrunIsmi = delBilgisayarYaziElementi.getText();

        Assert.assertEquals(expectedUrunIsmi, actualUrunIsmi);

        // click yaptıldığında, kontrolsüz olarak yeni bir tab açıldığından
        // driver yeni tab'a geçmez, eski window'da kalır
        // bu durumda ikinci sayfanın window handle değerini bulabilmek için
        // 3 adıma ihtiyacımız var

        //1. adım : ilk window'un WHD'ini kaydedelim
        String ilkSayfaninWHD = driver.getWindowHandle();

        //4- Dell bilgisayar’a tiklayip acilan sayfada urun fiyatinin $399.00 olduğunu test edin.

        delBilgisayarYaziElementi.click();

        // 2. adım :  click yapıldıktan sonra WHD değerini kaydettiğimiz ilk window'un yanına
        //            yeni bir tab açıld.
        //            getWindowHandles() kullanarak açık olan iki window'un
        //            WHD'lerini bir Set olarak kaydedelim

        Set<String> whDegerlerSeti = driver.getWindowHandles();

        // 3. adım : yeniSayfaninWindowHandleDegeri ve windowHandleDegeri'ni kullanarak
        //           ikinci Window'un WHD'ini bulup kaydedin

        String ikinciWindowWHD = "";
        for (String eachWHD : whDegerlerSeti
        ) {
            if (!eachWHD.equals(ilkSayfaninWHD)) {
                ikinciWindowWHD = eachWHD;
            }
        }

        driver.switchTo().window(ikinciWindowWHD);

        WebElement urunFiyatElementi = driver.findElement(By.id("priceproduct"));

        String expectedFiyat = "$399.00";
        String actualFiyat = urunFiyatElementi.getText();

        Assert.assertEquals(expectedFiyat, actualFiyat);

        //5- Ilk sayfaya donun ve "Here are some products." yazisinin gorunur olduğunu test edin
        driver.switchTo().window(ilkSayfaninWHD);

        WebElement hereAreYaziElementi = driver.findElement(By.xpath("//*[text()='Here are some products.']"));

        Assert.assertTrue(hereAreYaziElementi.isDisplayed());

        //6- Sayfayi kapatin
        ReusableMethods.waitFor(2);
    }

}
