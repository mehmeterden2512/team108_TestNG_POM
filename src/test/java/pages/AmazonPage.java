package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AmazonPage {
 /*
        Pages class'lari surekli kullandigimiz locate'leri
        tekrar tekrar locate etmek zorunda kalmaktan kurtulmak icin kullanilir
        Her pages class'i Driver class'inda olusturulan driver'i kullanir
        @FindBy notasyonunun Driver class'indaki webDriver'i kullanabilmesi icin
        bu class'a tanitmamiz gerekiyor
        bunun icin her pages sayfasi ilk olusturuldugunda
        basina parametresiz bir constructor olusturup
        icerisinde driver'i bu class'a tanitiyoruz.
     */

    /*
    Pages classlari surekli kullandıgımız locate'lerii
     tekrar tekrar locate etmek zorunda kalmaktan kurtulmak icin kullanilir

     Her page classi Driver clasında olusturulan driver i kullanir
     @FindBy notasyonun Driver clasindaki WebDriver i kullanabilmesi icin
     bu clasa tanıtmamız gerekiyor
     bunun icin her page sayfasi ilk olusturuldugunda basına bir parametresiz constructor olusturup
     icerisinde driver i bu clasa tanitiyoruz
     */


   public AmazonPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }



    @FindBy(id="twotabsearchtextbox")
    public   WebElement aramaKutusu;
    @FindBy(xpath = "//h1[@class='a-size-base s-desktop-toolbar a-text-normal']")
    public WebElement aramaSonucElementi;
    @FindBy(xpath = "(//img[@class='s-image'])[1]")
    public WebElement ilkUrun;
    @FindBy(xpath = "//span[@id='productTitle']")
    public WebElement ilkUrunIsim;
}
