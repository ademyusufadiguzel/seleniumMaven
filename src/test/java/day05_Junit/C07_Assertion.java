package day05_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07_Assertion {
    static WebDriver driver;
    @BeforeClass
    public static void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.youtube.com");
        Thread.sleep(70000);
    }

    @AfterClass
    public static void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    /*
    1)https://www.youtube.com adresine gidin
    2)Asagidaki adlari kullanark 3 test methodu olusturun ve gerekli testleri yapin
        -title Test => Sayfa basliginin "YouTube" oldugunu testedin
        -image Test => YouTube resminin goruntulendigini (isDisplay()) testedin
        -Search Box'i erisilebilir oldugunu testedin (isEnabled())
        -wrongTitleTest => Sayfa basliginin "youtube" olmadigini dogrulayin
     */

    @Test
    public void titleTest(){
        String actualTitle = driver.getTitle();
        String expectedTitle = "YouTube";
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }

    @Test
    public void imageTest(){
        Assert.assertTrue(driver.findElement(By.xpath("(//*[@viewBox='0 0 90 20'])[2]")).isDisplayed());
    }

    @Test
    public void searchBoxTest(){
        Assert.assertTrue(driver.findElement(By.cssSelector("input[id='search'")).isEnabled());
    }

    @Test
    public void wrongTitleTest(){
        Assert.assertFalse(driver.getTitle().equals("youtube"));
    }

}
