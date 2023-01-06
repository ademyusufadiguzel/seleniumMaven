package day10;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;

public class C03_Actions3 extends TestBase {

    //Method : scrollUpDown()
    //https://techproeducation.com a git
    //Sayfanin altına doğru gidelim
    //Sonra sayfanın üstüne doğru gidelim

    @Test
    public void scrollUpDownTest(){
        driver.get("https://techproeducation.com");
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        waitFor(3);
        actions.sendKeys(Keys.PAGE_UP).perform();
        waitFor(3);

    }
}
