package tests.practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.automationtestingPages.AutomationtestingHomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class AutomationtestingTesti {
    AutomationtestingHomePage automationtestingHomePage=new AutomationtestingHomePage();
    @Test
    public void test01(){
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        //3) Click on Shop Menu
        //4) Now click on Home menu button
        //5) Test whether the Home page has Three Sliders only
        //6) The Home page must contains only three sliders
        Driver.getDriver().get(ConfigReader.getProperty("automationtestingUrl"));

        automationtestingHomePage.shopMenuE.click();

        Driver.getDriver().switchTo().frame(automationtestingHomePage.ilkIframeE);

        //Driver.getDriver().switchTo().frame(automationtestingHomePage.ikinciIframeE);
        automationtestingHomePage.ilkIframeE.click();
        Driver.getDriver().switchTo().defaultContent();
        automationtestingHomePage.homeButtonE.click();
        int expectedSliders=3;
        int actualSliders=automationtestingHomePage.kaydiriciListi.size();
        Assert.assertTrue(expectedSliders==actualSliders);

    }
}
