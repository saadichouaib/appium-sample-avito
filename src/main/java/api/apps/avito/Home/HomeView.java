/*
This class handles Redirection to filterView / DrawerNavigationMenuView / BottomNavigationTabs / AdinsertFabButton
 */

package api.apps.avito.Home;

import api.android.Android;
import api.data.SignInData;
import api.interfaces.Activity;
import core.MyLogger;
import core.Utils;
import core.managers.DriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;

import javax.rmi.CORBA.Util;

public class HomeView implements Activity{
    public HomeUiObjects uiObject = new HomeUiObjects();
    private SignInData signInData;

    //Actions from toolbar
    @Step("Redirecting to Navigation Drawer Menu")
    public void redirectToNavMenu(){
        try{
            MyLogger.log.info("Redirection into Navigation drawer Menu");
            uiObject.menuNavigation().waitToAppear(10).tap();
        }catch (NoSuchElementException e){
            throw new AssertionError("cannot redirect to the Nav menu");
        }
    }

    @Step("Redirecting to the search ad view")
    public void redirectToSearchView(){
        try {
            MyLogger.log.info("Redirection to the ad Search view");
            uiObject.filters().waitToAppear(50).tap();
        } catch (NoSuchElementException e){
            throw new AssertionError("cannot redirect to search filter");
        }
    }

    //Actions From ControlBar
    @Step("Save a search from homeView")
    public void saveASearch(){
        try {
            signInData=new SignInData("chouaibtest1@gmail.com","azertyavito","fauxpassword");
            MyLogger.log.info("Save this search");

            if(uiObject.saveSearchBtn().exists()) {

                if (!uiObject.saveSearchBtn().isSelected()) {
                    uiObject.saveSearchBtn().tap();
                    if(Android.app.avito.signInView.uiObject.emailFd().exists()){
                        Android.app.avito.signInView.SigningIn(signInData.getEmail(),signInData.getPassword());
                    }
                } else {
                    MyLogger.log.info("this search is already selected");
                    MyLogger.log.info("unselect");
                    uiObject.saveSearchBtn().tap();
                    MyLogger.log.info("reselect");
                    uiObject.saveSearchBtn().tap();
                }
            }else{
                MyLogger.log.info("You need to do a search before saving it ... choose a search class in the TestPrimer class");
            }
        } catch (NoSuchElementException e){
            throw new AssertionError("cannot save this Search");
        }
    }

    //Actions From Bottom Navigation
    @Step("Redirecting to Listing")
    public void redirectToListingView(){
        try{
            MyLogger.log.info("Redirection into Listing");
            uiObject.listingBottomTab().waitToAppear(20).tap();
        }catch (NoSuchElementException e){
            throw new AssertionError("cannot redirect to the Listing view");
        }
    }

    @Step("Redirecting to Messaging")
    public void redirectToMessagingView(){
        try{
            MyLogger.log.info("Redirection into Messaging");
            uiObject.messagingBottomTab().waitToAppear(10).tap();
        }catch (NoSuchElementException e){
            throw new AssertionError("cannot redirect to the Messaging view");
        }
    }

    @Step("Redirecting to my Account")
    public void redirectToMyAccountView(){
        try{
            MyLogger.log.info("Redirection into my account");
            uiObject.myAccountBottomTab().waitToAppear(10).tap();
        }catch (NoSuchElementException e){
            throw new AssertionError("cannot redirect to the my account view");
        }
    }

    @Step("Redirecting to Notification")
    public void redirectToNotificationsView(){
        try{
            MyLogger.log.info("Redirection into Notifications view");
            uiObject.notificationBottomTab().waitToAppear(10).tap();
        }catch (NoSuchElementException e){
            throw new AssertionError("cannot redirect to the Notifications view");
        }
    }

    @Step("Redirecting to the ad insertion view from Fab button")
    public void redirectToAdInsertForm(){
        try{
            MyLogger.log.info("Redirection into the ad insertion view from fab button");
            uiObject.fabBtn().waitToAppear(50).tap();
        }catch (NoSuchElementException e){
            throw new AssertionError("cannot redirect to the ad insertion view from fab btn");
        }
    }

    @Step("Waiting for HomeView activity to load all the elements")
    @Override
    public HomeView waitToLoad() {
        try {
            if(!uiObject.filters().exists() && uiObject.frenchBtn().exists()){
                MyLogger.log.info("language button exists");
                uiObject.frenchBtn().tap();
                Android.adb.tapToBackGround();
                Android.adb.tapToBackGround();
            }

            if(uiObject.marketingOnBoarding().exists()){
                uiObject.marketingOnBoardingSuivantBtn().tap();
                Utils.waitWait(2000);
                uiObject.marketingOnBoardingFermerBtn().tap();
            }

            MyLogger.log.info("Waiting for HomeView activity to load all the elements");
            uiObject.filters().waitToAppear(120);
            uiObject.menuNavigation().waitToAppear(120);
            //Android.app.avito.listingView.waitToLoad();
            return Android.app.avito.homeView;
        } catch (NoSuchElementException e){
            throw new AssertionError("HomeView failed to load/open");
        }
    }
}