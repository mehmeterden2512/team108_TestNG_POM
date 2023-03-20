package tests.day13_crossBrowserTests_dataProvider;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.QdPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C04_DataProviderNegatifLoginTest {
    @DataProvider
    public static Object[][] kullanicilar() {
        String [][] kullaniciList={{"zafer","12345"},
                {"Mehmet","34567"},
                {"Sevilay","67890"},
                {"Enver","56789"},
                {"Ahmet Emre","54321"}};
        return kullaniciList;
    }

    /*
        verilen 5 farkli username ve password'u kullanarak qualitydemy uygulamasina girilemediğini test edin.
         */
    @Test(dataProvider = "kullanicilar")
    public void negatifLogin1(String username,String password){

       QdPage qdPage=new QdPage();
       ReusableMethods.bekle(2);
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));

        qdPage.ilkloginLinki.click();



            qdPage.cookiesKabulButonu.click();

        qdPage.emailKutusu.sendKeys(username);
        qdPage.passwordKutusu.sendKeys(password);
        ReusableMethods.bekle(2);
        qdPage.loginButonu.click();

        Assert.assertTrue(qdPage.emailKutusu.isEnabled());

    }
}
