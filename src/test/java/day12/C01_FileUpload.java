package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_FileUpload extends TestBase {

    //https://the-internet.herokuapp.com/upload adresine gidelim
    //chooseFile butonuna basalim
    //Yuklemek istediginiz dosyayi secelim.
    //Upload butonuna basalim.
    //“File Uploaded!” textinin goruntulendigini test edelim

    @Test
    public void test1(){
        driver.get("https://the-internet.herokuapp.com/upload");

        WebElement chooseFileButton = driver.findElement(By.id("file-upload"));

        String userHOME = System.getProperty("user.home");
        String dosyaYolu = userHOME+"/Downloads/logo.jpeg";

        chooseFileButton.sendKeys(dosyaYolu);
        waitFor(3);

        driver.findElement(By.id("file-submit")).click();

        String uploadSuccssesText = driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals("File Uploaded!", uploadSuccssesText);
    }

}
