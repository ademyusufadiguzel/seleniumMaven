package day09;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C02_WindowHandle3 extends TestBase {

    @Test
    public void newWindowHandleTest(){

        //1. TechPro education sayfasinin titleini "Techpro Education" metnini icerdigini test edin
        //2. Yeni bir pencerede Amazon sayfasini acip titleinin "Amazon" metnini icerdigini test edin
        //3. Yeni bir pencerede linkedin sayfasini acip titleinin "LinkedIn" metnini icerdigini test edin

        driver.get("https://techproeducation.com");
        String w1Title = driver.getTitle();
        String expectedTitle1 = "Techpro Education";
        Assert.assertTrue(w1Title.contains(expectedTitle1));

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.amazon.com/");
        String w2Title = driver.getTitle();
        String expectedTitle2 = "Amazon";
        Assert.assertTrue(w2Title.contains(expectedTitle2));

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.linkedin.com/");
        String w3Title = driver.getTitle();
        String expectedTitle3 = "LinkedIn";
        Assert.assertTrue(w3Title.contains(expectedTitle3));
    }
}
