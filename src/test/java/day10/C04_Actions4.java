package day10;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_Actions4 extends TestBase {

    //Class: Action4
    //Method: dragAndDropTest
    //Given user is on https://jqueryui.com/droppable/
    //And user moves the target element(Drag me to my target) in to  destination(Drop here)

    @Test
    public void dragAndDropTest(){
        driver.get("https://jqueryui.com/droppable/");
        Actions actions = new Actions(driver);

//      KAYNAK VE HEDEF ELEMENTLERI IFRAMEIN ICINDE
        driver.switchTo().frame(0);

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));

//      dragAndDrop() surukleme islemini gerceklestirir
        actions.dragAndDrop(source, target).perform();
        waitFor(5);
    }

    @Test
    public void clickAndHoldTest(){

        driver.get("https://jqueryui.com/droppable/");
        Actions actions = new Actions(driver);

//      KAYNAK VE HEDEF ELEMENTLERI IFRAMEIN ICINDE
        driver.switchTo().frame(0);

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));

//      dragAndDrop() surukleme islemini gerceklestirir
        actions
                .clickAndHold(source)//kaynagi tut
                .moveToElement(target)//hedefe koy
                .release()
                .build()//onceki methodlarin iliskisini kur/guclendir. KULLANILMASI TERCIH EDILIR.
                .perform();//islemi gerceklestirir.

    }

    @Test
    public void moveByOffSetTest(){
        driver.get("https://jqueryui.com/droppable/");
        Actions actions = new Actions(driver);

//      KAYNAK VE HEDEF ELEMENTLERI IFRAMEIN ICINDE
        driver.switchTo().frame(0);

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));

//      dragAndDrop() surukleme islemini gerceklestirir
        actions.moveByOffset(385, 1).release().build().perform();
        waitFor(5);
    }
}