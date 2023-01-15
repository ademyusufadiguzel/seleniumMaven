package day16;
import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class C01_ExcelRead {
    @Test
    public void readExcelTest() throws Exception {
//    WORKBOOK (EXCEL DOSYASI) > WORKSHEET/SHEET(SAYFA) >ROW (SATIR)> CELL(VERI HUCRESI)
        String path ="./src/test/java/resources/Capitals.xlsx";

//        String path =".\\src\\test\\java\\resources\\Capitals.xlsx";//WINDOWS
//        DOSYAYI AC
        FileInputStream fileInputStream = new FileInputStream(path);

//        EXCEL DOSYASINI AC /WORKBOOK AC
        Workbook workbook = WorkbookFactory.create(fileInputStream);

//        SAYFAYI AC / Sheet1
//        Sheet sheet1 = workbook.getSheetAt(0);//index 0 dan baslar. ilk sayfayi ac
        Sheet sheet1 = workbook.getSheet("Sheet1");// Sheet1 isimli sayfayi ac

//        ILK SATIRA GIT / Row
        Row row1 = sheet1.getRow(0);//ILK SATIRA GIT

//        INK SATIRDAKI ILK VERIYI AL
        Cell cell1 = row1.getCell(0);//ILK HUCREDEKI DATAYI VER

//        O VERIYI YAZDIR
        System.out.println(cell1);

//        1. SATIR 2. SUTUN
        Cell cell12 = sheet1.getRow(0).getCell(1);
        System.out.println(cell12);

//        3.Satir 1.Sutun yazdir ve o verinin France oldugunu test et
        String cell31 = sheet1.getRow(2).getCell(0).toString();
        System.out.println(cell31);
        Assert.assertEquals("France", cell31);

//        Exceldeki toplam satir sayisini bul
        int toplamSatirSayisi = sheet1.getLastRowNum()+1;//son satir numarasi.index 0 dan basliyor. sayma sayilari 1 oyuzden +1 yapiyoruz.
        System.out.println(toplamSatirSayisi);

//        Kullanilan toplam satir sayisini bul
        int toplamKullanilanSatirSayisi = sheet1.getPhysicalNumberOfRows();
        System.out.println(toplamKullanilanSatirSayisi);//1 den basliyor

//        COUNTRY, CAPITALS key ve valualari map a alip print et
        Map<String, String> ulkeBaskentleri = new HashMap<>();
        for (int i = 1; i < toplamSatirSayisi; i++) {
            ulkeBaskentleri.put(sheet1.getRow(i).getCell(0).toString(),sheet1.getRow(i).getCell(1).toString());
        }
        System.out.println(ulkeBaskentleri);

        Map<String,String> treeMap = new TreeMap<>(ulkeBaskentleri);
        System.out.println(treeMap);
















    }
}