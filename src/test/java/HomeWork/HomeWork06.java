package HomeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HomeWork06 {
    static WebDriver driver;

     /*
    1-https://books-pwakit.appspot.com/ adresine gidin.
    2-"BOOKS" başlığının görünür olduğunu doğrulayın
    3-Arama çubuğunda "Selenium" u aratın.
    4-Arama sonuçlarındaki ilk ürün isminin "Selenium" içerdiğini doğrulayın.
    */

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test(){
        driver.get("https://books-pwakit.appspot.com/");
        WebElement bookText = driver.findElement(By.xpath("//*[.='BOOKS']"));
        Assert.assertTrue(bookText.isDisplayed());

    }



}
