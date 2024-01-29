package tests.day17_testNG_POM;

import org.testng.annotations.Test;
import utilities.Driver;

public class C04_DriverClassSinletonPattern {

    @Test
    public void test01(){

        /*
            Testlerimizde kullanacagimiz WebDriver objesini
            utilities altindaki Driver class'indaki
            getDriver() ile olusturuyoruz

            Driver'in class'indaki WebDriver objesi olarak olusturulan
            driver'a Drive Class'indan obje olusturarak da erisebiliriz
            Ancak mahserin 4 atlisi calismadigindan
            driver objesi bir ise yaramaz

            POM dizayninda Driver class'indaki driver objesine
            obje uzerinden  erisimi iptal etmek icin singleton pattern tercih edilmis


         */




    }
}
