import com.thoughtworks.gauge.Step;
import org.junit.Assert;

public class anasayfa extends baseTest {


    @Step("Anasayfaya gider")
    public void anaSayfayaGit() throws InterruptedException {
        getUrl();
        System.out.println("Anasayfa yuklendi");
    }

    @Step("<saniye> saniye bekle")
    public void waitElement(int key) throws InterruptedException {
        Thread.sleep(key * 1000);
        System.out.println(key + " saniye beklendi");
    }


    @Step("<reklamKapatma> tikla")
    public void implementation2(String reklamKapatma) {
        //findElement(reklamKapatma);
        clickElement(reklamKapatma);
        System.out.println("Reklam Kapandı");
    }

    @Step("<Samsung> ara <aramaText>")
    public void implementation3(String esya, String key) {
        sendkeysElement(key, esya);
    }

    @Step("<email> <email> ile <sifre> <sifre> giris")
    public void implementation5(String emailU, String email, String sifreU, String sifre) {
        sendkeysElement(email, emailU);
        sendkeysElement(sifre, sifreU);
    }


    @Step("<hesabimIsim> ile <username> isim kontrol")
    public void implementation4(String isim, String name) {

        assertControl(isim, name);
        System.out.println("isim dogru");
    }

    @Step("<hesabimMenü> hesabim üzerine gel bekle")
    public void implementation6(String hesabimHover) {
        System.out.println("Hovera geldi");
        hoverElement(hesabimHover);
        System.out.println("Hovera geldi");
    }

    @Step("<urun> ilk urune tikla <index>")
    public void uruneTiklat(String urun, int index) {
        clickListElement(urun, index);

    }

    @Step("<key> elementi var mi")
    public void checkElement(String key) {
        try {
            findElement(key);
        } catch (Exception e) {
            Assert.fail("Element bulunamadı.");
        }
    }


    }
