package tests;

import core.MyLogger;
import core.managers.DriverManager;
import org.apache.log4j.Level;
import org.testng.annotations.Test;


@Test(description = "Start Appium service")
public class StartAppiumService {

    @Test(description = "start Appium programmatically")
    public void startAppiumProgrammatically(){
        MyLogger.log.setLevel(Level.INFO);
        try {
            if(DriverManager.isAppiumServerRunning(DriverManager.appiumPort)==false) {
                MyLogger.log.info("the port "+DriverManager.appiumPort+" is not used ... creating appium service on "+DriverManager.appiumHost+":"+DriverManager.appiumPort);
                DriverManager.AppiumService().start();
            }
            else{
                MyLogger.log.info("the port "+DriverManager.appiumPort+" is already in use");
                MyLogger.log.info("stopping appium service ...");
                DriverManager.AppiumService().stop();
                MyLogger.log.info("starting new appium service ...");
                DriverManager.AppiumService().start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}