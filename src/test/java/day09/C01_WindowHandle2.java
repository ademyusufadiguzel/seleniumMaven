package day09;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C01_WindowHandle2 extends TestBase {

    //        https://the-internet.herokuapp.com/windows adresine gidin.
    //        Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
    //        Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
    //        Click Here butonuna basın.
    //        Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
    @Test
    public void test1() {
        driver.get("https://the-internet.herokuapp.com/windows");
        String w1 = driver.getWindowHandle();

        String text = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("Opening a new window", text);
        String pageTitle = driver.getTitle();
        Assert.assertEquals("The Internet", pageTitle);

        driver.findElement(By.xpath("//a[@target='_blank']")).click();
        TestBase.waitFor(2);
        TestBase.switchToWindow(2);
        String w2Title = driver.getTitle();
        Assert.assertEquals("New Window", w2Title);
    }

}
