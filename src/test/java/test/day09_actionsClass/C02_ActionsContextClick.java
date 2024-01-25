package test.day09_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C02_ActionsContextClick extends TestBase {

    @Test
    public void test01(){
        //1- https://testotomasyonu.com/click sitesine gidin
        driver.get("https://testotomasyonu.com/click");

        //2- “DGI Drones” uzerinde sag click yapin
        // 1.adım actions objesi oluşturalım
        Actions actions = new Actions(driver);
        //2. adım kullanacağımız webElementi locate edip kaydedelim
        WebElement dgiDronesElementi = driver.findElement(By.id("pic2_thumb"));
        //3. adım actions objesi ve kaydettiğimiz webElement ile
        //  istenen action'ı gerçekleştirelim
        ReusableMethods.waitFor(1);
        actions.contextClick(dgiDronesElementi).perform();
        ReusableMethods.waitFor(2);
        //3- Alert’te cikan yazinin “Tebrikler!... Sağ click yaptınız.” oldugunu test edin.

        String expectedAlertYazisi = "Tebrikler!... Sağ click yaptınız.";
        String actualAlertYazisi = driver.switchTo().alert().getText();

        Assert.assertEquals(expectedAlertYazisi,actualAlertYazisi);

        //4- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();

        ReusableMethods.waitFor(2);
    }

}
