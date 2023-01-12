package day13;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;
import java.time.Duration;
public class C02_TimeOutException extends TestBase {
    /*
    TimeOutException explicit wait kullandigimda ve locator bulunamadiginda alirim
     */
    @Test
    public void timeOutExceptionTest() {
        driver.get("https://techproeducation.com");
//        Explicit wait icin olusturdugumuz method'lardan birini kullanalim.
//        Parametre 1: Beklemek istedigim element, Parametre 2: Beklenecek Max sure
//        waitForVisibility(driver.findElement(By.xpath("//input[@type='searchh']")),15);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Yanlis ID")));//org.openqa.selenium.TimeoutException:
    }
/*
    TimeOutException explicit wait kullanıldığı zaman ve element bulunamadığında alınan bir hatadır.
    Şimdiye kadar karşılaşmamızın nedeni sadece implicit wait kullanmış olmamızdır.
    Explicit wait ve yanlış locatar kullandığımız zaman TimeOutException alırız.
    Explicit wait var, doğru locatar kullandık ama süre yeterli olmadığı durumlarda TimeOutException alırız.
    Explicit wait var, doğru locatar kullandık, süre yeterli ama iframe var TimeOutException alırız.
*/
}