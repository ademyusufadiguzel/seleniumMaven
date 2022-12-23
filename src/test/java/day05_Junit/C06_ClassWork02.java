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

public class C06_ClassWork02 {
    //"https://www.facebook.com" adresine git
    //"Create an Account" button'una basin
    //"radio buttons" elementlerini locate edin
    //Secili degilse cinsiyet butonundan size uygun olani secin
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public static void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void test() throws InterruptedException {
        driver.get("https://www.facebook.com");

        WebElement createAccountButton = driver.findElement(By.xpath("//*[text()='Create New Account']"));
        createAccountButton.click();
        Thread.sleep(2000);

        WebElement femaleButton = driver.findElement(By.cssSelector("input[value='1']"));
        WebElement maleButton = driver.findElement(By.cssSelector("input[value='2']"));
        WebElement customButton = driver.findElement(By.cssSelector("input[value='-1']"));
        Thread.sleep(3000);

        if (!maleButton.isSelected()){
            maleButton.click();
        }
    }
}


