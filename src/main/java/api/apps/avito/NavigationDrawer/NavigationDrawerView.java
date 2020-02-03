package api.apps.avito.NavigationDrawer;

import api.android.Android;
import api.interfaces.Activity;
import core.MyLogger;
import core.managers.DriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;

public class NavigationDrawerView implements Activity {
    public NavigationDrawerUiObjects uiObject=new NavigationDrawerUiObjects();

    @Step("Redirecting to adInsertView")
    public void redirectToAdInsertFormView(){
        MyLogger.log.info("redirecting to ad insert view");
        try{
            uiObject.adInsertBtn().waitToAppear(10).tap();
        }catch (NoSuchElementException e){
            throw new AssertionError("cannot redirect to the ad insertion view");
        }
    }

    @Step("Redirecting to the signIn view")
    public void redirectToSignInView(){
        try {
            if(uiObject.myProfilBtn().exists()) {
                MyLogger.log.info("account already connected ... it will be logged out in few seconds");
                Android.app.avito.navigationDrawerView.redirectToMyProfilView();
                Android.app.avito.myProfilView.waitToLoad();
                Android.app.avito.myProfilView.signOut();
                Android.app.avito.homeView.redirectToNavMenu();
                Android.app.avito.navigationDrawerView.redirectToSignInView();
            }
            else if(!uiObject.myProfilBtn().exists()){
                MyLogger.log.info("Redirect to sign In page");
                uiObject.loginBtn().waitToAppear(20).tap();
            }
        } catch (NoSuchElementException e) {
            throw new AssertionError("cannot redirect to signIn view");
        }
    }

    @Step("Redirecting to my profil view")
    public void redirectToMyProfilView(){
        try {
            MyLogger.log.info("redirecting to my profil view");
            if(uiObject.myProfilBtn().exists())
                uiObject.myProfilBtn().waitToAppear(10).tap();
            else if(!uiObject.myProfilBtn().exists())
                MyLogger.log.info("you're not connected, no need to sign out");
        } catch (NoSuchElementException e) {
            throw new AssertionError("cannot redirect to MyProfil view");
        }
    }

    @Step("Redirecting to chat view")
    public void redirectToChatView(){
        MyLogger.log.info("redirecting to Chat view");
        try{
            uiObject.chatBtn().waitToAppear(10).tap();
        }catch (NoSuchElementException e){
            throw new AssertionError("cannot redirect to Chat view");
        }
    }

    @Step("Redirecting to Contact us view")
    public void redirectToContactUsView(){
        MyLogger.log.info("redirecting to Contact us view");
        try{
            uiObject.contactUsBtn().waitToAppear(10).tap();
        }catch (NoSuchElementException e){
            throw new AssertionError("cannot redirect to Contact us view");
        }
    }

    @Step("Redirecting to Information view")
    public void redirectToInformationView(){
        MyLogger.log.info("redirecting to Information view");
        try{
            uiObject.informationBtn().waitToAppear(10).tap();
        }catch (NoSuchElementException e){
            throw new AssertionError("cannot redirect to Information view");
        }
    }

    @Step("Waiting for NavigationDrawerView to load all the elements")
    @Override
    public NavigationDrawerView waitToLoad() {
        try {
            MyLogger.log.info("Waiting for NavigationDrawerView to load all the elements");
            uiObject.adInsertBtn().waitToAppear(20);
            uiObject.chatBtn().waitToAppear(20);
            uiObject.contactUsBtn().waitToAppear(20);
            uiObject.informationBtn().waitToAppear(20);
            return Android.app.avito.navigationDrawerView;
        } catch (NoSuchElementException e) {
            throw new AssertionError("Navigationdrawer failed to load/open");
        }
    }
}