package com.A101_Project.tests;


import com.A101_Project.utilities.ConfigurationReader;
import com.A101_Project.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class A101_TestCase {

    WebDriver driver;

    @BeforeMethod

            public void setup (){

        /** BeforeMethod içerisinde önce belirttiğiniz tarayıcı (Google) açılır. Ardından açılan pencere büyütülür
           ve ve bir sonraki komut gerçekleşmeden önce sayfanın yüklenmesi için gereken miktar kadar beklenir. */

        driver = WebDriverFactory.getDriver(ConfigurationReader.get("browser"));

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterMethod
            public void teardown () throws InterruptedException {

        /**Test başarıyla tamamlandıktan sonra iki saniye bekler ve tarayıcıyı kapatır. */

        Thread.sleep(2000);

        driver.quit();

    }

    @Test

            public void firstCase() throws InterruptedException {

        //Belirtilen siteyi açar
        driver.get(ConfigurationReader.get("url"));

        Thread.sleep(1000);

        //Site ilk açıldığında ekrana çerezleri kabul et penceri gelir. Bu noktada çerezleri kabul eder.
        WebElement kabulet = driver.findElement(By.xpath("//button[@id=\"CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll\"]"));

        kabulet.click();
        Thread.sleep(1000);

        //Giyim ve aksesuar seçeneğine tıklar.
        WebElement giyimveaksesuarbutonu = driver.findElement(By.xpath("(//li[@class=\"js-navigation-item \"])[4]"));

        giyimveaksesuarbutonu.click();
        Thread.sleep(1000);

        //Kadın iç giyim seçeneğine tıklar.
        WebElement kadinIcGiyimButonu = driver.findElement(By.xpath("(//a[@href=\"/giyim-aksesuar/kadin-ic-giyim/\"])[2]"));

        kadinIcGiyimButonu.click();
        Thread.sleep(1000);

        //Dizaltı çorap seçeneğine tıklar.
        WebElement dizaltiCorapButonu = driver.findElement((By.xpath("(//a[@href=\"/giyim-aksesuar/dizalti-corap/\"])[2]")));

        dizaltiCorapButonu.click();
        Thread.sleep(1000);

        //Belirtilen siyah çorap ürününe tıklar.
        WebElement urunButonu = driver.findElement(By.xpath("(//a[@href=\"/giyim-aksesuar/penti-kadin-50-denye-pantolon-corabi-siyah/\"])[1]"));

        urunButonu.click();
        Thread.sleep(1000);

        //Belirtilen ürünün siyah olduğunu doğrular.
        WebElement renkButonu = driver.findElement(By.xpath("//div[@class=\"selected-variant-text\"]/span"));

        Assert.assertEquals(renkButonu.getText(), "SİYAH");

        //Doğrulama gerçekleştikten sonra ürünü sepete ekler.
        WebElement sepeteekle = driver.findElement(By.xpath("//button[@class=\"add-to-basket button green block with-icon js-add-basket\"]"));

        sepeteekle.click();
        Thread.sleep(1000);

        //Sepete eklenen ürünü görmek için sepete gider.
        WebElement sepetegit = driver.findElement(By.xpath("//a[@class=\"go-to-shop\"]"));

        sepetegit.click();
        Thread.sleep(1000);

        //Sepeti onaylar.
        WebElement sepetionayla = driver.findElement(By.xpath("//a[@class=\"button green checkout-button block js-checkout-button\"]"));

        sepetionayla.click();
        Thread.sleep(1000);

        //Kullanıcının üye olması istenen ekrandaki üye olmadan devam et seçeneğine tıklar.
        WebElement uyeOlmadanDevamEt = driver.findElement(By.xpath("//a[@class=\"auth__form__proceed js-proceed-to-checkout-btn\"]"));

        uyeOlmadanDevamEt.click();
        Thread.sleep(1000);

        //E-posta istenen ekrana gelir ve giriş alanına bir e-posta yazar.
        WebElement email = driver.findElement(By.xpath("(//input[@class=\"js-form-input\"])[2]"));

        email.sendKeys("horob30553@bongcs.com");
        Thread.sleep(1000);

        //E-posta'yı yazdıktan sonra devam et seçeneğine tıklanarak adres ekranına geçiş yapar.
        WebElement devamEt = driver.findElement(By.xpath("//button[@class=\"button block green\"]"));

        devamEt.click();
        Thread.sleep(1000);

        //Adres ekle seçeneğine tıklayarak adres için gerekli giriş alanlarını açar.
        WebElement adresEkle = driver.findElement(By.xpath("(//li[@class=\"half\"])[1]"));

        adresEkle.click();
        Thread.sleep(1000);

        //Adres başlığını girer.
        WebElement adresBasligi = driver.findElement(By.xpath("(//input[@type=\"text\"])[5]"));

        adresBasligi.sendKeys("Ev adresim");
        Thread.sleep(1000);

        //Alıcı adını girer. (Testi ikinci kez çalıştırmanız durumunda lütfen adı ve soyadı değiştirmeyi unutmayın.Yoksa hata veriyor.)
        WebElement ad = driver.findElement(By.xpath("(//input[@type=\"text\"])[6]"));

        ad.sendKeys("Ali");
        Thread.sleep(1000);

        //Alıcı soyadını girer.
        WebElement soyad = driver.findElement(By.xpath("(//input[@type=\"text\"])[7]"));

        soyad.sendKeys("Veli");
        Thread.sleep(1000);

        //Alıcı telefon numarasını girer.
        WebElement telefonNumarasi = driver.findElement(By.xpath("(//input[@type=\"text\"])[8]"));

        telefonNumarasi.sendKeys("5507401991");
        Thread.sleep(1000);

        //Alıcının yaşadığı ilin (İstanbul) bulunduğu çoktan seçmeli menüyü konumlandırır.
        WebElement il = driver.findElement(By.xpath("(//select[@type=\"text\"])[1]"));

        il.click();
        Thread.sleep(1000);

        //İstanbul ilini seçer.
        WebElement istanbul = driver.findElement(By.xpath("//option[@value=\"40\"]"));

        istanbul.click();

        //Alıcının yaşadığı ilçenin (Üsküdar) bulunduğu çoktan seçmeli menüyü konumlandırır.
        WebElement ilce = driver.findElement(By.xpath("(//select[@type=\"text\"])[2]"));

        ilce.click();
        Thread.sleep(1000);

        //Üsküdar ilçesini seçer.
        WebElement uskudar = driver.findElement(By.xpath("//option[@value=\"485\"]"));

        uskudar.click();

        //Alıcının yaşadığı mahallenin (Acıbadem) bulunduğu çoktan seçmeli menüyü konumlandırır.
        WebElement mahalle = driver.findElement(By.xpath("(//select[@type=\"text\"])[3]"));

        mahalle.click();
        Thread.sleep(1000);

        //Acıbadem mahallesini seçer.
        WebElement acibadem = driver.findElement(By.xpath("//option[@value=\"36315\"]"));

        acibadem.click();

        //Alıcının yaşadığı adresin geriye kalan kısmını giriş alanına girer.
        WebElement adres = driver.findElement(By.xpath("//textarea[@class=\"js-address-textarea\"]"));

        adres.sendKeys("Yazılım Caddesi, Java Mahallesi, Selenium Sokak, No:1996 Kat:101");

        Thread.sleep(2000);

        /*Adres için gereken bütün bilgiler girildiği için adresi kaydeder fakat "Adresi kaydet" seçeneği
          sayfanın aşağısında bulunduğundan dolayı, JavaScript kodu kullanılarak sayfayı aşağı kaydırır. "Adresi kaydet" seçeneğine
          tıklandıktan sonra üç saniye bekler.*/
        WebElement adresiKaydet = driver.findElement(By.xpath("//button[@class=\"button green js-set-country js-prevent-emoji\"]"));

        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",adresiKaydet);

        adresiKaydet.click();

        Thread.sleep(3000);

        //Adresi kaydedip ödeme ekranına geçmesi için "Kaydet ve Devam Et" butonuna tıklar.
        WebElement kaydetVeDevamEt = driver.findElement(By.xpath("//button[@class=\"button block green js-proceed-button\"]"));

        kaydetVeDevamEt.click();
        Thread.sleep(1000);

        //Ödeme ekranındaki bigiler doldurulmadan siparişi onaylar.
        WebElement siparisiOnayla = driver.findElement(By.xpath("(//button[@class=\"button block green continue-button\"])[2]"));

        siparisiOnayla.click();

        /*Son ekrana gelindiği ve "Siparişi Onayla" butonuna tıklandığının doğrulanması için, kredi kartı bilgileri
          girilmediğinden dolayı verilen mesaj metnini onaylayarak, istenilen testin başarıyla bitirildiğini onaylar.
          */
        WebElement hata = driver.findElement(By.xpath("(//span[@class=\"error\"])[2]"));

        Assert.assertEquals(hata.getText(),"Lütfen kart seçin veya kart bilgisi girin.");



    }





}
