import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainPageEnTest {
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
        mainPage.chooseLanguage("en");
    }

    @Test
    public void checklanguagebuttons(){
        List<String> lan = Arrays.asList("EN", "CORRUGATED POS", "POS AND SHOP FITTING", "EXCLUSIVE SOLUTIONS\nFOR LUXURY BRANDS",
                "INSTALLATION SERVICES\nAND MAINTENANCE", "About us", "Capabilities", "News", "Careers", "Contact us",
                "Sharikopodshipnikovskaya str. 1, 6 floor, Moscow, 115088, Russia\n+7 (499) 951-03-09");
        Assert.assertEquals(lan, mainPage.checklanguage());
    }

    @Test
    public void checklanguagenews(){
        List<List<String>> lan = Arrays.asList(Arrays.asList("EXCLUSIVE BRANDED FURNITURE FOR SUNGLASSES AND FRAMES.", "29 October 2021",
                "Over the past year has VIRTU Exclusive division significantly increased the total amount of orders for sunglasses and frames brands."),
                Arrays.asList("POPAI RUSSIA AWARDS 2021: WHAT VIRTU WON.", "09 September 2021", "We are proud of getting eight victories, five silver and six bronze awards."),
                Arrays.asList("POPAI STUDENT DESIGN AWARDS 2021 NOMINEES.", "12 July 2021", "The 9th POPAI STUDENT DESIGN AWARDS has been held recently."),
                Arrays.asList("THE POPAI RUSSIA AWARDS 2021: INTERMEDIATE RESULTS.", "08 July 2021", "Intermediate results have been summed up and all the nominees for the POPAI RUSSIA AWARDS 2021 are already known."));
        Assert.assertEquals(lan, mainPage.companynews());
    }

    @Test
    public void clickFacebook(){
        Assert.assertEquals("https://www.facebook.com/VIRTU-365088883613966/", mainPage.clicklink("facebook"));
    }

    @Test
    public void clickYouTube(){
        Assert.assertEquals("https://www.youtube.com/user/VIRTUcompany", mainPage.clicklink("youtube"));
    }

    @Test
    public void clickPresentation(){
        Assert.assertEquals("https://www.youtube.com/user/VIRTUcompany", mainPage.clicklink("presentation"));
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
