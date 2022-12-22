package day04_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.dynalink.linker.LinkerServices;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C01_MavenFirstTest {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //https://www.amazon.com/ sayfasina gidelim
        driver.get("https://www.amazon.com/");

        //arama kutusunu locate edelim
        WebElement searchBox = driver.findElement(By.cssSelector("input[id='twotabsearchtextbox'"));

        //"Samsung headphones" ile arama yapalim
        searchBox.sendKeys("Samsung headphones", Keys.ENTER);

        //Bulunan sonuc sayisini yazdiralim
        WebElement searchResult = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        System.out.println("Arama sonucu = "+searchResult.getText());

        //Ilk urune tiklayalim
        driver.findElement(By.xpath("(//*[@class='s-image'])[1]")).click();

        //Sayfadaki tum basliklari yazdiralim
        List<WebElement> pageTitles = driver.findElements(By.xpath("//h1"));

        for (WebElement w : pageTitles){
            System.out.println(w.getText());
        }

        System.out.println("-".repeat(10)+"Lambda Kullanarak"+"-".repeat(10));

        pageTitles.stream().map(t -> t.getText()).forEach(System.out::println);

        //Sayfayi kapatalim
        driver.close();

    }

}
