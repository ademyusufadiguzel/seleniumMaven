package day08;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.AbstractSet;
import java.util.Set;

public class C01_WIndowHandle1 extends TestBase {

    /*
        Tests package’inda yeni bir class olusturun: WindowHandle
        https://the-internet.herokuapp.com/windows adresine gidin.
        Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        Click Here butonuna basın.
        Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        Sayfadaki textin “New Window” olduğunu doğrulayın.
        Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu  doğrulayın.
     */

    @Test
    public void test1() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/windows");
        String window1Handle = driver.getWindowHandle();
        String actualPageText = driver.findElement(By.xpath("//div[@class='example']")).getText();
        String expectedPageText = "Opening a new window";
        Assert.assertTrue(actualPageText.contains(expectedPageText));

        String actualTitle = driver.getTitle();
        String expectedTitle = "The Internet";
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        driver.findElement(By.xpath("//a[@href='/windows/new']")).click();
        Thread.sleep(2000);

        Set<String> allWindowHadles = driver.getWindowHandles();

        for (String w : allWindowHadles) {
            if (!w.equals(window1Handle)) {
                driver.switchTo().window(w);
                break;
            }
        }

        String actualWindow2Title = driver.getTitle();
        String expectedWindow2Title = "New Window";
        Assert.assertTrue(actualWindow2Title.contains(expectedWindow2Title));

        String actualWindow2Text = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("New Window", actualWindow2Text);

        String window2Handle = driver.getWindowHandle();

        Thread.sleep(2000);

        driver.switchTo().window(window1Handle);

        String actualWindow1Title = driver.getTitle();
        Assert.assertEquals("The Internet", actualWindow1Title);

        Thread.sleep(5000);

    }
}
