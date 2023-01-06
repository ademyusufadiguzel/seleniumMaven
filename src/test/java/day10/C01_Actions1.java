package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Actions1 extends TestBase {

    //Class: Actions1
    //https://the-internet.herokuapp.com/context_menu  sitesine gidin
    //Kutuya sag tıklayın
    //Alert’te cikan yazinin “You selected a context menu” oldugunu
    //test edin
    //Tamam diyerek alert’i kapatın

    @Test
    public void rightClick(){
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //ACTION OBJESI OLUSTUR
        Actions actions = new Actions(driver);

        //ELEMENTI LOCATE ET
        WebElement boxClick = driver.findElement(By.id("hot-spot"));

        //ACTIONS OBJESI ILE LOCATE'E SAG TIK YAPTIK
        actions.contextClick(boxClick).perform();

        String alertText = driver.switchTo().alert().getText();
        Assert.assertEquals("You selected a context menu", alertText);
        waitFor(3);

        driver.switchTo().alert().accept();

    }
}
