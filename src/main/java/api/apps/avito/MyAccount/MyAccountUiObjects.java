package api.apps.avito.MyAccount;

import api.android.Android;
import core.UiObject;
import core.UiSelector;

public class MyAccountUiObjects {
    private UiObject

    loginBtn,
    myAdsTab,
    myFavouriteAdsTab,
    mySavedSearchTab

    ;

    public UiObject loginBtn(){
        if(loginBtn == null) loginBtn = new UiSelector().resourceId(Android.app.avito.packageID()+":id/loginButton").makeUiObject();
        return loginBtn;
    }

    public UiObject myAdsTab(){
        if(myAdsTab == null) myAdsTab = new UiSelector().className("android.widget.ImageView").instance(1).makeUiObject();
        return myAdsTab;
    }

    public UiObject myFavouriteAdsTab(){
        if(myFavouriteAdsTab == null) myFavouriteAdsTab = new UiSelector().className("android.widget.ImageView").instance(2).makeUiObject();
        return myFavouriteAdsTab;
    }

    public UiObject mySavedSearchTab(){
        if(mySavedSearchTab == null) mySavedSearchTab = new UiSelector().className("android.widget.ImageView").instance(3).makeUiObject();
        return mySavedSearchTab;
    }
}