package core;

import api.android.Android;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.Dimension;

import java.security.SecureRandom;
import java.util.Random;

public class Utils {
    private static final String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static SecureRandom rnd = new SecureRandom();

    public void scrollDownManually() {
        Dimension size = Android.driver.manage().window().getSize();
        int starty = (int) (size.height * 0.80);
        int endy = (int) (size.height * 0.20);
        int startx = size.width / 2;

        Android.driver.swipe(startx, starty, startx, endy, 1000);
    }

    public void scrollUpManually() {
        Dimension size = Android.driver.manage().window().getSize();
        int starty = (int) (size.height * 0.40);
        int endy = (int) (size.height * 0.90);
        int startx = size.width / 2;

        Android.driver.swipe(startx, starty, startx, endy, 1000);
    }

    public void tapRandomlyOnScreen(){
        TouchAction tapCoordinates = new TouchAction(Android.driver); //where driver is AppiumDriver
        tapCoordinates.tap(100,300).perform();
    }

    public static String randomEmail() {
        Random rand = new Random();
        int randomnumber = rand.nextInt(99999) + 1;

        return "qatest" + randomnumber + "@gmail.com";
    }

    public static String randomPhone() {
        Random rand = new Random();
        int randomphone = rand.nextInt(666666) + 111111;
        return "0656" + randomphone;
    }

    public static String randomText(int len){
        StringBuilder randomstring = new StringBuilder(len);
        for( int i = 0; i < len; i++ ) randomstring.append( AB.charAt( rnd.nextInt(AB.length())));

        return "testQA "+randomstring+" test";
    }

    public static String randomTextEmpty(int len){
        StringBuilder randomstring = new StringBuilder(len);
        for( int i = 0; i < len; i++ ) randomstring.append( AB.charAt( rnd.nextInt(AB.length())));

        return randomstring.toString();
    }

    public static void waitWait(int seconds){
        Timer timer = new Timer();
        timer.start();
        while(!timer.expired(seconds)) { }
    }
}
