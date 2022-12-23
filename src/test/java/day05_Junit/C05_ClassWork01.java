package day05_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_ClassWork01 {
    //Verilen sayfaya gidin "https://the-internet.herokuapp.com/checkboxes"
    //Checkbox1 ve Checkbox2 elementlerini locate edin
    //Checkbox1 secili degilse onay kutusuna tiklayin
    //Checkbox2 secili degilse onay kutusuna tiklayin

    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterClass
    public static void tearDown(){
        driver.quit();
    }
    @Test
    public void test1() throws InterruptedException {
        driver.navigate().to("https://the-internet.herokuapp.com/checkboxes");
        Thread.sleep(3000);

        WebElement checkbox1 = driver.findElement(By.xpath("(//*[@type='checkbox'])[1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("(//*[@type='checkbox'])[2]"));

        if (!checkbox1.isSelected()){
            checkbox1.click();
            Thread.sleep(3000);
        }else if (!checkbox2.isSelected()){
            checkbox2.click();
            Thread.sleep(3000);
        }
    }
}
