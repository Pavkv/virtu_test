import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class MainPage {

    protected WebDriver driver;
    protected Actions action;

    public MainPage(WebDriver driver, Actions action){
        this.driver = driver;
        this.action = action;
    }

    //topButtons
    protected By virtu = By.xpath("//img[@alt='VIRTU']/parent::a");
    protected By temporary = By.xpath("//b[text()='TEMPORARY']/parent::a");
    protected By permanent = By.xpath("//b[text()='PERMANENT']/parent::a");
    protected By luxury = By.xpath("//b[text()='LUXURY']/parent::a");
    protected By service = By.xpath("//b[text()='SERVICE']/parent::a");
    protected By languageChange = By.xpath("//menu[@id='lang-change']");
    protected By language = By.xpath("//menu[@id='lang-change']/li[1]/a");
    protected By languageChangeEn = By.xpath("//menu[@id='lang-change']//a[text()='en']");
    protected By languageChangeRu = By.xpath("//menu[@id='lang-change']//a[text()='ru']");
    //

    //middle
    private By presentation = By.xpath("//a[@class='promo-video_a']");
    //

    //bottomButtons
    protected By facebook = By.xpath("//img[@alt='Facebook']/parent::a");
    protected By youtube = By.xpath("//img[@alt='YouTube']/parent::a");
    protected By address = By.xpath("//p[@class='footer-address']");
    //

    public String clickVirtu(){
        driver.findElement(virtu).click();
        return driver.getTitle();
    }

    public TemporaryPage clicktemporary(){
        driver.findElement(temporary).click();
        return new TemporaryPage(driver, action);
    }

    public PermanentPage clickpermanent(){
        driver.findElement(permanent).click();
        return new PermanentPage(driver, action);
    }

    public LuxuryPage clickluxury(){
        driver.findElement(luxury).click();
        return new LuxuryPage(driver, action);
    }

    public ServicePage clickservice(){
        driver.findElement(service).click();
        return new ServicePage(driver, action);
    }

    public List<List<String>> companynews(){
        List<List<String>> cnews = new ArrayList<>();
        for (int i = 1; i <= 4; i++){
            List<String> items = new ArrayList<>();
            items.add(driver.findElement(By.xpath("//div[@class='cols-3 mod'][" + i + "]//h6[@class='latest-news_t']")).getText());
            items.add(driver.findElement(By.xpath("//div[@class='cols-3 mod'][" + i + "]//p[@class='latest-news_date']")).getText());
            items.add(driver.findElement(By.xpath("//div[@class='cols-3 mod'][" + i + "]//p[@class='latest-news_tx']")).getText());
            cnews.add(items);
        }
        return cnews;
    }

    public String clicklink(String name){
        if (Objects.equals(name, "facebook")) {
            driver.findElement(facebook).click();
        } else if (Objects.equals(name, "youtube")) {
            driver.findElement(youtube).click();
        } else if (Objects.equals(name, "presentation")) {
            driver.findElement(presentation).click();
        }
        String act = null;
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        for(String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
            act = driver.getCurrentUrl();
        }
        return act;
    }

    public List<String> checklanguage(){
        List<String> lbuttons = new ArrayList<>();
        action.moveToElement(driver.findElement(languageChange));
        lbuttons.add(driver.findElement(language).getText());
        for (int i = 1; i <= 4; i++) {
            lbuttons.add(driver.findElement(By.xpath("//ul[@class='header-nav_services']/li[" + i + "]/a/small")).getText());
        }
        for (int i = 1; i <= 5; i++) {
            lbuttons.add(driver.findElement(By.xpath("//nav[@class='header-nav']/a[" + i + "]")).getText());
        }
        lbuttons.add(driver.findElement(address).getText());
        return lbuttons;
    }

    public void chooseLanguage(String s){
        action.moveToElement(driver.findElement(languageChange));
        Actions lang = Objects.equals(s, "en") ?
                action.moveToElement(driver.findElement(languageChangeEn)) :
                action.moveToElement(driver.findElement(languageChangeRu));
        action.click().build().perform();
    }
}
