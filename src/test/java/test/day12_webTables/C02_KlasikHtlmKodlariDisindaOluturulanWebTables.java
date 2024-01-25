package test.day12_webTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.List;

public class C02_KlasikHtlmKodlariDisindaOluturulanWebTables extends TestBase {

    @Test
    public void test01(){
        // (//*[@role='trow'])/ *[@role='tdata']

        //1. “https://testotomasyonu.com/webtables2” sayfasina gidin
        driver.get("https://testotomasyonu.com/webtables2");

        // 2. Headers da bulunan basliklari yazdirin
        WebElement baslikElementi = driver.findElement(By.xpath("(//*[@role='hrow'])"));

        System.out.println(baslikElementi.getText());

        // 3. 3.sutunun basligini yazdirin
        WebElement ucuncuSutunBaslikElementi = driver.findElement(By.xpath("(//*[@role='hdata'])[3]"));

        System.out.println(ucuncuSutunBaslikElementi.getText());

        // 4. Tablodaki tum datalari yazdirin
        List<WebElement> tabloDataElementleri = driver.findElements(By.xpath("(//*[@role='tdata'])"));

        System.out.println(ReusableMethods.strToList(tabloDataElementleri));

        // 5. Tabloda kac tane cell (data) oldugunu yazdirin
        System.out.println("Tablodaki cell sayisi : " + tabloDataElementleri.size());

        // 6. Tablodaki satir sayisini yazdirin
        List<WebElement> satirElementleriList = driver.findElements(By.xpath("(//*[@role='trow'])"));

        System.out.println("Tablodaki satir sayisi : " + satirElementleriList.size());

        // 7. Tablodaki sutun sayisini yazdirin
        List<WebElement> ikinciSatirDataElementleriList = driver.findElements(By.xpath("(//*[@role='trow'])[2]/ *[@role='tdata']"));

        System.out.println("Tablodaki sutun sayisi : " + ikinciSatirDataElementleriList.size());

        // 8. Tablodaki 3.kolonu yazdirin
        List<WebElement> ucuncuSutunElementlerList = driver.findElements(By.xpath("(//*[@role='trow'])/ *[@role='tdata'][3]"));

        System.out.println(ReusableMethods.strToList(ucuncuSutunElementlerList));

        // 9. Tabloda ” Category” si Furniture olan urunun fiyatini yazdirin

        // category : (//*[@role='trow'])[5]/ *[@role='tdata'][2]
        // fiyat : (//*[@role='trow'])[5]/ *[@role='tdata'][3]

        for (int i = 1; i < satirElementleriList.size(); i++) {

            String dinamikCategoryXpath = "(//*[@role='trow'])[" + i + "]/ *[@role='tdata'][2]";
            String dinamikFiyatXpath = "(//*[@role='trow'])[" + i + "]/ *[@role='tdata'][3]";

            WebElement satirdakiCategoryElementi = driver.findElement(By.xpath(dinamikCategoryXpath));
            WebElement satirdakiFiyatElementi = driver.findElement(By.xpath(dinamikFiyatXpath));

            if (satirdakiCategoryElementi.getText().equalsIgnoreCase("Furniture")){
                System.out.println(satirdakiFiyatElementi.getText());
            }
        }
        //10. Bir method olusturun, Test sayfasindan satir ve sutun verildiginde datayi yazdirsin
        datayiYazdir(3,3); // Istenen hücredeki data : $399.00

        datayiYazdir(2,2); // Istenen hücredeki data : Electronics

        ReusableMethods.waitFor(2);
    }

    public void datayiYazdir(int satirNo, int sutunNo){

        // "(//*[@role='trow'])[" 3 "]/ *[@role='tdata'][2]"

        String dinamikXpath = "(//*[@role='trow'])[" + satirNo + "]/ *[@role='tdata'][" + sutunNo + "]";

        WebElement istenenHucreElementi = driver.findElement(By.xpath(dinamikXpath));

        System.out.println("Istenen hücredeki data : " + istenenHucreElementi.getText());
    }
}
