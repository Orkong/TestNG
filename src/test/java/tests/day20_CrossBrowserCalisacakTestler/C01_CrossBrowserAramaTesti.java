package tests.day20_CrossBrowserCalisacakTestler;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.TestBaseCross;

public class C01_CrossBrowserAramaTesti extends TestBaseCross {

    @Test
    public void aramaTesti(){

        // testotomasyon sayfasina gidin
        driver.get(ConfigReader.getProperty("toUrl"));

        // phone icin arama yapim
        WebElement aramaKutusu=driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone"+ Keys.ENTER);

        // arama sonucunda urun bulunabildigini test edin
        WebElement aramaSonucElementi= driver.findElement(By.xpath("//*[@*='product-count-text']"));


    }
}
