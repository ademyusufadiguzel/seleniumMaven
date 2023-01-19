package HomeWork.Abayram;

import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import utilities.TestBase;

public class HomeWork08 extends TestBase {

    //	1)getValueTest metotu olustur
    //	2)https://www.priceline.com/ a git
    //	3)Tarih kısmındaki Yazili metinleri al ve yazdır

    @Test
    public void getValueTest(){
        driver.get("https://www.priceline.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].getAttribute('value')");
    }

}
