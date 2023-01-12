package day13;

public class C05_WebDriverException {

    //
/*
     --- WebDriverException ---
    -Driver versiyonlari ve browser versiyonlari ayni veya yakin olmadiginda alinir
    -Driver'i kapattiktan sonra tekrar kullanmak istediginiz durumlarda alinabilir.
    -Solution
    -Framework desiginin guzel kurulmus olmasi gerekir, ornegin Driver sinifinda birden fazla driver.quit() olmamali
    -Driver versiyonunun eski bir surum olmasindan kaynakli alinabilir.

     --- WebDriverException ---
    -When you close the browser, but still want to use that in correctly
    -When the versions of the driver and browsers are not compatible
    -Solution
    -Your design should be good. We should use singleton Driver to prevent this exception
    -Keep drivers up to date that is compatible with the  browser version
*/

}
