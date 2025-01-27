package com.testinium;


import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileElement;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class StepSample extends SamplePage {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    private String kalkisYeri="";
    private  String inisYeri="";
    private String ad="";
    private String soyAd="";
    private String yolcuEmail="";
    private String yolcuTc="";
    private String ikiniYolcuAd="";
    private String ikinciYolcuSoyAd="";
    private String ikinciYolcuEmail="";
    private String ikinciYolcuTc="";


    public void readCsv() {
        String csvFile = "Excel/veriler.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";
        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] csvData = line.split(cvsSplitBy);
                kalkisYeri=csvData[0];
                System.out.println(kalkisYeri.substring(1));
                inisYeri =csvData[1];
                System.out.println(inisYeri);
                ad= csvData[2];
                soyAd=csvData[3];
                yolcuEmail=csvData[4];
                yolcuTc=csvData[5];
                ikiniYolcuAd=csvData[6];
                ikinciYolcuSoyAd=csvData[7];
                ikinciYolcuEmail=csvData[8];
                ikinciYolcuTc=csvData[9];
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Step("Bilet seçimi için yeni sayfaya aktırılacaksınız")
    public void biletSecimi() {
        appiumDriver.findElement(By.id("com.turkishairlines.mobile:id/acMain_btnBooking")).click();
    }

    @Step("Sayfa geçişi için <saniye> bekleyiniz")
    public void bekleyiniz(int saniye) {
        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    @Step("Nereden Nereye")
    public void ucusGuzergahi() throws Exception {
        readCsv();
        TimeUnit.SECONDS.sleep(1);
        appiumDriver.findElement(By.id("com.turkishairlines.mobile:id/frDashboard_tvFromCode")).click();
        TimeUnit.SECONDS.sleep(1);
        MobileElement el1 = appiumDriver.findElementById("com.turkishairlines.mobile:id/frAirportSelection_etSearch");
        el1.sendKeys(kalkisYeri.substring(1));
        TimeUnit.SECONDS.sleep(1);
        appiumDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.RelativeLayout[2]/android.widget.TextView[2]")).click();
        appiumDriver.findElement(By.id("com.turkishairlines.mobile:id/frDashboard_tvToCode")).click();
        TimeUnit.SECONDS.sleep(1);
        MobileElement el2 = appiumDriver.findElementById("com.turkishairlines.mobile:id/frAirportSelection_etSearch");
        el2.sendKeys(inisYeri.trim());
        appiumDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.RelativeLayout[2]/android.widget.TextView[2]")).click();
    }


    @Step("Uçuş Seçeneğiniz (Tek Yön - Gidiş Dönüş)")
    public void UcusSecenegi() {
        appiumDriver.findElement(By.id("com.turkishairlines.mobile:id/frDashboard_tvOneWay")).click();
    }

    @Step("Yetişkin Yolcu Sayısını Değiştirme")
    public void yetiskinBilgisi() {
        appiumDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.FrameLayout[7]/android.widget.TextView")).click();

    }

    @Step("Uçuş Ara Butonuna Tıklanır")
    public void ucusBtn() {
        appiumDriver.findElement(By.id("com.turkishairlines.mobile:id/frDashboard_btnSearch")).click();
    }

    @Step("Uçuşların Listelendiği Kontrol Edilir")
    public void kontrol() throws Exception {
        MobileElement el4 = appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView[2]/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup");
        Assert.assertEquals(el4, el4.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView[2]/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup")));
        logger.info("Uçuş liste Kontrolü");
    }


    @Step("Tarih Bilgisi Günün Tarihinden 2 Gün Sonraya Seçilir")
    public void tarihiSecimi() {
        MobileElement el3 = appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView[1]/android.view.ViewGroup[3]");
        el3.click();
    }

    @Step("Ekonomik Uçuş Seçilir ve Devam Buttonuna Tıklanır")
    public void ekonomikUcusSecimi() {
        appiumDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView[2]/android.view.ViewGroup[1]/android.widget.FrameLayout[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]")).click();
        appiumDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView[2]/android.view.ViewGroup[1]/android.widget.FrameLayout[2]/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup")).click();
        appiumDriver.findElement(By.id("com.turkishairlines.mobile:id/frFlightSearch_btnContinue")).click();
    }

    @Step("Ilk Yolcuyu Ekleyiniz")
    public void yolcuEkle() {
        MobileElement el4 = appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.ExpandableListView/android.widget.RelativeLayout[2]/android.widget.RelativeLayout");
        el4.click();
    }

    @Step("Yolcu Ekle Alanının Bilgileriniz <dGunu>")
    public void bilgiGirisi( String dGunu) throws InterruptedException, IOException {
        readCsv();
        MobileElement el5 = appiumDriver.findElementById("com.turkishairlines.mobile:id/frAddNewPassenger_etAddName");
        el5.sendKeys(ad);
        TimeUnit.SECONDS.sleep(1);

        MobileElement el6 = appiumDriver.findElementById("com.turkishairlines.mobile:id/frAddNewPassenger_etAddLastName");
        el6.sendKeys(soyAd);
        TimeUnit.SECONDS.sleep(1);
        MobileElement el8 = appiumDriver.findElementById("com.turkishairlines.mobile:id/frAddNewPassenger_etAddDateOfBirth");
        el8.sendKeys(dGunu);
        TimeUnit.SECONDS.sleep(1);
        MobileElement el9 = appiumDriver.findElementById("com.turkishairlines.mobile:id/frAddNewPassenger_etAddEmail");
        el9.sendKeys(yolcuEmail);
        TimeUnit.SECONDS.sleep(1);
        MobileElement el10 = appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.CheckBox[1]");
        el10.click();
        TimeUnit.SECONDS.sleep(1);
        MobileElement el11 = appiumDriver.findElementById("com.turkishairlines.mobile:id/frAddNewPassenger_etAddTCKN");
        el11.sendKeys(yolcuTc);
        MobileElement el18 = appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup/android.widget.CheckBox[2]");
        el18.click();
    }

    @Step("İkinci Yolcu Ekle Alanının Bilgileriniz <dGunu>")
    public void ikinicYolcuBilgiGirisi( String dGunu) throws InterruptedException, IOException {
        readCsv();
        MobileElement el5 = appiumDriver.findElementById("com.turkishairlines.mobile:id/frAddNewPassenger_etAddName");
        el5.sendKeys(ikiniYolcuAd);
        TimeUnit.SECONDS.sleep(1);
        MobileElement el6 = appiumDriver.findElementById("com.turkishairlines.mobile:id/frAddNewPassenger_etAddLastName");
        el6.sendKeys(ikinciYolcuSoyAd);
        TimeUnit.SECONDS.sleep(1);
        MobileElement el8 = appiumDriver.findElementById("com.turkishairlines.mobile:id/frAddNewPassenger_etAddDateOfBirth");
        el8.sendKeys(dGunu);
        TimeUnit.SECONDS.sleep(1);
        MobileElement el9 = appiumDriver.findElementById("com.turkishairlines.mobile:id/frAddNewPassenger_etAddEmail");
        el9.sendKeys(ikinciYolcuEmail);
        TimeUnit.SECONDS.sleep(1);
        MobileElement el10 = appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.CheckBox[1]");
        el10.click();
        TimeUnit.SECONDS.sleep(1);
        MobileElement el11 = appiumDriver.findElementById("com.turkishairlines.mobile:id/frAddNewPassenger_etAddTCKN");
        el11.sendKeys(ikinciYolcuTc);
        MobileElement el18 = appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup/android.widget.CheckBox[2]");
        el18.click();
    }


    @Step("Bilgileri Kaydet")
    public void kayit() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        MobileElement el12 = appiumDriver.findElementById("com.turkishairlines.mobile:id/frAddNewPassenger_btnAddPassenger");
        el12.click();
    }

    @Step("Cinsiyet Secimi <E/K> (Erkek için 1 - Kadın için 2) Seçiniz")
    public void cinsiyetBelireyiniz(String sayi) {
        MobileElement el7 = appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.widget.CheckBox[" + sayi + "]");
        el7.click();
    }

    @Step("Bir Sonraki Yolcu Seçimi İçin Tıkla")
    public void okBtn() {
        MobileElement el13 = appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.ExpandableListView/android.widget.RelativeLayout[4]/android.widget.RelativeLayout/android.widget.ImageView");
        el13.click();
    }

    @Step("İkinci Yolcuyu Ekleyiniz")
    public void kayitBtn() {
        MobileElement el14 = appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.ExpandableListView/android.widget.RelativeLayout[5]/android.widget.RelativeLayout/android.widget.TextView[1]");
        el14.click();


    }

    @Step("İşleri Bitir ve Uygulamayı Kapat")
    public void sonIslem() throws InterruptedException {
        MobileElement el15 = appiumDriver.findElementById("com.turkishairlines.mobile:id/frPickPassenger_btnContinue");
        el15.click();
        TimeUnit.SECONDS.sleep(2);
        MobileElement el16 = appiumDriver.findElementById("com.turkishairlines.mobile:id/toolbarBase_tvCancel");
        el16.click();
        TimeUnit.SECONDS.sleep(2);
        MobileElement el17 = appiumDriver.findElementById("com.turkishairlines.mobile:id/dgBase_btnPositive");
        el17.click();
    }

        @Step("Uçuşların Listelendiği Kontrol Ediliyor")
        public void ucusKontrolu() throws Exception {
        MobileElement el4 = (MobileElement) appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView[2]/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup");
        Assert.assertEquals( el4, el4.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView[2]/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup")));
        logger.info("Uçuş liste Kontrolü");
    }


}



