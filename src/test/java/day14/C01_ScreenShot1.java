package day14;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_ScreenShot1 extends TestBase {

    //Class : screenShot1
    //Techpro education a git ve Sayfanin goruntusunu al
    //-“QA” aramasi yap
    //Acilen sayfanin metnini test et ve ekran goruntusu al: “Search Results for: qa”


/*
    Seleniumda tum ekran goruntusu nasil alinir?
    -tum ekran goruntusu seleniumdan gelen getScreenShotAs metotu ile alinir.
    -getScreenshotAs metotu seleniumdaki TakeScreenshot api indan gelir.
*/
    @Test
    public void test1() throws IOException {
        driver.get("https://techproeducation.com/");

        driver.findElement(By.xpath("//input[@type='search']")).sendKeys("QA", Keys.ENTER);

        WebElement searchResultH1 = driver.findElement(By.tagName("h1"));
        Assert.assertTrue(searchResultH1.isDisplayed());


//      ----------       Kalip Yapilmasi Gerekenler      ----------
//      1.Ekran goruntusunu getScreenShotAs metotu ile alip File olarak olusturalim
        File scrnSht = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

//      2.Almis oldugum ekran goruntusunu belirledigim bir PATH e kaydet - dir= directory = dosya
        String currentDate = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir")+"/test-output/ScreenShots/"+currentDate+"image.png";
        File target = new File(path);

//      3.Goruntum ile dosyami birlestirip kaydet
        FileUtils.copyFile(scrnSht,target);

        //Onerilmez ama boylede kullanilabilir
//        FileUtils.copyFile(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE), new File(System.getProperty("user.dir")+"test-output/ScreenShots/image.png"));

//      Reusable yardimiyla ekran goruntusunu alalim
        takeScreenShotOfPage();

    }


}
