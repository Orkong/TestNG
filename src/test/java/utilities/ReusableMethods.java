package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ReusableMethods {

    public static void bekle(int saniye) {

        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<String> stringListeCevir(List<WebElement> webelementList) {

        List<String> stringlist = new ArrayList<>();

        for (WebElement eachElemenet : webelementList
        ) {

            stringlist.add(eachElemenet.getText());
        }
        return stringlist;
    }


    public static void titleIleWindowDegistir(String hedefTitle, WebDriver driver) {

        Set<String> whdSeti = driver.getWindowHandles();
        System.out.println(whdSeti);

        for (String eachWhd : whdSeti
        ) {
            driver.switchTo().window(eachWhd);

            String oldugumuzSayfaTitle = driver.getTitle();

            if (oldugumuzSayfaTitle.equals(hedefTitle)) {
                System.out.println(oldugumuzSayfaTitle);
                break;
            }
        }

    }

    public static void tumSayfaScreenshot(WebDriver driver) {

        // 1- bir TakesScreenShot objesi olusturun ve deger olarak driver'i atayin
        TakesScreenshot tss = (TakesScreenshot) driver;

        // 2- screenShot'i kaydedecegimiz bir dosya olusturun
        //    SS ismini unique yapabilmek icin, timestamp ekleyelim
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter zamanFormati = DateTimeFormatter.ofPattern("YYMMddHHmmss");
        String timeStamp = ldt.format(zamanFormati);


        File tumSayfaSS = new File("target/tumSayfaScreenshot/tumSayfa"+timeStamp+".jpeg");

        // 3- tss objesini kullanarak Screenshot alin ve bir File olarak kaydedin
        File geciciDosya = tss.getScreenshotAs(OutputType.FILE);

        // 4- gecici dosyayi deger olarak asil kaydedilecek File'a kopyalayin
        try {
            FileUtils.copyFile(geciciDosya, tumSayfaSS);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void tumSayfaScreenshot(WebDriver driver, String resimAdi) {

        // 1- bir TakesScreenShot objesi olusturun ve deger olarak driver'i atayin
        TakesScreenshot tss = (TakesScreenshot) driver;

        // 2- screenShot'i kaydedecegimiz bir dosya olusturun
        File tumSayfaSS = new File("target/tumSayfaScreenshot/" + resimAdi + ".jpeg");

        // 3- tss objesini kullanarak Screenshot alin ve bir File olarak kaydedin
        File geciciDosya = tss.getScreenshotAs(OutputType.FILE);

        // 4- gecici dosyayi deger olarak asil kaydedilecek File'a kopyalayin
        try {
            FileUtils.copyFile(geciciDosya, tumSayfaSS);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void webElementScreenshot(WebElement webElement){
        // 1- Screenshot alacaginiz webelementi locate edip kaydedin
        // 2- screenshot'i kaydedecegimi dosyayi olusturun
        //    SS ismini unique yapabilmek icin, timestamp ekleyelim
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter zamanFormati = DateTimeFormatter.ofPattern("YYMMddHHmmss");
        String timeStamp = ldt.format(zamanFormati);

        File webElementSS= new File("target/webElementScreenshots/webElement"+timeStamp+".jpg");
        // 3- webElementi kullanarak screenshot alin ve gecici dosyaya kaydedin
        File geciciScreenshot= webElement.getScreenshotAs(OutputType.FILE);
        // 4- gecici dosyayi asil doyaya kopyalayalim
        try {
            FileUtils.copyFile(geciciScreenshot,webElementSS);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public static void webElementScreenshot(WebElement webElement,String screenshotIsim){
        // 1- Screenshot alacaginiz webelementi locate edip kaydedin
        // 2- screenshot'i kaydedecegimi dosyayi olusturun
        //    SS ismini unique yapabilmek icin, timestamp ekleyelim
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter zamanFormati = DateTimeFormatter.ofPattern("YYMMddHHmmss");
        String timeStamp = ldt.format(zamanFormati);

        File webElementSS= new File("target/webElementScreenshots/"+screenshotIsim+timeStamp+".jpg");
        // 3- webElementi kullanarak screenshot alin ve gecici dosyaya kaydedin
        File geciciScreenshot= webElement.getScreenshotAs(OutputType.FILE);
        // 4- gecici dosyayi asil doyaya kopyalayalim
        try {
            FileUtils.copyFile(geciciScreenshot,webElementSS);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
