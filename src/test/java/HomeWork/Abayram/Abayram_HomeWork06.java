package HomeWork.Abayram;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class Abayram_HomeWork06 extends TestBase {

    //Faker Kutuphanesi HOMEWORK
    //Faker class’i testlerimizi yaparken ihtiyav duydugumuz isim, soyisim, adres vb bilgiler icin fake
    //degerler uretmemize imkan tanir.
    //Faker degerler uretmek icin Faker class’indan bir obje uretir ve var olan method’lari kullaniriz.
    //"https://facebook.com"  Adresine gidin
    //“create new account”  butonuna basin
    //“firstName” giris kutusuna bir isim yazin
    //“surname” giris kutusuna bir soyisim yazin
    //“email” giris kutusuna bir email yazin
    //“email” onay kutusuna emaili tekrar yazin
    //Bir sifre girin
    //Tarih icin gun secin
    //Tarih icin ay secin
    //Tarih icin yil secin
    //Cinsiyeti secin
    //Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
    //Sayfayi kapatin


    @Test
    public void test1(){
        driver.get("https://facebook.com");
        Faker faker = new Faker();

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String emailAddress = faker.internet().emailAddress();
        String password = faker.internet().password(10, 12, true,true,true);

        System.out.println(faker.leagueOfLegends().champion());

        driver.findElement(By.xpath("//a[.='Create New Account']")).click();

        driver.findElement(By.name("firstname")).sendKeys(firstName);
        driver.findElement(By.name("lastname")).sendKeys(lastName);
        driver.findElement(By.name("reg_email__")).sendKeys(emailAddress);
        driver.findElement(By.name("reg_passwd__")).sendKeys(password);

        WebElement day = driver.findElement(By.name("birthday_day"));
        Select select1 = new Select(day);
        select1.selectByValue("5");

        WebElement month = driver.findElement(By.name("birthday_month"));
        Select select2 = new Select(month);
        select2.selectByVisibleText("Oct");

        WebElement year = driver.findElement(By.name("birthday_year"));
        Select select3 = new Select(year);
        select3.selectByVisibleText("2000");

        driver.findElement(By.xpath("//input[@value='2']")).click();

        WebElement female = driver.findElement(By.xpath("//input[@value='1']"));
        WebElement male = driver.findElement(By.xpath("//input[@value='2']"));
        WebElement other = driver.findElement(By.xpath("//input[@value='-1']"));

        Assert.assertFalse(female.isSelected());
        Assert.assertFalse(other.isSelected());
        Assert.assertTrue(male.isSelected());
    }
}