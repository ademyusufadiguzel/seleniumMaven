package day13;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_StaleElementRefranceException extends TestBase {

    @Test
    public void staleElementRefranceExceptionTest1(){
        driver.get("https://techproeducation.com/");
//      LMS LOGIN linkine tikle ve o sayfanin URL inin lms icerdigini test et
        WebElement lmsLoginLink = driver.findElement(By.linkText("LMS LOGIN"));
        lmsLoginLink.click();//LMS e git
        Assert.assertTrue(driver.getCurrentUrl().contains("lms"));//URL in lms kelimesinin icerdigini test et
        waitFor(3);

//      Tekrar ana sayfaya gel ve LMS LOFIN sayfasina gir
        driver.navigate().back();//tekrar ana sayfaya gittik

        lmsLoginLink.click();

    }

    @Test
    public void staleElementRefranceExceptionTest2(){
        driver.get("https://techproeducation.com/");
        waitFor(3);
        WebElement lmsLoginLink = driver.findElement(By.linkText("LMS LOGIN"));
        waitFor(3);
        driver.navigate().refresh();
        waitFor(3);
        //Sayfa yenilenmeden once buldugum elementi sayfa yenilendikten sonra kullanmak istedim
        lmsLoginLink.click();//org.openqa.selenium.StaleElementReferenceException

        //Cozum eski (Stale Element) elementi tekrar locate et
        //driver.findElement(By.linkText("LMS LOGIN")).click();


    }


}
