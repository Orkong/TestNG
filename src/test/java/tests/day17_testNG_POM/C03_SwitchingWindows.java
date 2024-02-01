package tests.day17_testNG_POM;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonPage;
import pages.ToAddRemovePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C03_SwitchingWindows {

    @Test
    public void windowTesti(){

        //● https://testotomasyonu.com/addremove/ adresine gidin.
        Driver.getDriver().get(ConfigReader.getProperty("toAddUrl"));

        //● Sayfadaki textin “Add/Remove Elements” olduğunu doğrulayın.
        String expectedYazi="Add/Remove Elements";

        ToAddRemovePage toAddRemovePage=new ToAddRemovePage();
        String actualYazi=toAddRemovePage.addRemoveYaziElementi.getText();

        Assert.assertEquals(actualYazi,expectedYazi);


        //● Sayfa başlığının(title) “Test Otomasyonu” olduğunu doğrulayın.
        String expectedTitle="Test Otomasyonu";
        String actuaclTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(actuaclTitle,expectedTitle);
        String addRemoveSayfasiWhd=Driver.getDriver().getWindowHandle();



        ReusableMethods.bekle(2);

        //● ’Please click for Electronics Products’ linkine tiklayin.
        toAddRemovePage.electronicsLinki.click();

        //JavascriptExecutor jse= (JavascriptExecutor) Driver.getDriver();
        //jse.executeScript("arguments[0].scrollIntoView(true);",toAddRemovePage);



        //● Electronics sayfasinin acildigini test edin

        // link tiklandiginda elektronics sayfasi ayri bi TAB olarak aciliyor
        // once webDriver objemizi o window'a gecirmeliyiz

        ReusableMethods.titleIleWindowDegistir("Test Otomasyonu - Electronics",Driver.getDriver());

        ReusableMethods.bekle(1);
        Assert.assertTrue(toAddRemovePage.electronicsSayfasiDogrulama.isDisplayed());


        //● Bulunan urun sayisinin 16 olduğunu test edin
        TestOtomasyonPage testOtomasyonPage=new TestOtomasyonPage();

        int expectedUrunSayisi=16;
        int actualUrunSayisi=testOtomasyonPage.bulunanUrunElementleriList.size();

        Assert.assertEquals(actualUrunSayisi,expectedUrunSayisi);

        //● Ilk actiginiz addremove sayfasina donun
        Driver.getDriver().switchTo().window(addRemoveSayfasiWhd);

        //● Url’in addremove icerdigini test edin
        String expectedUrlIcerik="addremove";
        String actualUrl=Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));

        Driver.quitDriver();




    }
}
