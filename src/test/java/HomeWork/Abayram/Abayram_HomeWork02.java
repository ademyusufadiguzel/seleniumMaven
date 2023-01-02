package HomeWork.Abayram;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class Abayram_HomeWork02 extends TestBase {

    /*
        https://testcenter.techproeducation.com/index.php?page=multiple-windows
        Title in ‘Windows’ oldugunu test edin
        Click here a tiklayin
        Sonra açılan sayfadaki title in ‘New Window’ oldugunu dogrulayin
     */

    @Test
    public void test1(){
        driver.get("https://testcenter.techproeducation.com/index.php?page=multiple-windows");

        String parentWindow = driver.getWindowHandle();

        String pageTitle = driver.getTitle();
        Assert.assertEquals("Windows", pageTitle);

        driver.findElement(By.xpath("//a[@href='index.php?page=new-windows']")).click();

        Set<String> windows = driver.getWindowHandles();

        for (String w: windows){

            if (!w.equals(parentWindow)){
                driver.switchTo().window(w);
                break;
            }
        }

        String childTitle = driver.getTitle();
        Assert.assertEquals("New Window", childTitle);


    }


}
