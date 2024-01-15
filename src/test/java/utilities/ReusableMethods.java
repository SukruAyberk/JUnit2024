package utilities;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ReusableMethods {

    public static void waitFor(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static List<String> strToList(List<WebElement> webElementList) {
        List<String> strList = new ArrayList<>();
        for (WebElement each : webElementList) {
            strList.add(each.getText());
        }
        return strList;
    }

}
