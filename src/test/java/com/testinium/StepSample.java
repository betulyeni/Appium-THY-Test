package com.testinium;

import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileElement;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

    public class StepSample extends SamplePage {

        private Logger logger = LoggerFactory.getLogger(getClass());

        @Step("Bilet seçimi için yeni sayfaya aktırılacaksınız")
        public void biletSecimi(){
            appiumDriver.findElement(By.id("com.turkishairlines.mobile:id/acMain_btnBooking")).click();
        }
        @Step({"Sayfa geçişi için <saniye> bekleyiniz"})
        public void bekleyiniz(int saniye) {
            try {
                Thread.sleep(saniye * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
            @Step("Nereden <bulundugunYer> Nereye <gidecegiYer>")
            public void ucusGuzergahi(String gidecegiYer, String bulundugunYer){
            appiumDriver.findElement(By.id("com.turkishairlines.mobile:id/frDashboard_tvFromCode")).click();
            MobileElement el1 = (MobileElement) appiumDriver.findElementById("com.turkishairlines.mobile:id/frAirportSelection_etSearch");
            el1.sendKeys(gidecegiYer);
            appiumDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.RelativeLayout[2]/android.widget.TextView[2]")).click();
            appiumDriver.findElement(By.id("com.turkishairlines.mobile:id/frDashboard_tvToCode")).click();
            MobileElement el2 = (MobileElement) appiumDriver.findElementById("com.turkishairlines.mobile:id/frAirportSelection_etSearch");
            el2.sendKeys(bulundugunYer);
            appiumDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.RelativeLayout[2]/android.widget.TextView[2]")).click();
        }
        @Step("Uçuş Seçeneğiniz (Tek Yön - Gidiş Dönüş)")
        public void UcusSecenegi(){
            appiumDriver.findElement(By.id("com.turkishairlines.mobile:id/frDashboard_tvOneWay")).click();
        }

        @Step("Yetişkin Yolcu Sayısını Değiştirme")
        public void yetiskinBilgisi(){
            appiumDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.FrameLayout[7]/android.widget.TextView")).click();

        }
        @Step("Uçuş Ara Butonuna Tıklanır")
        public void ucusBtn(){
            appiumDriver.findElement(By.id("com.turkishairlines.mobile:id/frDashboard_btnSearch")).click();
        }

        @Step("Tarih Bilgisi Günün Tarihinden 2 Gün Sonraya Seçilir")
        public void tarihiSecimi() {
            MobileElement el3 = (MobileElement) appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView[1]/android.view.ViewGroup[3]");
            el3.click();
        }
        @Step("Ekonomik Uçuş Seçilir ve Devam Buttonuna Tıklanır")
        public void ekonomikUcusSecimi(){
            appiumDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView[2]/android.view.ViewGroup[1]/android.widget.FrameLayout[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]")).click();
            appiumDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView[2]/android.view.ViewGroup[1]/android.widget.FrameLayout[2]/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup")).click();
            appiumDriver.findElement(By.id("com.turkishairlines.mobile:id/frFlightSearch_btnContinue")).click();
        }







    }



