import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class baseTest {
    @BeforeScenario
    public void hazirlik() {
        System.out.println("Senaryo Hazirlaniyor");
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    static WebDriver driver;
    static String expectedTitle = "En Trend Ürünler Türkiye'nin Online Alışveriş Sitesi Trendyol'da";
    static String expectedLoginTitle = "Üye Giriş Sayfası & Üye Ol - Hepsiburada";
    static String actualTitle;

    public static void getUrl(){
        driver.get("https://www.trendyol.com");
    }





    @AfterScenario
    public void bitir() {
        driver.quit();
        System.out.println("Senaryo Tamamlandi");
    }
}
