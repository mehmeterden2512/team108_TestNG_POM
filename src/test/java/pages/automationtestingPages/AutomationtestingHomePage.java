package pages.automationtestingPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class AutomationtestingHomePage {
  public   AutomationtestingHomePage(){
      PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[text()='Shop']")
    public WebElement shopMenuE;//sondaki E elementi kisaltmasidir.
  @FindBy(xpath = "//div[@id='dismiss-button']")
    public WebElement iframeRedE;
  @FindBy(xpath = "//a[text()='Home']")
    public WebElement homeButtonE;
  @FindBy(xpath = "//div[@data-slide-duration='0']")
    public List<WebElement> kaydiriciListi;
  @FindBy(xpath = "//iframe[@name='google_esf']") public WebElement ilkIframeE;
  @FindBy(xpath = "//iframe[@title='Advertisement']") public WebElement ikinciIframeE;
  //@FindBy(xpath = "//iframe[@id='google_esf']") public WebElement IframeIframeE;
}
