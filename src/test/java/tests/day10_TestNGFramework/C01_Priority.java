package tests.day10_TestNGFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class C01_Priority {
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
    TestNG test methodlarini calıştirirken standart olarak harf siralamasina bakar
    istediğimiz test methoduna istetiğimiz...
    Selenium test methodlarina priority si kucukten buyuge olacak şekilde calıştırır

    priority degeri aynı olan methodlari harf sirasina gore calıştirir.

     */
    @Test(priority = 20)
    public void amazonTesi(){
        //amazon anasayfaya gidip ,amazona gittigimiz test edelim
        Driver.getDriver().get("https://www.amazon.com");
        //url amazon iceriyor mu test edelim
        String expectedIcerik="amazon";
        String actualUrl=Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedIcerik));
        Driver.closeDriver();

    }
    @Test(priority = 50)
    public void wiseTesti() throws InterruptedException {
        //wisequarter anasayfaya gidip ,wisequarter gittigimiz test edelim

        Driver.getDriver().get("https://www.wisequarter.com");
        Thread.sleep(2000);
        Driver.getDriver().navigate().refresh();
        //url amazon iceriyor mu test edelim
        String expectedIcerik="wisequarter";
        String actualUrl=Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedIcerik));
        Driver.closeDriver();

    }
    @Test(priority = 30)
    public void youtubeTesti(){
        //youtube anasayfaya gidip ,youtube gittigimiz test edelim
        Driver.getDriver().get("https://www.youtube.com");
        //url amazon iceriyor mu test edelim
        String expectedIcerik="youtube";
        String actualUrl=Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedIcerik));
        Driver.closeDriver();
    }
}
