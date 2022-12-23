package HomeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HomeWork02 {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //"https://www.saucedemo.com" adresine gidin
        driver.get("https://www.saucedemo.com");

        //Username kutusuna "standard_user" yazdirin
        driver.findElement(By.cssSelector("input[id='user-name']")).sendKeys("standard_user");

        //Password kutusuna "secret_sauce" yazdirin
        driver.findElement(By.cssSelector("input[id='password']")).sendKeys("secret_sauce");

        //Login tusuna basin
        driver.findElement(By.cssSelector("input[id='login-button']")).click();
        Thread.sleep(2000);

        //Ilk urun ismini kaydedin ve bu urunun sayfasina gidin
        WebElement firstProduct = driver.findElement(By.xpath("(//*[@class='inventory_item_name'])[1]"));
        String str = firstProduct.getText();
        firstProduct.click();
        Thread.sleep(2000);

        //Add to Cart butonuna basin
        driver.findElement(By.cssSelector("button[id='add-to-cart-sauce-labs-backpack']")).click();
        Thread.sleep(1000);

        //Alisveris sepetine tiklayin
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        Thread.sleep(1000);

        //Sectiginiz urunun basarili olarak sepete eklendigini control edin
        String shoppingIsEmpty = driver.findElement(By.cssSelector("div[class='inventory_item_name']")).getText();

        if (shoppingIsEmpty.equals(str)){
            System.out.println("Shopping Test PASSED!");
        }else {
            System.out.println("Shopping Test FAILED!");
        }
        Thread.sleep(3000);

        //Sayfayi kapatin
        driver.close();
    }

}
