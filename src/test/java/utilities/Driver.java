package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {
    /*
        Bu class'in amaci
        belirlenen browser'a uygun webDriver objesi olusturmak

     */

    private  Driver(){
        // baska class'larin Driver class'indan obje olustumasini engellemek icin
        // Singleton pattern kullanilmistir
        // Singleton pattern class'dan obje olusturulmasini engellemek icin
        // construcotr'i gorunur yapip erisimini  private yapmaya dayanir
    }
    public static WebDriver driver;

    public static WebDriver getDriver(){


        String browserTercihi=ConfigReader.getProperty("browser");

        /*
            Browser'in sadece chrome olmamasi icin
            configuration.properties'e browser=firefox
            secenegi ekledik

            Orada yazan browser tercihini 22.satirda alip
            tercihe uygun driver olsuturmasi icin
            bir switch statment kullandik

         */


        if (driver==null){
            switch (browserTercihi){

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    break;

                case " edge":
                    WebDriverManager.edgedriver().setup();
                    driver= new EdgeDriver();
                    break;

                default:
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver();
            }





            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }

        return driver;


    }


    public static void closeDriver(){

        if (driver!=null){
            driver.close();
            driver=null;
        }
    }

    public static void quitDriver(){

        if (driver!=null){
            driver.quit();
            driver=null;
        }
    }

}
