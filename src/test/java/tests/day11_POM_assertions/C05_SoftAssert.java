package tests.day11_POM_assertions;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C05_SoftAssert {
    @Test
    public void amazonTesti(){
        /*
       Genel olarak
            test edin denirse hard assert
            dogrulayin(verify) denirse soft assert kasdedilir
         */
        //amazon anasayfaya gidip ,dogru sayfaya gittiğimizi dogrulayin(VERİFY)
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        String expectedIcerik="amazon";

        String actualUrl=Driver.getDriver().getCurrentUrl();

        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(actualUrl.contains(expectedIcerik),"dogru anasayfa testi");
        //Nutella icin arama yapip ,sonuclarin nutella icerdiğini dogrulayin
        AmazonPage amazonPage=new AmazonPage();
        amazonPage.aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

         expectedIcerik="Nutella";
        String actualAramaSonucYazisi=amazonPage.aramaSonucElementi.getText();
        softAssert.assertTrue(actualAramaSonucYazisi.contains(expectedIcerik),"Nutella icermiyor testi");
        //ilk urune tıklayip,urun isminde Nutella gectiğini dogrulayin
        amazonPage.ilkUrun.click();

        expectedIcerik="Nutella";
        String actualIlkUrunIsim=amazonPage.ilkUrunIsim.getText();

        softAssert.assertTrue(actualIlkUrunIsim.contains(expectedIcerik));

        softAssert.assertAll();
        Driver.closeDriver();
    }
}
