package HomeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HomeWork05 {
    static WebDriver driver;

    /* Given kullanici "https://editor.datatables.net/" sayfasina gider
    Then new butonuna basar
    And editor firstname kutusuna "<firstName>" bilgileri girer
    And editor lastname kutusuna "<lastName>" bilgileri girer
    And editor position kutusuna "<position>" bilgileri girer
    And editor office kutusuna "<office>" bilgileri girer
    And editor extension kutusuna "<extension>" bilgileri girer
    And editor startdate kutusuna "<startDate>" bilgileri girer
    And editor salary kutusuna "<salary>" bilgileri girer
    When Create tusuna basar
    Then Kullanıcının eklendiğini doğrular.
    And Eklediği kullanıcı kaydını siler
    Then Kullanıcinin silindiğini doğrular.
    */

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://editor.datatables.net/");
    }

    @Test
    public void test1() throws InterruptedException {
        driver.findElement(By.cssSelector("button[class='dt-button buttons-create']")).click();
        WebElement kullanici = driver.findElement(By.cssSelector("input[id='DTE_Field_first_name']"));
        kullanici.sendKeys("Adem Yusuf");
        driver.findElement(By.cssSelector("input[id='DTE_Field_last_name']")).sendKeys("Adiguzel");
        driver.findElement(By.cssSelector("input[id='DTE_Field_position']")).sendKeys("Software Engineer");
        driver.findElement(By.cssSelector("input[id='DTE_Field_office']")).sendKeys("Seattle");
        driver.findElement(By.cssSelector("input[id='DTE_Field_extn']")).sendKeys("Lawsted");
        driver.findElement(By.cssSelector("input[id='DTE_Field_start_date']")).sendKeys("2022-10-25");
        driver.findElement(By.cssSelector("input[id='DTE_Field_salary']")).sendKeys("95000");
        Thread.sleep(3000);
    }

    @Test
    public void test2() throws InterruptedException {
        driver.findElement(By.cssSelector("button[class='btn']")).click();
        Thread.sleep(2000);

        WebElement kullaniciDogrulama = driver.findElement(By.xpath("//*[text()='Adem Yusuf Adiguzel']"));
        Assert.assertTrue(kullaniciDogrulama.isDisplayed());
        Thread.sleep(2000);

        kullaniciDogrulama.click();
        driver.findElement(By.cssSelector("button[class='dt-button buttons-selected buttons-remove']")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("button[class='btn']")).click();

        WebElement kullaniciDogrulama2 = driver.findElement(By.xpath("//*[text()='Adem Yusuf Adiguzel']"));
        Assert.assertNotNull(kullaniciDogrulama2.isDisplayed());

    }






}
