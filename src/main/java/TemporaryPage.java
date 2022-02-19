import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class TemporaryPage extends MainPage {

    public TemporaryPage(WebDriver driver, Actions action) {
        super(driver, action);
    }

    private By header = By.xpath("//article[@class='cnt']/h1");
    private By contactUs = By.xpath("//a[@class='block-contacts_a']");
    private By previousSlide = By.xpath("//a[@id='double-slider-3-prev']");
    private By nextSlide = By.xpath("//a[@id='double-slider-3-next']");
    private By numOfSlide = By.xpath("//p[@id='double-slider-3-tx']");

    public String headertext(){
        return driver.findElement(header).getText();
    }

    public TemporaryPage clickpreviousslide(int previosnum){
        for (int i = 0; i < previosnum; i++) {
            driver.findElement(previousSlide).click();
        }
        return this;
    }

    public TemporaryPage clicknextslide(int nextnum){
        for (int i = 0; i < nextnum; i++){
            driver.findElement(nextSlide).click();
        }
        return this;
    }

    public String checknumofslide(int previosnum, int nextnum){
        this.clickpreviousslide(previosnum);
        this.clicknextslide(nextnum);
        return driver.findElement(numOfSlide).getText().split(" ")[0];
    }
}
