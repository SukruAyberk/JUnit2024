package test.day08_iFrame_switcingWindows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C01_iFrame extends TestBase {

    @Test
    public void iFrameTesti() {

        //1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get(" https://the-internet.herokuapp.com/iframe");

        // 2 ) Bir metod olusturun: iframeTest
        // - “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda yazdirin.

        WebElement anIframeYaziElementi = driver.findElement(By.xpath("//[text() ='An iFrame containing the TinyMCE WYSIWYG Editor']"));

        Assert.assertTrue(anIframeYaziElementi.isEnabled());


        // - Text Box’a “Merhaba Dunya!” yazin.
        //textBox iframe içinde olduğundan önce iframe'e geçiş yapmalıyız

        WebElement iFrameElementi = driver.findElement(By.xpath("//[@id='mce_0_ifr']"));
        driver.switchTo().frame(iFrameElementi);

        WebElement textBoxElementi = driver.findElement(By.xpath("//[@id='tinymce']"));
        ReusableMethods.waitFor(1);
        textBoxElementi.clear();
        textBoxElementi.sendKeys("Merhaba Dunya!");

        // - TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu dogrulayin ve  konsolda yazdirin.
        driver.switchTo().defaultContent();
        WebElement elementalSeleniumElementi = driver.findElement(By.xpath("//[text()='Elemental Selenium']"));

        Assert.assertTrue(elementalSeleniumElementi.isDisplayed());
        System.out.println(elementalSeleniumElementi.getText());

        ReusableMethods.waitFor(1);
    }
}


