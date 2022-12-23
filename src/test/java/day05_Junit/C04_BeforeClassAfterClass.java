package day05_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_BeforeClassAfterClass {
    /*
    @BeforeClass ve @AfterClass notasyolari sadece static method'lar icin calisir
    @BeforeClass ve @AfterClass kullanirsak olusturdugumuz @Test method'larinin hepsini ayni anda calistirip
    en son @AfterClass'i calistiririz
        Ama sadece @Before ve @After kullanirsak her test icin @Before ve @After'i kullaniriz.
     */

    @BeforeClass
    public static void setUp(){
        System.out.println("Butun Testlerden once calisti");
    }

    @AfterClass
    public static void tearDown(){
        System.out.println("Butun Testlerden sonra calisti");
    }
    @Before
    public void setup01() {
        System.out.println("Her Test'ten once calisir");
    }
    @After
    public void tearDown01() {
        System.out.println("Her Test'ten sonra calisir");
    }
    @Test
    public void test01(){
        System.out.println("Ilk Test");
    }

    @Test
    public void test02(){
        System.out.println("Ikinci Test");
    }
    @Test
    @Ignore("Tamamlanmamis Test")
    public void test03() {
        System.out.println("Ucuncu Test");
    }

}
