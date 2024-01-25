package test.day13_ExcelOtomasyon;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class C02_ReadExcel {

    @Test
    public void test01() throws IOException {
        String dosyaYolu = "src/test/java/tests/day13_ExcelOtomasyon/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sayfa1 = workbook.getSheet("sayfa1");

        //- 1.satirdaki 2.hucreye gidelim ve yazdiralim
        System.out.println(sayfa1.getRow(0).getCell(1)); // Başket (İngilizce)

        // - 1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
        String istenenHucre = sayfa1.getRow(0).getCell(1).toString();
        System.out.println(istenenHucre);

        // - 2.satir 4.cell’in afganistan’in baskenti oldugunu test edelim
        String expectedHucreDegeri = "Kabil";
        String actualHucreDegeri = sayfa1.getRow(1).getCell(3).toString();

        Assert.assertEquals(expectedHucreDegeri,actualHucreDegeri);

        // - Satir sayisini bulalim
        System.out.println(sayfa1.getLastRowNum()); // 190 son satırın index'ini verdi

        Sheet sayfa2 = workbook.getSheet("Sayfa2");

        System.out.println(sayfa2.getPhysicalNumberOfRows()); // 21 bos satırlari saymaz
        System.out.println(sayfa2.getLastRowNum()); // 30 son kullanılan satirin indexi

        //System.out.println(sayfa2.getRow(45).getCell(20)); // NullPointerException
        // workbook excel dosyasinda kullanılan son satırdan sonrasını almaz
        // o satırlara ulaşmak isterseniz NullPointerException verir

        // System.out.println(sayfa2.getRow(11).getCell(4)); // NullPointerException
        System.out.println(sayfa2.getRow(0).getCell(2)); // null

        // - Fiziki olarak kullanilan satir sayisini bulun
        //System.out.println(sayfa1.getPhysicalNumberOfRows());

        // - Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim

        // Excel'de ingilizce ülke ismi poland'ın olduğunu test edin
        boolean polandVarMi = false;
        for (int i = 0; i <sayfa1.getLastRowNum() ; i++) {

            String satirdakiIngilizceUlkeIsmi =  sayfa1.getRow(i).getCell(0).toString();

            if (satirdakiIngilizceUlkeIsmi.equalsIgnoreCase("poland")){
                polandVarMi = true;
            }
        }

        Assert.assertTrue(polandVarMi);

        // Excel'de ingilizce ismi samoa olan ülkenin, başkent isminin apia olduğunu test edin
        for (int i = 0; i < sayfa1.getLastRowNum(); i++) {

            String satirdakiUlkeIsmi = sayfa1.getRow(i).getCell(0).toString();
            String satirdakiBaskentIsmi = sayfa1.getRow(i).getCell(1).toString();

            if (satirdakiUlkeIsmi.equalsIgnoreCase("Samoa")){
                Assert.assertEquals("Apia",satirdakiBaskentIsmi);
            }
        }

        // Bu iki testi Map kullanarak ta yapalım
        // bunun için önce ingilizce ülke isimleri ve başkentleri bir map yapalım

        Map<String, String> ulkelerVeBasketler = new TreeMap<>();

        for (int i = 0; i < sayfa1.getLastRowNum(); i++) {

            String satirdakiUlkeIsmi = sayfa1.getRow(i).getCell(0).toString();
            String satirdakiBaskentIsmi = sayfa1.getRow(i).getCell(1).toString();

            ulkelerVeBasketler.put(satirdakiUlkeIsmi,satirdakiBaskentIsmi);
        }

        // Excel'de ingilizce ismi samoa olan ülkenin, başkent isminin apia olduğunu test edin

        Assert.assertTrue(ulkelerVeBasketler.containsKey("Poland"));

        // Excel'de ingilizce ülke ismi poland'ın olduğunu test edin

        Assert.assertEquals("Apia",ulkelerVeBasketler.get("Samoa"));

    }
}
