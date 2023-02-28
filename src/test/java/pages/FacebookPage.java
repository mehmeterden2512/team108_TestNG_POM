package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FacebookPage {
  public   FacebookPage(){
      PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//input[@placeholder='E-posta veya Telefon Numarası']")
    public WebElement emailKutusu;
  @FindBy(xpath = "//input[@placeholder='Şifre']")
    public WebElement passwordKutusu;
  @FindBy(xpath = "//button[@name='login']")
    public WebElement loginButtonu;
  @FindBy(xpath = "//div[@class='_9ay7']")
  public WebElement basariliGirisYapilamadiYaziElementi;
}
