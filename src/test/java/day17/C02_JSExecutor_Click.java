package day17;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import utilities.TestBase;

public class C02_JSExecutor_Click extends TestBase {

    //clickByJSTest
    //Techpro education ana sayfasina git
    //LMS LOGIN elementine tikla
    //Cikan sayfayinin URL inin “https://lms.techproeducation.com/” oldugunu test et

    @Test
    public void jsExecutorClickTest(){
        driver.get("https://www.techproeducation.com/");

        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("arguments[0].click();", element);

        clickByJS(driver.findElement(By.partialLinkText("LMS LOGIN")));
        waitFor(3);

        Assert.assertEquals("https://lms.techproeducation.com/", driver.getCurrentUrl());


    }

}
