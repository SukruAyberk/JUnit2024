package test.day07_jsAlerts_iFrame;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class C01_DropDownMenu extends TestBase {

    // 1. http://zero.webappsecurity.com/ Adresine gidin
    // 2. Sign in butonuna basin
    // 3. Login kutusuna “username” yazin
    // 4. Password kutusuna “password” yazin
    // 5. Sign in tusuna basin, back tusuna basarak sayfaya donun
    // 6. Online banking menusunden Pay Bills sayfasina gidin
    // 7. “Purchase Foreign Currency” tusuna basin
    // 8. “Currency” drop down menusunden Eurozone’u secin
    // 9. “amount” kutusuna bir sayi girin
    // 10. “US Dollars” in secilmedigini test edin
    // 11. “Selected currency” butonunu secin
    // 12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
    // 13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.

    @Test
    public void test01() {

        // 1. http://zero.webappsecurity.com/ Adresine gidin
        driver.get(" http://zero.webappsecurity.com/");
        // 2. Sign in butonuna basin
        WebElement singInButton = driver.findElement(By.xpath("//i[@class='icon-signin']"));
        singInButton.click();
        // 3. Login kutusuna “username” yazin
        WebElement loginTextBox = driver.findElement(By.xpath("//input[@id='user_login']"));
        loginTextBox.sendKeys("username");
        // 4. Password kutusuna “password” yazin
        WebElement passwordTextBox = driver.findElement(By.xpath("//input[@id='user_password']"));
        passwordTextBox.sendKeys("password");
        // 5. Sign in tusuna basin, back tusuna basarak sayfaya donun
        WebElement signInButton2 = driver.findElement(By.xpath("//input[@value='Sign in']"));
        signInButton2.click();
        // 6. Online banking menusunden Pay Bills sayfasina gidin
        WebElement onlineBankingButton = driver.findElement(By.xpath("//li[@id='onlineBankingMenu']"));
        onlineBankingButton.click();
        WebElement payBillsButton = driver.findElement(By.xpath("//span[@id='pay_bills_link']"));
        payBillsButton.click();
        // 7. “Purchase Foreign Currency” tusuna basin
        WebElement purchaseForeignCurrencyButton = driver.findElement(By.xpath("//*[text()='Purchase Foreign Currency']"));
        purchaseForeignCurrencyButton.click();
        // 8. “Currency” drop down menusunden Eurozone’u secin
        WebElement currencyDDM = driver.findElement(By.xpath("//select[@id='pc_currency']"));
        Select select = new Select(currencyDDM);
        select.selectByVisibleText("Eurozone (euro)");
        // 9. “amount” kutusuna bir sayi girin
        WebElement amountTextBox = driver.findElement(By.xpath("//input[@id='pc_amount']"));
        amountTextBox.sendKeys("54");
        // 10. “US Dollars” in secilmedigini test edin
        WebElement usDollarRadioButton = driver.findElement(By.id("pc_inDollars_true"));
        Assert.assertFalse(usDollarRadioButton.isSelected());
        // 11. “Selected currency” butonunu secin
        WebElement selectedCurrencyRadioButton = driver.findElement(By.id("pc_inDollars_false"));
        selectedCurrencyRadioButton.click();
        // 12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        WebElement calculateCostsButton = driver.findElement(By.id("pc_calculate_costs"));
        calculateCostsButton.click();
        WebElement purchaseButton = driver.findElement(By.id("purchase_cash"));
        purchaseButton.click();
        // 13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.
        String expectedMessage = "Foreign currency cash was successfully purchased.";
        String actualMessage = driver.findElement(By.xpath("//*[text()='Foreign currency cash was successfully purchased.']")).getText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

}
