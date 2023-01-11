package HomeWork.Abayram;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class Abayram_HomeWork03 extends TestBase {

    //Test01 :  1- amazon gidin
    //Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
    //dropdown menude 40 eleman olduğunu doğrulayın


    //Test02
    //dropdown menuden elektronik bölümü seçin
    //arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
    //sonuc sayisi bildiren yazinin iphone icerdigini test edin
    //ikinci ürüne relative locater kullanarak tıklayin
    //ürünün title'ni ve fiyatını variable’a  assign edip ürünü sepete ekleyelim


    //Test03
    //yeni bir sekme açarak amazon anasayfaya gidin
    //dropdown’dan bebek bölümüne secin
    //bebek puset aratıp bulundan sonuç sayısını yazdırın
    //sonuç yazsının puset içerdiğini test edin
    //5-üçüncü ürüne relative locater kullanarak tıklayin
    //6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin  Test 4
    //1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın




    @Test
    public void test1(){
        driver.get("https://www.amazon.com/");
        WebElement dropdown = driver.findElement(By.xpath("//select[@aria-describedby='searchDropdownDescription']"));
        Select option = new Select(dropdown);
        List<WebElement> dropdownList = option.getOptions();
        for (WebElement w : dropdownList){
            System.out.println(w.getText());
        }

        int dropdownSize = dropdownList.size();
        Assert.assertFalse(dropdownSize==40);

        option.selectByVisibleText("Electronics");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

        String []searchResult = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText().split(" ");
        System.out.println("Bulunan sonuc sayisi = "+searchResult[3]);

        String searchResultForIphone = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
        Assert.assertTrue(searchResultForIphone.contains("iphone"));

        driver.findElement(By.xpath("//div[@class='s-main-slot s-result-list s-search-results sg-row']//div[@data-index='2']")).click();
        String productTitle = driver.findElement(By.id("productTitle")).getText();
        String productPrice = driver.findElement(By.xpath("//div[@class='a-section a-spacing-none aok-align-center']//span[@class='a-offscreen']")).getText();

        waitFor(2);

        driver.findElement(By.id("add-to-cart-button")).click();

        driver.switchTo().newWindow(WindowType.TAB);

        driver.get("https://www.amazon.com/");
        WebElement dropdown2 = driver.findElement(By.xpath("//select[@aria-describedby='searchDropdownDescription']"));
        Select select2 = new Select(dropdown2);

        select2.selectByVisibleText("Baby");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("bebek puset", Keys.ENTER);
        String []searchResult2 = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText().split(" ");
        System.out.println("Bulunan sonuc sayisi = "+searchResult2[3]);

        String searchResultForPuset = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
        Assert.assertTrue(searchResultForPuset.contains("puset"));
        waitFor(5);
        WebElement searchClick = driver.findElement(By.xpath("//span[@class='rush-component s-latency-cf-section']//div[@data-index='3']//div[@class='sg-col-inner']//h2"));

        Actions actions = new Actions(driver);
        actions.click(searchClick).perform();

        waitFor(3);
//        String productTitle2 = driver.findElement(By.id("productTitle")).getText();
//        String productPrice2 = driver.findElement(By.xpath("//div[@class='a-section a-spacing-none aok-align-center']//span[@class='a-offscreen']")).getText();
//
//        driver.findElement(By.id("add-to-cart-button")).click();
        waitFor(3);


    //                   FAIL  -  TEKRAR DENE


    }

}
