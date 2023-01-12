package day13;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import utilities.TestBase;

public class C03_NullPointerException{

    WebDriver driver;
    Faker faker;
    @Test
    public void nullPointerExceptionTest(){
        faker = new Faker();
        System.out.println(faker.name().fullName());
    }

}
