package HomeWork;

import org.junit.Test;
import org.openqa.selenium.By;
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
    public void test1(){
        driver.get("https://the-internet.herokuapp.com/iframe");
        driver.findElements(By.tagName("iframe"));


    }


}
