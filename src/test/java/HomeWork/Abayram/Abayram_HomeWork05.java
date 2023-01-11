package HomeWork.Abayram;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Abayram_HomeWork05 extends TestBase {

    //Keyboard Base Actions
    //Homework
    //Yeni Class olusturun ActionsClassHomeWork
    //1- "http://webdriveruniversity.com/Actions" sayfasina gidin
    //2- Hover over Me First" kutusunun ustune gelin
    //Link 1" e tiklayin
    //Popup mesajini yazdirin
    //Popup'i tamam diyerek kapatin
    //“Click and hold" kutusuna basili tutun
    //7-“Click and hold" kutusunda cikan yaziyi yazdirin
    //8- “Double click me" butonunu cift tiklayin

    @Test
    public void test1(){
        driver.get("http://webdriveruniversity.com/Actions");
        Actions actions = new Actions(driver);

        WebElement hoverOver = driver.findElement(By.xpath("//div[@class='dropdown hover']//button[@class='dropbtn']"));
        actions.moveToElement(hoverOver).perform();
        waitFor(1);
        driver.findElement(By.linkText("Link 1")).click();

        String alertText = driver.switchTo().alert().getText();
        System.out.println(alertText);
        driver.switchTo().alert().accept();

        WebElement clickAndHold1 = driver.findElement(By.id("click-box"));
        actions.clickAndHold(clickAndHold1).perform();

        WebElement clickAndHold2 = driver.findElement(By.id("click-box"));
        String text = clickAndHold2.getText();
        System.out.println(text);

        WebElement doubleClickButton = driver.findElement(By.id("double-click"));
        actions.doubleClick(doubleClickButton).perform();
    }
}