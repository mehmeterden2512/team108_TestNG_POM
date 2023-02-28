package tests.day10_TestNGFramework;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;

public class C02_dependsOnMethods {
    /*
        Priority oncelik belirler ama testleri birbirine baglamaz
        eger bir test method'unun calismasi baska bir test method'una bagli ise
        bu durumda dependsOnMethods kullanmak daha guzel olur
        dependsOnMethod ile baska bir method'a bagli olan method'u bagimsiz calistirmak istersek
        once bagli oldugui method'u calistirir, sonra kendisi calisir
        Ancak bu 2 method icin gecerlidir, 3 method calistirmaz
        dependsOnMethods bir siralama yontemi DEGILDIR
        sira bagli olan bir method'a geldiginde,
        oncelikle bagli oldugu method'un calismasini ve PASSED olmasini bekler
        Eger bagli olunan method FAILED olursa
        bagli olan method calistirilmaz, IGNORE edilir
     */
    /*
    priority oncelik belirler ama testleri birbirine baglamaz
    eger bir test methodu calışması baska bir test methodu calışması gerekirse
    bu durumda priority yerine dependsOnMethods kullanmak daha guzel olur
    dependsOnMethod ile
    once baglı oldugu methodu calışturirir,sonra kendisi calışır
    Ancak bu iki method icin gecerlidir,3 method calıştırmaz
    dependsOnMethod bir siralama yontemi DEGİLDİR
    sira baglı olan bir methoda geldiğinde oncelikle baglı oldugu method un calışmasini
    ve passed olmasini
    bekler

    Eger baglı olunan method Faıled olursa diğerlerini calıştırmaz
     */
    //3 test methodu olusturun
    //1.amazona gidip amazona gittiğimizi test edin
    //2.Nutella aratip sonucun nutella icerdiğini test edin
    //3.de  ilk urune click yapın urun isminin  Nutella icerdidiğini test edin
    AmazonPage amazonPage=new AmazonPage();
    @Test
    public void amazonTesti(){
        Driver.getDriver().get("https://www.amazon.com");
        String expectedIcerik="amazon";
        String actualUrl=Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedIcerik));
    }
    @Test(dependsOnMethods = "amazonTesti")
    public void nutellaTesti(){

        amazonPage.aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        String expectedIcerik="Nutella";
        String actualSonucYazisi=amazonPage.aramaSonucElementi.getText();
        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));
    }
    @Test(dependsOnMethods = "nutellaTesti")
    public void ilkUrunTesti(){
        amazonPage.ilkUrun.click();
        String expectedIcerik="Nutella";
        String actualSonuc=amazonPage.ilkUrunIsim.getText();
        Assert.assertTrue(actualSonuc.contains(expectedIcerik));

        Driver.closeDriver();

    }

}
