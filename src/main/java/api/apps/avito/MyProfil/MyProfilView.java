package api.apps.avito.MyProfil;

import api.android.Android;
import api.interfaces.Activity;
import core.MyLogger;
import core.managers.DriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;

public class MyProfilView implements Activity{
    public MyProfilUiObjects uiObject=new MyProfilUiObjects();

    @Step("update my account - aucune modification")
    public void updateAccount(){
        try {
            MyLogger.log.info("update my account");

            MyLogger.log.info("action : aucune modification");
            uiObject.updateBtn().tap();

            Android.adb.tapToBackGround();
            Android.adb.tapToBackGround();

            uiObject.continuerBtn().waitToAppear(50).tap();
        } catch (NoSuchElementException e) {
            throw new AssertionError("error while updating account");
        }
    }

    @Step("Sign Out")
    public void signOut(){
        try {
            MyLogger.log.info("Sign Out");
            uiObject.logOutBtn().waitToAppear(20).tap();
            Android.app.avito.homeView.waitToLoad();
            Assert.assertEquals(".activities.MainActivity",Android.driver.currentActivity());
        } catch (NoSuchElementException e) {
            throw new AssertionError("error while Sign out from my profile");
        }
    }

    @Override
    @Step("Waiting for MyProfilView activity to load all the elements")
    public Object waitToLoad() {
        try{
            MyLogger.log.info("Waiting for MyProfilView activity to load all the elements");
            uiObject.email().waitToAppear(15);
            return Android.app.avito.myProfilView;

        }catch (AssertionError e){
            throw new AssertionError("MyProfilView activity failed to load/open");
        }
    }
}