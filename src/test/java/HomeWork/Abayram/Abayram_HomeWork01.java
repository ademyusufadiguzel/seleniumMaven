package HomeWork.Abayram;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.AcceptedW3CCapabilityKeys;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class Abayram_HomeWork01 extends TestBase {

    /*
        Bir class olusturun: IframeOdev
        https://the-internet.herokuapp.com/iframe  sitesine gidiniz
        sayfadaki toplam iframe sayısını bulunuz.
        Sayfa basliginda ‘Editor’ yazını içerdiğini test edelim.
        Paragrafdaki yaziyi silelim
        Sonrasinda paragrafa “iframein icindeyim” yazisini yazdıralım
        Alt kısımdaki yazının ‘Elemental Selenium’ yazisini içerdiğini test edelim
     */

    @Test
    public void test1() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/iframe");
        WebElement iframeCount = driver.findElement(By.xpath("//iframe"));
        System.out.println(iframeCount);

        String pageText = driver.findElement(By.xpath("//h3[.='An iFrame containing the TinyMCE WYSIWYG Editor']")).getText();
        Assert.assertTrue(pageText.contains("Editor"));

        WebElement iframe = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframe).findElement(By.xpath("//body[@data-id='mce_0']")).sendKeys(Keys.END,Keys.LEFT_SHIFT,Keys.HOME,Keys.DELETE,Keys.LEFT_SHIFT,"iframein icindeyim");

        driver.switchTo().parentFrame();

        String pageDowntext = driver.findElement(By.xpath("//div[@style='text-align: center;']")).getText();
        String expected = "Elemental Selenium";
        Assert.assertTrue(pageDowntext.contains(expected));

    }

}
