package tests.day10_TestNGFramework;

import org.testng.annotations.*;

public class C03_BeforeAfterNotasyonlari {
    /*
    Smoke Test
    Regresyon Test
    EndToEnd (E2E)


    Test suite: Birden fazla Test'in bir amac icin biraraya getirilmesidir

    Test :Bir amac icin bir araya getirilmiş test methodlari ,class'lari
    ve/Veya package'lari icerir

    Test Hiyerarsisi:
    -suite
    -Test
    -groups,packages,classes,methods




     */
    @BeforeSuite
    public void beforeSuit(){
        System.out.println("before suit");
    }
    @AfterTest
    public void afterSuit(){
        System.out.println("after suit");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("before test");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("before class");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("before method");
    }
    @Test public void test01(){
        System.out.println("test 01");
    }
    @Test public void test02(){
        System.out.println("test 02");
    }
    @Test public void test03(){
        System.out.println("test 03");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("After Test");
    }
    @AfterClass(groups="smoke")
    public void afterClass(){
        System.out.println("after class");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("after method");
    }
}
