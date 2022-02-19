import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class LuxuryPage extends MainPage {

    public LuxuryPage(WebDriver driver, Actions action) {
        super(driver, action);
    }

    private By header = By.xpath("//article[@class='cnt']/h1");
    private By contactUs = By.xpath("//a[@class='block-contacts_a']");
    private By previousSlide2 = By.xpath("//a[@id='double-slider-2-prev']");
    private By nextSlide2 = By.xpath("//a[@id='double-slider-2-next']");
    private By numOfSlide2 = By.xpath("//p[@id='double-slider-2-tx']");
    private By previousSlide1 = By.xpath("//a[@id='double-slider-1-prev']");
    private By nextSlide1 = By.xpath("//a[@id='double-slider-1-next']");
    private By numOfSlide1 = By.xpath("//p[@id='double-slider-1-tx']");

    public String headertext(){
        return driver.findElement(header).getText();
    }

    public LuxuryPage clickpreviousslide2(int previosnum){
        for (int i = 0; i < previosnum; i++) {
            driver.findElement(previousSlide2).click();
        }
        return this;
    }

    public LuxuryPage clicknextslide2(int nextnum){
        for (int i = 0; i < nextnum; i++){
            driver.findElement(nextSlide2).click();
        }
        return this;
    }

    public String checknumofslide2(int previosnum, int nextnum){
        this.clickpreviousslide2(previosnum);
        this.clicknextslide2(nextnum);
        return driver.findElement(numOfSlide2).getText().split(" ")[0];
    }

    public LuxuryPage clickpreviousslide1(int previosnum){
        for (int i = 0; i < previosnum; i++) {
            driver.findElement(previousSlide1).click();
        }
        return this;
    }

    public LuxuryPage clicknextslide1(int nextnum){
        for (int i = 0; i < nextnum; i++){
            driver.findElement(nextSlide1).click();
        }
        return this;
    }

    public String checknumofslide1(int previosnum, int nextnum){
        this.clickpreviousslide1(previosnum);
        this.clicknextslide1(nextnum);
        return driver.findElement(numOfSlide1).getText().split(" ")[0];
    }
}
