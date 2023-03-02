package tests.day12_xmlFiles;

import org.testng.annotations.Test;
import utilities.Driver;

public class C01_DriverSingletonPattern {
    @Test
    public void test01(){
        /*
        POM webDriver olarak Driver class'indaki getDriver() method'unun kullanılmasi uzrine kurgulanmıştır.

        Driver.getDriver();

        Driver class'inin obje olusturularak kullanilmasini engellemek icin
        POM tasarlayanlar bir onlem koymak istemisler


        Java da vir class' dan obje olusturulmasini engellemek isterseniz
        SINGLETON PATTERN kullanabilirsiniz,

        Singleton Pattern :Bir classtan obje olusturmasini engellemek/sinirlamak icin
                            kullanılan bir yontemdir.
                            Temel fikir obje olusturmak icin kullanılan default constructor yerine gorunur paramatresiz
                            olusturup Bu constructor in acces modifier'ini private yapıp,kullanılmasini ENGELLEMEKTİR
         */
       // Driver objeDriver=new Driver();

    }
}
