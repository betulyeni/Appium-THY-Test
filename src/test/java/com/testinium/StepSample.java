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
       

    }



