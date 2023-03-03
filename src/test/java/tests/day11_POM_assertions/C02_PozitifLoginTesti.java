package tests.day11_POM_assertions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QdPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C02_PozitifLoginTesti {
    @Test
    public void pozitifLoginTesti(){
        //qd ana sayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
       // ReusableMethods.waitForPageToLoad(2l);

        //ReusableMethods.bekle(3);
       // Driver.getDriver().findElement(By.xpath("//a[@onclick='cookieAccept();']")).click();
        WebElement cooki=Driver.getDriver().findElement(By.xpath("//a[@onclick='cookieAccept();']"));
       // ReusableMethods.clickWithTimeOut(cooki,3);
        ReusableMethods.fluentWait(cooki,2);
        cooki.click();
        // login linkine tiklayin
        QdPage qdPage=new QdPage();

        qdPage.ilkloginLinki.click();
        //gecerli kullanici adi ve password ile giris yapin
        qdPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliUsername"));
        qdPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));

        qdPage.loginButonu.submit();

        //basarili bir sekilde giris yapıldıgını test edin

        Assert.assertTrue(qdPage.basariliGirisElementi.isDisplayed());

        Driver.closeDriver();
    }
}
