package tests.day15_TestNG_POM;

import org.testng.annotations.Test;

public class C03_PriorityKurallari {

    /*
        1 - eger bizim mudahelemiz olmazsa TestNG testleri isim sirasina gore calistirir
        2 - Eger biz testleri siralamak istersek
            priority=istenenDeger yazariz
            ve TestNG priority degerlerine bakarak kucukten buyuge dogru calistirir
        3 - Bazi tet method'larina priority atamasi yapip, bazilarina yapmazsak
            TestNG  atama yapilmayalara defail olrak priortiy=0 atamaasini yapar
            ve bu deger gore proirtiy'leri siralar
        4 - Eger priority degerine sahip birden fazla test methodu varsa
            kendi iclerinde harf sirasina gore calisirlar
     */

    @Test
    public void testOtomasyonTesti(){

        System.out.println("test otomasyonu calisti");
    }

    @Test
    public void wiseQuarterTesti(){

        System.out.println("Wise quarter test otomasyonu calisti");
    }

    @Test
    public void youtubeOtomasyonTesti(){

        System.out.println("Youtube test otomasyonu calisti");
    }
}
