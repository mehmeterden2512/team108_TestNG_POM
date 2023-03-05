package tests.practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class HotelMyCampFrameWork extends TestBaseRapor {
    @Test
    public void hotelMyCampTesti() {
        extentTest=extentReports.createTest("hotelMyCampTesti","login buttonu tıklanacak bilgiler girilecek login OLUNAMAYACAK");
        Driver.getDriver().get(ConfigReader.getProperty("hotelMyCampUrl"));
        extentTest.info("hotelMyCamp sitesine Url uzerinden gidildi");
        HotelMyCampPage hotelMyCampPage=new HotelMyCampPage();
        hotelMyCampPage.ilkLoginButtonu.click();
        extentTest.info("ilk login buttonuna click yapıldı");
        hotelMyCampPage.usernameKutusu.sendKeys(ConfigReader.getProperty("hotelMycampUsername"));
        extentTest.info("username kutusuna username gonderildi");
        hotelMyCampPage.passwordKutusu.sendKeys(ConfigReader.getProperty("hotelMycampPassword"));
        extentTest.info("password kutusuna password gonderildi");
        hotelMyCampPage.ikinciLoginButtonu.click();
        extentTest.info("username ve password girildikten sonra login buttona clik yapıldı");

        Assert.assertFalse(!hotelMyCampPage.basarizGirisSonucYaziElementi.isDisplayed());
        extentTest.pass("beklentim giris yapılamamasi");

    }
}
