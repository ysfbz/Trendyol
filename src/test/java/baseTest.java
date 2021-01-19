import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import helper.ElementHelper;
import helper.StoreHelper;
import model.ElementInfo;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class baseTest {
    @BeforeScenario
    public void hazirlik() {
        System.out.println("Senaryo Hazirlaniyor");
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        action = new Actions(driver);
        driver.manage().window().maximize();
    }

    static WebDriver driver;
    static Actions action;
    static String expectedTitle = "En Trend Ürünler Türkiye'nin Online Alışveriş Sitesi Trendyol'da";
    static String expectedLoginTitle = "";
    static String actualTitle;

    public static void getUrl(){
        driver.get("https://www.trendyol.com");
    }

    public WebElement findElement(String key) {
        ElementInfo elementInfo = StoreHelper.INSTANCE.findElementInfoByKey(key);
        By infoParam = ElementHelper.getElementInfoToBy(elementInfo);
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        WebElement webElement = webDriverWait
                .until(ExpectedConditions.presenceOfElementLocated(infoParam));
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'center'})",
                webElement);
        return webElement;
    }

    public void hoverElement(String by) {
        action.moveToElement(findElement(by)).build().perform();
    }

    public void assertControl(String assertName, String expectedName){
        String assertName1 = findElement(assertName).getText();
        System.out.println(assertName1);
        Assert.assertEquals(assertName1,expectedName);
    }

    public  void sendkeysElement(String by,String text){
        findElement(by).sendKeys(text);
    }

    public void clickElement(String by){
        findElement(by).click();
    }



    @AfterScenario
    public void bitir() {
        driver.quit();
        System.out.println("Senaryo Tamamlandi");
    }
}
