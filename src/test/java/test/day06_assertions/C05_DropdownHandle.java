package test.day06_assertions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class C05_DropdownHandle extends TestBase {

    //  ● https://testotomasyonu.com/form adresine gidin.
    //    1.Dogum tarihi gun seçeneğinden index kullanarak 5’i secin
    //    2.Dogum tarihi ay seçeneğinden value kullanarak Nisan’i secin
    //    3.Dogum tarihi yil seçeneğinden visible text kullanarak 1990’i secin
    //    4.Secilen değerleri konsolda yazdirin
    //    5.Ay dropdown menüdeki tum değerleri(value) yazdırın
    //    6.Ay Dropdown menusunun boyutunun 13 olduğunu test edin

    @Test
    public void test() throws InterruptedException {
        driver.get("https://testotomasyonu.com/form");
        //    1.Dogum tarihi gun seçeneğinden index kullanarak 5’i secin
        WebElement gunDropdown = driver.findElement(By.xpath("(//select[@class='form-control'])[1]"));
        Select gunSelect = new Select(gunDropdown);
        gunSelect.selectByIndex(5);

        Thread.sleep(1000);

        //    2.Dogum tarihi ay seçeneğinden value kullanarak Nisan’i secin
        WebElement ayDropdown = driver.findElement(By.xpath("(//select[@class='form-control'])[2]"));
        Select aySelect = new Select(ayDropdown);
        aySelect.selectByValue("nisan");

        Thread.sleep(3000);

        //    3.Dogum tarihi yil seçeneğinden visible text kullanarak 1990’i secin
        WebElement yilDropdown = driver.findElement(By.xpath("(//select[@class='form-control'])[3]"));
        Select yilSelect = new Select(yilDropdown);
        yilSelect.selectByVisibleText("1990");

        Thread.sleep(3000);

        //    4.Secilen değerleri konsolda yazdirin
        System.out.println(gunSelect.getFirstSelectedOption().getText() + " " + aySelect.getFirstSelectedOption().getText() + " " + yilSelect.getFirstSelectedOption().getText());

        //    5.Ay dropdown menüdeki tum değerleri(value) yazdırın
        System.out.println(ayDropdown.getText());

        //    6.Ay Dropdown menusunun boyutunun 13 olduğunu test edin
        Assert.assertEquals(13, aySelect.getOptions().size());
    }
}
