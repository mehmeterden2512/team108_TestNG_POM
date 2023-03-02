package tests.day11_POM_assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QdPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;


public class C03_NegatifLoginTesti {
    //qd anassayfaya gidin

    // 3 test methodu olusturun ve asagıdaki durumlarda giris yapılamadiğini test edin
    //1-gecerli username gecersiz password
    //2-gecersiz username,gecersiz password
    //3- gecersiz username,gecersiz password
    QdPage qdPage=new QdPage();
    @Test
    public void negatifLogin1(){
        qdPage=new QdPage();
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        qdPage.ilkloginLinki.click();
        qdPage.cookiesKabulButonu.click();
        qdPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliUsername"));
        qdPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecersizPassword"));
        ReusableMethods.bekle(2);
        qdPage.loginButonu.click();

        Assert.assertTrue(qdPage.emailKutusu.isEnabled());

    }
    @Test(groups = "smoke")
    public void negatifLogin2(){
        qdPage=new QdPage();
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        qdPage.ilkloginLinki.click();
        qdPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecersizUsername"));
        qdPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));
        qdPage.loginButonu.click();

        Assert.assertTrue(qdPage.emailKutusu.isEnabled());

    }
    @Test(groups = {"smoke", "mr1"})
    public void negatifLogin3(){
        qdPage=new QdPage();
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        qdPage.ilkloginLinki.click();
        qdPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecersizUsername"));
        qdPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecersizPassword"));
        qdPage.loginButonu.click();

        Assert.assertTrue(qdPage.emailKutusu.isEnabled());

        Driver.closeDriver();

    }
}
