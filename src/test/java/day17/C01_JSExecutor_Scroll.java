package day17;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.IOException;

public class C01_JSExecutor_Scroll extends TestBase {

    //scrollIntoViewTest metotu olustur
    //Techpro education ana sayfasina git
    //We Offer elementi gorunur olacak sekilde uzerine scroll et ve ekran gorunturunu al
    //Ayni sayfada Enroll Free elementi gorunur olacak sekilde scroll et ve ekran goruntusunu al
    //Ayni sayfada WHY US? elementi gorunur olacak sekilde scroll et ve ekran goruntusunu al
    //Ayni sayfada tekrar Enroll Free elementi gorunur olacak sekilde scroll et ve ekran goruntusunu al

    @Test
    public void jsExecutorScrollTest() throws IOException {
        driver.get("https://www.techproeducation.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement weOffer = driver.findElement(By.xpath("//span[.='we offer']"));
        js.executeScript("arguments[0].scrollIntoView(true);", weOffer);
        takeScreenShotOfPage();
        waitFor(1);

        WebElement enrollFreeButton = driver.findElement(By.xpath("(//li[@class='elementor-icon-list-item'])[7]"));
        scrollIntoViewJS(enrollFreeButton);
        takeScreenShotOfPage();
        waitFor(1);

        scrollIntoViewJS(driver.findElement(By.xpath("//h3[.='WHY US?']")));
        takeScreenShotOfPage();
        waitFor(1);

        scrollIntoViewJS(driver.findElement(By.xpath("(//li[@class='elementor-icon-list-item'])[7]")));
        takeScreenShotOfPage();
        waitFor(2);

        //En Uste cik
        scrollTopJS();
        waitFor(1);

        //En Alta git
        scrollEndJS();

        waitFor(5);
    }
}