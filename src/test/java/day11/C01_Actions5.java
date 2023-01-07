package day11;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Actions5 extends TestBase {

    //Create a class: Action5
    //Create a method keyboardActions
    //Google a gidin https://www.google.com
    //‘iPhone X fiyatlari’ yazdir (SHIFT TUSUNA BASILARAK)
    //‘ cok pahali!’ Yazdır (SHIFT TUSUNA BASILMAYARAK)
    //Ve ENTER tusuna bas

    @Test
    public void keyboardActionsTest(){
        driver.get("https://www.google.com");

        WebElement searchBox = driver.findElement(By.name("q"));
        Actions actions = new Actions(driver);

        actions.
                keyDown(searchBox,Keys.SHIFT).//arama kutusunun ustunde shift tusuna bas
                sendKeys("iphone x fiyatlari").//shifte basiliyken yazi yaz
                keyUp(searchBox,Keys.SHIFT).//shift'e artik basma
                sendKeys("  cok pahali!",Keys.ENTER).//normal halde yaz ve Enter tusuna bas
                build().//birden fazla actions methodu kullanildiginda build() kullanilmasi onerilir
                perform();


    }

}
