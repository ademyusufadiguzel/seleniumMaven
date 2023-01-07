package day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileDownloadTest extends TestBase {

    //https://testcenter.techproeducation.com/index.php?page=file-download   adresine gidelim.
    //b10 all test cases dosyasını indirelim
    //Dosyanın başarıyla indirilip indirilmediğini test edelim

    @Test
    public void fileDownloadTest(){
        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");

        driver.findElement(By.partialLinkText("b10 all test cases, code.docx")).click();
        waitFor(3);

        String filePath = System.getProperty("user.home")+"/Downloads/b10 all test cases, code.docx";
        boolean downloaded = Files.exists(Paths.get(filePath));
        Assert.assertTrue(downloaded);

    }

}
