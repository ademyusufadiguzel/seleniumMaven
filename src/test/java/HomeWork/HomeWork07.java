package HomeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class HomeWork07 {


    /*
    1-https://rahulshettyacademy.com/AutomationPractice/ adresine gidin
    2-Dropdown Example menüsünün görünür olduğunu doğrulayın.
    3-Option3 ü seçin.
    4-Option3 ün seçili olduğunu doğrulayın.
    */
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test1() {
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        WebElement dropdownDisable = driver.findElement(By.xpath("//*[text()='Dropdown Example']"));
        Assert.assertTrue(dropdownDisable.isDisplayed());

        WebElement dropdown = driver.findElement(By.id("dropdown-class-example"));
        Select option = new Select(dropdown);
        option.selectByVisibleText("Option3");

        WebElement o3 = driver.findElement(By.xpath("//*[text()='Option3']"));
        Assert.assertTrue(o3.isSelected());

    }


}
