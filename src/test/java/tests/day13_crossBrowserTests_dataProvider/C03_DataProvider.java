package tests.day13_crossBrowserTests_dataProvider;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_DataProvider {



    /*
        Veilen dort farklı wen sitesine gidin o sayfaya gidildiğini test edin sayfayi kapatin
        amazonUrl
        wiseUrl
        qdUrl
        youtubeUrl

         */
    @DataProvider
    public static Object[][] urlListesi() {
        String [][] siteListesi={{"amazonUrl"},{"wiseUrl"},{"qdUrl"},{"youtubeUrl"}};

        return siteListesi;
    }
    @Test(dataProvider = "urlListesi")
    public void urlTest(String gilicekSite){
        Driver.getDriver().get(ConfigReader.getProperty(gilicekSite));

        String actualUrl=Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl,ConfigReader.getProperty(gilicekSite)+"/");

        Driver.closeDriver();
    }
}
