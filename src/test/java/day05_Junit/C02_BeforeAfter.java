package day05_Junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C02_BeforeAfter {
    @Before
    public void setup(){
        System.out.println("Her Test Methodundan once calisir");
    }
    @After
    public void tearDown(){
        System.out.println("Her Test Methodundan sonra calisir");
    }
    @Test
    public void test1(){
        System.out.println("Ilk Test");
    }
    @Test
    public void test2(){
        System.out.println("Ikinci Test");
    }

}
