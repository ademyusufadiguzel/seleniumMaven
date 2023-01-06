package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_Actions2 extends TestBase {

    //Class: Actions2
    //Method : hoverOver() and test the following scenario:
    //Amazon a gidelim https://www.amazon.com/
    //Sag ust bolumde bulunan “Account & Lists” menüsüne git
    //“Account” secenegine tikka
    //Acilan sayfanin Title in “Your Account” icerdigini dogrula

    @Test
    public void hoverOverTest(){
        driver.get("https://www.amazon.com/");
        Actions actions = new Actions(driver);

        WebElement accountListBox = driver.findElement(By.id("nav-link-accountList"));
        actions.moveToElement(accountListBox).perform();
        WebElement accountEl = driver.findElement(By.xpath("//*[text()='Account']"));
        accountEl.click();
        waitFor(5);

        String accountPageTitle = driver.getTitle();
        Assert.assertEquals("Your Account", accountPageTitle);
    }
}
