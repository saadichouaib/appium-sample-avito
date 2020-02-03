package tests;

import core.managers.DriverManager;

import org.testng.annotations.Test;
import java.io.IOException;


@Test(description = "Stopping Appium service")
public class StopAppiumService {

    @Test(description = "Stop Appiul Service")
    public void StopService(){
        try {
            DriverManager.AppiumService().stop();
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }
}
