package tests.avito;

import core.managers.DriverManager;
import org.testng.annotations.Test;

@Test(description = "Create Android driver")
public class CreateAvitoAndroidDriver {

    @Test(description = "Create AndroidDriver")
    public void launchServiceDriver(){
        //use createAwsAvitoDriver before generating zip with dependencies
        DriverManager.createAvitoDriver();
    }
}