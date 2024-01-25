package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ReusableMethods {

    public static void waitFor(int saniye){
        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<String> strToList(List<WebElement> webElementList){

        List<String> stringList = new ArrayList<>();

        for (WebElement eachElement : webElementList
            ){

            stringList.add(eachElement.getText());
        }
        return stringList;
    }

    static public void titleWindowDegistir(String hedefTitle, WebDriver driver){

        Set<String> whdSeti = driver.getWindowHandles();

        for (String eachWhd : whdSeti
        ){
            driver.switchTo().window(eachWhd);
            String oldugumuzWindowTitle = driver.getTitle();
            if (oldugumuzWindowTitle.equals(hedefTitle)){
                break;
            }
        }
    }
}
