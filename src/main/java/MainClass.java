import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class MainClass {

    static WebDriver driver;
    static Actions action;

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Public\\Pasha\\Selenium_drivers\\chromedriver.exe");

        driver = new ChromeDriver();
        action = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://www.virtu.ru/");
        MainPage mainPage = new MainPage(driver, action);
        mainPage.chooseLanguage("en");
        System.out.println(driver.getTitle());
        driver.quit();
    }
}
