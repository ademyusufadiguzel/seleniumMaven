package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C01_Dropdown {
    static WebDriver driver;

    //Eger test sinifinda birden fazla method olusturdugumzda @Before kullanilir
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void selectByIndexTest(){
        //Given kullanici https://testcenter.techproeducation.com/index.php?page=dropdown sayfasindayken
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");

        WebElement year = driver.findElement(By.cssSelector("select[id='year']"));
        WebElement month = driver.findElement(By.cssSelector("select[id='month']"));
        WebElement day = driver.findElement(By.cssSelector("select[id='day']"));
        Select optionYear = new Select(year);
        Select optionMonth = new Select(month);
        Select optionDay = new Select(day);

        optionYear.selectByValue("2005");
        optionMonth.selectByIndex(9);
        optionDay.selectByIndex(4);

        /*
        1. What is dropdown? Dropdown nedir?
        2.
         */



    }


}
