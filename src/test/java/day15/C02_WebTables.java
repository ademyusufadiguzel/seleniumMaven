package day15;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C02_WebTables extends TestBase {

    //https://the-internet.herokuapp.com/tables
    //Create a class: WebTables
    //Task 1 : Table1’i print edin
    //Task 2 : 3. Row’ datalarını print edin
    //Task 3 : Son row daki dataları print edin
    //Task 4 : 5. Column datalarini print edin
    //Task 5 : Iki parametreli bir Java metot oluşturalım: printData
    //Parameter 1 = row numarasi
    //Parameter 2 = column numarasi
    //printData(2,3);  => 2nd row, 3rd column daki datayı print etsin

    @Before
    public void setUp(){
        driver.get("https://the-internet.herokuapp.com/tables");
    }

    @Test
    public void table1Print(){
        String table1 = driver.findElement(By.id("table1")).getText();
        System.out.println(table1);

        List<WebElement> tumVeriler = driver.findElements(By.xpath("//table[@id='table1']//td"));
        tumVeriler.forEach(t -> System.out.println(t.getText()));
    }

    @Test
    public void row3Print(){
        List<WebElement> elements = driver.findElements(By.xpath("(//tbody//tr)[3]//td"));
        for (WebElement w: elements){
            System.out.println(w.getText());
        }
    }

    @Test
    public void endRowPrint(){
        List<WebElement> elements = driver.findElements(By.xpath("(//tbody//tr)[4]//td"));
        elements.forEach(t -> System.out.println(t.getText()));
    }

    @Test
    public void column5Print(){
        List<WebElement> elements = driver.findElements(By.xpath("//table[@id='table1']//tr//td[5]"));
        elements.forEach(t -> System.out.println(t.getText()));
    }

}
