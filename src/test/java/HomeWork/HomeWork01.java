package HomeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.css.model.Value;

import java.time.Duration;

public class HomeWork01 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //https://www.google.com/ adresine gidin
        driver.navigate().to("https://www.google.com/");

        //Sayfa basliginin "Google" ifadesi icerdigini test edin
        String actualTitle = driver.getTitle();
        String expectedTitle = "Google";
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Title Test PASSED!");
        } else {
            System.out.println("Title Test FAILED!");
        }

        //Arama cubuguna "Nutella" yazip aratin
        driver.findElement(By.cssSelector("input[class='gLFyf']")).sendKeys("Nutella", Keys.ENTER);

        //Bulunan sonuc sayisini yazdirin
        WebElement searchResult = driver.findElement(By.xpath("//*[@id='result-stats']"));
        String searchResultOfString = searchResult.getText().replaceAll("[^0-9\\p{Punct}]", "").substring(0, 11);
        String searchResultOfString2 = searchResultOfString.replaceAll("[^0-9]", "");
        System.out.println("Bulunan sonuc sayisi = " + searchResultOfString);

        //Sonuc sayisinin 10 milyon'dan fazla oldugunu test edin
        int searchResultOfInteger = Integer.parseInt(searchResultOfString2);//String alinan degeri int cevirdik!!!
        if (searchResultOfInteger > 10000000) {
            System.out.println("Counter Test PASSED!");
        } else {
            System.out.println("Counter Test FAILED!");
        }

        //Sayfayi kapatin
        driver.close();

    }

}
