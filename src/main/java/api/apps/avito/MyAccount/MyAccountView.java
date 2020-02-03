package api.apps.avito.MyAccount;

import api.android.Android;
import api.interfaces.Activity;
import core.MyLogger;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;

public class MyAccountView implements Activity {
    MyAccountUiObjects uiObject=new MyAccountUiObjects();

    @Step("Redirect To my Ads view")
    public void redirectToMyAdsView(){
        try {
            MyLogger.log.info("Redirect To My Ads View");
            uiObject.myAdsTab().waitToAppear(5).tap();
        } catch (NoSuchElementException e) {
            throw new AssertionError("cannot redirect to My Ads View");
        }
    }

    @Step("Redirect To my Favourite Ads view")
    public void redirectToMyFavouriteAdsView(){
        try {
            MyLogger.log.info("Redirect To My Favourite Ads View");
            uiObject.myFavouriteAdsTab().waitToAppear(5).tap();
        } catch (NoSuchElementException e) {
            throw new AssertionError("cannot redirect to Favourite ads view");
        }
    }

    @Step("Redirect To my saved search view")
    public void redirectToMySavedSearchView(){
        try {
            MyLogger.log.info("Redirect To Saved Search View");
            uiObject.mySavedSearchTab().waitToAppear(5).tap();
        } catch (NoSuchElementException e) {
            throw new AssertionError("cannot redirect to Saved search View");
        }
    }

    @Step("Waiting for MyAccountView activity to load all the element")
    @Override
    public MyAccountView waitToLoad() {
        try{
            MyLogger.log.info("Waiting for MyAccountView activity to load all the elements");

            if(uiObject.loginBtn().exists()){
                MyLogger.log.info("you're disconnected ...");
            }
            else{
                uiObject.myAdsTab().waitToAppear(50);
            }
            return Android.app.avito.myAccountView;

        }catch (AssertionError e){
            throw new AssertionError("MyAccountView activity failed to load/open");
        }
    }
}