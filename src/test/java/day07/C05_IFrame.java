package day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C05_IFrame extends TestBase {

    @Test
    public void test1(){
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");
        //Ana sayfadaki 'An iframe with a thin black border' metinin 'black border' yazisinin oldugunu test edelim
        String actualText = driver.findElement(By.xpath("//*[text()='An iframe with a thin black border:']")).getText();
        String expectedText = "black border";
        Assert.assertTrue(actualText.contains(expectedText));
        //Ayrica 'Applications lists' yazisinin sayfada oldugunu test edelim
        WebElement iFrame = driver.findElement(By.xpath("//iframe[@src=\"/index.php\"]"));
        WebElement actualIFrameInToTheText = driver.switchTo().frame(iFrame).findElement(By.xpath("//h1[@class='display-5 fw-bold']"));
        Assert.assertTrue(actualIFrameInToTheText.isDisplayed());
        //Son olarak footer daki 'Povered By' yazisinin varligini test edelim
        WebElement actualParentFrame = driver.switchTo().parentFrame().findElement(By.xpath("//p[text()='Povered By']"));
        Assert.assertTrue(actualParentFrame.isDisplayed());

    }


}
