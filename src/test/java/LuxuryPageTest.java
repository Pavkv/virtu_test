import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class LuxuryPageTest {
    private WebDriver driver;
    private Actions action;
    private MainPage mainPage;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Public\\Pasha\\Selenium_drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        action = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://www.virtu.ru/");
        mainPage = new MainPage(driver, action);
    }

    @Test
    public void headertextEn(){
        mainPage.chooseLanguage("en");
        Assert.assertEquals("EXCLUSIVE SOLUTIONS FOR LUXURY BRANDS", mainPage.clickluxury().headertext());
    }

    @Test
    public void headertextRu(){
        mainPage.chooseLanguage("ru");
        Assert.assertEquals("ЭКСКЛЮЗИВНЫЕ РЕШЕНИЯ ДЛЯ ЛЮКСОВЫХ БРЕНДОВ", mainPage.clickluxury().headertext());
    }

    @Test
    public void returntomain(){
        Assert.assertEquals("VIRTU", mainPage.clickpermanent().clickVirtu());
    }

    @Test
    public void checkslidebuttons2(){
        Assert.assertEquals("42", mainPage.clickluxury().checknumofslide1(2, 1));
    }

    @Test
    public void checkslidebuttons1(){
        Assert.assertEquals("13", mainPage.clickluxury().checknumofslide2(2, 1));
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
