package tests.day16_TestNG_POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ToFormPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class C04_ToFormTesti {

    @Test
    public void formTesti(){

        //1 - https://testotomasyonu.com/form adresine gidin
        Driver.getDriver().get("https://testotomasyonu.com/form");



        //2- Dogum tarihi gun dropdown menuden index kullanarak 5’i secin
        ToFormPage toFormPage=new ToFormPage();
        Select selectGun=new Select(toFormPage.gunDropdownMenu);
        selectGun.deselectByIndex(5);


        //3- Dogum tarihi ay dropdown menuden value kullanarak Nisan’i secin
        Select selectAy=new Select(toFormPage.ayDropdownMenu);
        selectAy.selectByValue("nisan");


        //4- Dogum tarihi yil dropdown menuden visible text kullanarak 1990’i secin
        Select selectYil=new Select(toFormPage.yilDropdownMenu);
        selectYil.selectByVisibleText("1990");


        //5- Secilen değerleri konsolda yazdirin
        System.out.println(selectGun.getFirstSelectedOption().getText());
        System.out.println(selectAy.getFirstSelectedOption().getText());
        System.out.println(selectYil.getFirstSelectedOption().getText());


        //6- Ay dropdown menüdeki tum değerleri(value) yazdırın
        List<WebElement>ayDropDownTumOpsiyonElementleri =selectAy.getOptions();
        System.out.println(ReusableMethods.stringListeCevir(ayDropDownTumOpsiyonElementleri));


        //7- Ay Dropdown menusunun boyutunun 13 olduğunu test edin
        Assert.assertEquals(ayDropDownTumOpsiyonElementleri.size(),13);


        ReusableMethods.bekle(3);
        Driver.quitDriver();
    }
}
