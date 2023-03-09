package tests.day12_xmlFiles;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QdPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class C03_RaporluPozitifLoginTesti extends TestBaseRapor {
    @Test
    public void pozitifLoginTesti(){
        extentTest=extentReports.createTest("PozitifLoginTesti","gecerli bilgilerle giris yapilabilmeli");
        //qd ana sayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));

        extentTest.info("Qalitiy demy anasayfaya gdildi");

        // login linkine tiklayin
        QdPage qdPage=new QdPage();
        qdPage.ilkloginLinki.click();
        extentTest.info("ilk login linkine tiklandi");
        //gecerli kullanici adi ve password ile giris yapin
        qdPage.cookiesKabulButonu.click();
        qdPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliUsername"));
        extentTest.info("gecerli email yazildi");
        qdPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));
        extentTest.info("gecerli password");

        ReusableMethods.bekle(3);


        qdPage.loginButonu.click();

        //basarili bir sekilde giris yapıldıgını test edin

        Assert.assertTrue(qdPage.basariliGirisElementi.isDisplayed());
        extentTest.pass("basarılı giriş yapaıldı");


    }
}
