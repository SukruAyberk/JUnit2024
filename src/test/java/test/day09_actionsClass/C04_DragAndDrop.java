package test.day09_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C04_DragAndDrop extends TestBase {
    @Test
    public void test01(){

        //1- https://testotomasyonu.com/droppable adresine gidelim
        driver.get("https://testotomasyonu.com/droppable");

        //2- Accept bolumunde “Acceptable” butonunu tutup “Drop Here” kutusunun ustune birakalim

        Actions actions = new Actions(driver);

        WebElement acceptButonu = driver.findElement(By.id("draggable2"));
        WebElement dropHereElementi = driver.findElement(By.id("droppable2"));

        ReusableMethods.waitFor(1);

        actions.dragAndDrop(acceptButonu,dropHereElementi).perform();

        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        String expectedYaziButonu = "Dropped!";
        String actualYazi = dropHereElementi.getText();

        Assert.assertEquals(expectedYaziButonu,actualYazi);

        //4- Sayfayi yenileyin
        driver.navigate().refresh();

        //5- “Not Acceptable” butonunu tutup “Drop Here” kutusunun ustune birakalim

        Actions actions1 = new Actions(driver);

        WebElement nonAcceptButonu = driver.findElement(By.id("draggable-nonvalid2"));
        dropHereElementi = driver.findElement(By.id("droppable2"));

        ReusableMethods.waitFor(1);

        actions1.dragAndDrop(nonAcceptButonu,dropHereElementi).perform();

        //6- “Drop Here” yazisinin degismedigini test edin
        dropHereElementi = driver.findElement(By.id("droppable2"));

        expectedYaziButonu = "Dropped!";
        actualYazi = dropHereElementi.getText();

        Assert.assertNotEquals(expectedYaziButonu,actualYazi);

        ReusableMethods.waitFor(2);
    }
}
