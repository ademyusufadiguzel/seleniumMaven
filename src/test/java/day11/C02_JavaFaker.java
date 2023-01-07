package day11;

import com.github.javafaker.Faker;
import org.junit.Test;

public class C02_JavaFaker {

    @Test
    public void javaFakerTest(){
        //1.Faker objesi olustur
        Faker faker = new Faker();

        //2.Faker objesi ile fake data olustur
        String fName = faker.name().firstName();
        System.out.println(fName);

        String lName = faker.name().lastName();
        System.out.println(lName);

        String creditCardNumber = faker.business().creditCardNumber();
        System.out.println(creditCardNumber);

        String userName = faker.name().username();
        System.out.println(userName);

        String appName = faker.app().name();
        System.out.println(appName);

        String maltBeer = faker.beer().malt();
        System.out.println(maltBeer);

        System.out.println(faker.name().fullName());

        System.out.println(faker.gameOfThrones().character());

        System.out.println(faker.phoneNumber().phoneNumber());

        System.out.println(faker.superhero().name());

        System.out.println(faker.number().digits(15));

/*
    TEST DATA: kullanici adi , sifre, tel no, email, sehir, kredi kard no,...
    Test datalari kimden alinir?
    1.BA-Business analyst (Acceptance Criteria lari yazar)
    2.Test Lead
    3.Manual Tester
    4.Tech Lead & Team Lead & Dev Lead
    5.Developer
    6.Database
    7.API call lar
    8.Documantasyonlar. ORN: API swagger documani.
    9.Java Faker da fake data almak icin kullaniyoruz.
    NEREDEN GELMEZ : end user - kullanicidan, scrum master,
*/

    }

}
