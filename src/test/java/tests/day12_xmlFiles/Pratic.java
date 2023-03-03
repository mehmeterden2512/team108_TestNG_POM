package tests.day12_xmlFiles;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class Pratic extends TestBaseRapor {
    @Test
    public void amazonTesti(){
        extentTest=extentReports.createTest("amazonTesti","amazon anasayfa testi");
        // amazon sayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        extentTest.info("amazon anasayfaya gidildi");
        // Test datasi olarak verolen kelime icin arama yapin
        AmazonPage amazonPage=new AmazonPage();
        amazonPage.aramaKutusu.sendKeys(ConfigReader.getProperty("amazonAranacakKelime")+ Keys.ENTER);
        extentTest.info("Kelime başarıyla bulundu");
        // arama sonuclarinin arattigimiz test datasini icerdigini test edelim
        String expectedIcerik=ConfigReader.getProperty("amazonAranacakKelime");
        String actualKelime=amazonPage.aramaSonucElementi.getText();
        Assert.assertTrue(actualKelime.contains(expectedIcerik));
        extentTest.pass("Başarıyla görüntülendi");

    }

}
