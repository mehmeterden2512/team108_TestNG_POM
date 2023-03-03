package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HotelMyCampPage {
    public HotelMyCampPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(linkText = "Log in")
    public WebElement ilkLoginButtonu;
    @FindBy(id="UserName")
    public WebElement usernameKutusu;
    @FindBy(id="Password")
    public WebElement passwordKutusu;
    @FindBy(id="btnSubmit")
    public WebElement ikinciLoginButtonu;
    @FindBy(id="divMessageResult")
    public WebElement basarizGirisSonucYaziElementi;
}
