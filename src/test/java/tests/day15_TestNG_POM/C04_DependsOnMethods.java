package tests.day15_TestNG_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

import java.util.List;

public class C04_DependsOnMethods {

    /*
        Priority test methodlarinin calisma siralamasini belirler
        ancak bir onceki method calismadiysa veya failed olduysa
        sonraki test method'unun bosuna calismasina engel olmaz

        1- dependsonMethods kulladigimizda
           bagli olan method (b), bagli oldugu method'u (a) kontrol eder
           Eger a method'u calismadiysa veya Failed oldu ise b'yi ignore eder

        2- Test method'lari bagimsiz olarak calistirilabilinir
           ANCAK eger bir method dependsOnMethod ile baska bir method'a baglanmis ise
           direkt bagli olan method(b)'u calistirmak isteseniz de
           kendisi direkt calismaz, once bagli oldugu method(a)'u calistirir
           o calisip PASSED olursa, kendisi(b) calisir

           AMA bu kural sadece iki method icin gecerlidir
           uc veya daha fazla method'un bagli olmasi durumunda
           hata verir ve test methodlarini calistirmaz

         3- Isim sirasi veya priority sebebi ile
            once bagli olan method calistirilmak istenirse
            bagli olan method, onceligi bagli oldugu method'a verir
            once bagli olunan method calisir,eger PASSED olursa
            bagli olan method'da calisir

     */

    List<WebElement> bulunanWebElemenleriList;

    @Test
    public void a(){

        Driver.getDriver().get("https://www.testotomasyonu.com");

        String expectedUrl="https://www.testotomasyonu.com/";
        String actualUrl=Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actualUrl,expectedUrl);


    }

    @Test(dependsOnMethods = "a")
    public void b(){
        // 2. Test : search Box’i kullanarak “phone” icin arama yapin ve
        //           arama sonucunda urun bulunabildigini test edin

        WebElement aramaKutusu= Driver.getDriver().findElement(By.id("global-search"));

        aramaKutusu.sendKeys("phone"+ Keys.ENTER);

        bulunanWebElemenleriList=Driver.driver.findElements(By.xpath("//*[@*='product-box my-2  py-1']"));

        Assert.assertTrue(bulunanWebElemenleriList.size()>0);


    }

    @Test(dependsOnMethods = "b")
    public void c(){

        // 3.Test : ilk urunu tiklayin ve urun isminin case sensitive
        //          olmaksizin phone icerdigini test edin

        bulunanWebElemenleriList.get(0).click();

        WebElement urunIsimElementi=Driver.getDriver().findElement(By.xpath("//div[@class=' heading-sm mb-4']"));

        String expectedUrunIsimIcerigi="phone";
        String actualUrunIsmiKucukHarf=urunIsimElementi.getText().toLowerCase();

        Assert.assertTrue(actualUrunIsmiKucukHarf.contains(expectedUrunIsimIcerigi));

        Driver.quitDriver();

    }
}
