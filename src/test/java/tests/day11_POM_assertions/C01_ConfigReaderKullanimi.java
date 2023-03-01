package tests.day11_POM_assertions;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_ConfigReaderKullanimi {
    @Test
    public void test01(){
        /*kendi notum:
        proje seviyesinde new+file+configration.properties isimli bir dosya ekledik
         bu dosya bizim test datalarimizi daha
        dinamik olarak update ve set etmemizi saglayan ****.properties**** uzantılı bir java dosyasidir.
        daha sonra burdakii dosyalari her seferinde okumak icin utilities page altında ConfigReader isimli bir class
        olusturduk bizim ihtiyacimiz olan test datasini okumasi için class uzerinden ConfigReader.getProperty("amazonUrl") gibi
        cagiri yapmamiz bize gerekli data yi ihtiyac duydugumuz yerde getirecektir.
         */
        //amazon anasayfaya gidelim
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        //Nutella icin arama yapalim
        //Test datasi olarak verilen kelime icin arama yapalim
        AmazonPage amazonPage=new AmazonPage();
        amazonPage.aramaKutusu.sendKeys(ConfigReader.getProperty("amazonAranacakKelime")+ Keys.ENTER);

        //arama sonuclarının Nutella icerdigini test edelim
        String expectedIcerik=ConfigReader.getProperty("amazonAranacakKelime");
        String actualAramaSonucYazisi=amazonPage.aramaSonucElementi.getText();

        Assert.assertTrue(actualAramaSonucYazisi.contains(expectedIcerik));

        Driver.closeDriver();
    }
}
