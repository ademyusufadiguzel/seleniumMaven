package HomeWork.Abayram;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Abayram_HomeWork04 extends TestBase {

    //https://html.com/tags/iframe/ sayfasina gidelim
    //video’yu gorecek kadar asagi inin
    //videoyu izlemek icin Play tusuna basin
    //videoyu calistirdiginizi test edin

    @Test
    public void test1(){
        driver.get("https://html.com/tags/iframe/");

        WebElement idText = driver.findElement(By.id("Powerful_but_easy_to_misuse"));

        Actions actions = new Actions(driver);
        actions.moveToElement(idText).perform();

        WebElement iframe = driver.findElement(By.xpath("//iframe[@frameborder='0']"));
        driver.switchTo().frame(iframe);

        waitFor(2);
        driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']")).click();

        waitFor(5);
    }
}