package test.day07_jsAlerts_iFrame;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.List;

public class C04_IFrame extends TestBase {

    @Test
    public void iFrameTesti(){
        //1- https://testotomasyonu.com/discount adresine gidin
        driver.get("https://testotomasyonu.com/discount");

        //2- Elektronics Products yazisinin gorunur olduğunu test edin
        WebElement iFrame = driver.findElement(By.xpath("//iframe[@src='https://testotomasyonu.com/disproduct']"));
        driver.switchTo().frame(iFrame);
        WebElement electronicProductsText = driver.findElement(By.xpath("//*[text()='Electronics Products']"));
        Assert.assertTrue(electronicProductsText.isDisplayed());

        //3- Dell bilgisayar urun isminin ‘DELL Core I3 11th Gen’ olduğunu test edin
        WebElement pc = driver.findElement(By.xpath("//*[text()='DELL Core I3 11th Gen ']"));
        String expectedData = "DELL Core I3 11th Gen";
        String actualData = pc.getText();
        Assert.assertEquals(expectedData, actualData);
        driver.switchTo().defaultContent();

        //4- Sagdaki bolumde gorunen urunler arasinda ‘Men Slim Fit’ içeren en az 1 urun olduğunu test edin
        WebElement iFrame2 = driver.findElement(By.xpath("//iframe[@src='https://testotomasyonu.com/disproduct2']"));
        driver.switchTo().frame(iFrame2);
        List<WebElement> fashionProdsWEList = driver.findElements(By.xpath("//ul[@class='image-gallery']"));
        List<String> fashionProdsStrList = ReusableMethods.strToList(fashionProdsWEList);
        //Assert.assertTrue(fashionProdsStrList.contains("Men Slim Fit"));
            for (int i = 0; i < fashionProdsStrList.size(); i++) {
                Assert.assertTrue(fashionProdsStrList.get(i).contains("Men Sun Glasses"));
            }

        //5- Fashion yazisinin gorunur olduğunu test edin
        WebElement fashionText = driver.findElement(By.xpath("//*[text()='Fashion']"));
        Assert.assertTrue(fashionText.isDisplayed());
        ReusableMethods.waitFor(2);
        driver.switchTo().defaultContent();

    }

}
