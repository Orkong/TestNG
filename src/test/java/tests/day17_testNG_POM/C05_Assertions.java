package tests.day17_testNG_POM;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C05_Assertions {
    @Test
    public void aramaTesti(){

        // testotomasyonu ana sayfaya gidelim
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        // testotomasyonu sayfasinda gittigini test edelim
        String expectedUrl=ConfigReader.getProperty("toUrl")+"/";
        String actualUrl=Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actualUrl,expectedUrl);


        // phone icin arama yapin
        TestOtomasyonPage testOtomasyonPage=new TestOtomasyonPage();
        testOtomasyonPage.aramaKutusu.sendKeys("phone"+ Keys.ENTER);


        // bulunan urun sayisinin 3'ten fazla odlugunu test edin
        int expectedMinUrunSayisi=3;
        int actualUrunSayisi=testOtomasyonPage.bulunanUrunElementleriList.size();

        Assert.assertTrue(actualUrunSayisi > expectedMinUrunSayisi);

        // ilk urune tiklarin
        testOtomasyonPage.bulunanUrunElementleriList.get(0).click();

        // acilan urun sayfasinda, urun isminin
        // case sensitive olmadan phone icerdigini test edin
        String  expectedUrunIsimIcerik="phone";
        String actualUrunIsmiKucukHarf=testOtomasyonPage
                .urunSayfasindaUrunIsimElementi.getText().toLowerCase();

        Assert.assertTrue(actualUrunIsmiKucukHarf.contains(expectedUrunIsimIcerik));


        // sayfayi kapatin
        Driver.quitDriver();

    }
}
