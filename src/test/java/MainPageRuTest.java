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

public class MainPageRuTest {
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
        mainPage.chooseLanguage("ru");
    }

    @Test
    public void checklanguagebuttons(){
        List<String> lan = Arrays.asList("RU", "КРАТКОСРОЧНЫЕ\nКАРТОННЫЕ POSM", "ДОЛГОСРОЧНЫЕ POSM\nИ ТОРГОВОЕ ОБОРУДОВАНИЕ", "ЭКСКЛЮЗИВНЫЕ РЕШЕНИЯ\nДЛЯ ЛЮКСОВЫХ БРЕНДОВ",
                "ИНСТАЛЛЯЦИОННЫЕ УСЛУГИ\nИ СЕРВИС", "О компании", "Производственные мощности", "Новости", "Работа у нас", "Контакты",
                "115088, г. Москва, ул. Шарикоподшипниковская, д. 1, 6 этаж.\n+7 (499) 951-03-09");
        Assert.assertEquals(lan, mainPage.checklanguage());
    }

    @Test
    public void checklanguagenews(){
        List<List<String>> lan = Arrays.asList(Arrays.asList("ЭКСКЛЮЗИВНОЕ ОБОРУДОВАНИЕ И БРЕНД-ЗОНЫ ДЛЯ ОЧКОВ И ОПРАВ.", "29 октября 2021",
                        "За прошедший год подразделение VIRTU Эксклюзив увеличило объём заказов для мировых брендов солнцезащитных очков и оправ."),
                Arrays.asList("POPAI RUSSIA AWARDS 2021: ВСЕ НАГРАДЫ VIRTU.", "09 сентября 2021",
                        "Восемь побед, пять серебряных и шесть бронзовых наград – такие показатели у нашей компании. И это очередной достойный результат."),
                Arrays.asList("НОМИНАНТЫ POPAI STUDENT DESIGN AWARDS 2021.", "12 июля 2021", "9-й раз прошёл конкурс на лучший дизайн-проект POSm среди студентов POPAI STUDENT DESIGN AWARDS."),
                Arrays.asList("POPAI RUSSIA AWARDS 2021: ПРЕДВАРИТЕЛЬНЫЕ ИТОГИ.", "08 июля 2021", "Подведены промежуточные итоги конкурса POPAI RUSSIA AWARDS 2021, и уже известны его номинанты."));
        Assert.assertEquals(lan, mainPage.companynews());
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
