package tests.practice;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class Q2 {
    /*
    - Birbirine bagimli testler olusturun.

    - Birbirine bagimli testler olusturarak ;
        =>ilk once wisequarter'a gidin
        =>sonra wisequarter'a bagimli olarak youtube'a gidin
        =>daha sonra youtube'a bagimli olarak amazon'a gidin
    - driver'i kapatin.
     */
    @Test
    public void wisequarter(){
        Driver.getDriver().get(ConfigReader.getProperty("wiseUrl"));
    }
    @Test(dependsOnMethods = "wisequarter")
    public void youtube(){
        Driver.getDriver().get(ConfigReader.getProperty("youtubeUrl"));
    }
    @Test(dependsOnMethods = "youtube")
    public void amazon(){//amazon testi run yapıldıgında calışmaz cunku dependsOnMethods ile bagımlı yapılan
                            //testlerde ikinci derecede bagımlı testleri calıştırır bagımlı olan testtin calışmasi gereken
                            //test te baska bir teste dependsOn yapılmışsa calışmaz hata verir
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
    }
}
