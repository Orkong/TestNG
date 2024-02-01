package tests.day18_softAssertions_xmlFiles;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ZeroWebPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class C02_WebAppTesti {

    @Test
    public void test01(){

        // 1. “http://zero.webappsecurity.com/” Adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("zeroUrl"));

        // 2. webbappsecurity ana sayafaya gittiginizi dogrulayin
        String expectedUrl=ConfigReader.getProperty("zeroUrl");
        String actualUrl= Driver.getDriver().getCurrentUrl();

        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(actualUrl,expectedUrl,"Url test failed");

        // 3. Sign in butonuna basin
        ZeroWebPage zeroWebPage=new ZeroWebPage();
        zeroWebPage.singhInLinki.click();

        // 4. Login kutusuna “username” yazin
        zeroWebPage.
                usernameKutusu.
                sendKeys(ConfigReader.getProperty("zeroGecerliUserName"));

        // 5. Password kutusuna “password” yazin
        zeroWebPage.
                passwordKutusu.
                sendKeys(ConfigReader.getProperty("zeroGecerliPassword"));


        // 6. Sign in tusuna basin
        zeroWebPage.signInButonu.click();

        // 7. Back tusuna basin
        Driver.getDriver().navigate().back();

        // 8. Giris yapilabildigini dogrulayin
        softAssert.assertTrue(zeroWebPage.loginDogrulama.isDisplayed(),"Login test FAILED");

        // 9. Online banking menusunu tiklayin
        zeroWebPage.onlineBankingLinki.click();

        //10. Pay Bills sayfasina gidin
        zeroWebPage.payBillsLink.click();

        //11. “Purchase Foreign Currency” tusuna basin
        zeroWebPage.purchaseForingCurrencyTab.click();

        //12. Currency dropdown menusunun erisilebilir oldugunu dogrulayin
        softAssert.assertTrue(zeroWebPage.pcCurrencyDropdown.isEnabled());

        //13. “Currency” dropdown menusunden Eurozone’u secin
        Select select=new Select(zeroWebPage.pcCurrencyDropdown);
        select.selectByValue("EUR");


        //14. "Eurozone (euro)" secildigini dogrulayin
        String expectedSecilenOption="Eurozone (euro)";
        String actualSecilenOption=select.getFirstSelectedOption().getText();
        softAssert.assertEquals(actualSecilenOption,expectedSecilenOption,"Eurozone test FAILED");

        //15. Dropdown menude 16 option bulundugunu dogrulayin.
        int expectedOptionSayisi=16;
        int actualOptionSayisi=select.getOptions().size();

        softAssert.assertEquals(actualOptionSayisi,expectedOptionSayisi,"Drowdonw option test FAILED");

        //16. Dropdown menude "Canada (dollar)" bulunduğunu dogrulayin
        List<WebElement> dropdownOptionElementleriList=select.getOptions();
        List<String> dropdownOptionListesi=
                ReusableMethods.stringListeCevir(dropdownOptionElementleriList);

        String expectedOptionIcerigi="Canada (dollar)";
        softAssert.assertTrue(dropdownOptionListesi.contains(expectedOptionIcerigi),"Canada test FAILED");

        softAssert.assertAll();

        //17. Sayfayi kapatin
        Driver.quitDriver();

    }
}
