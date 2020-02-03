package api.apps.avito.NavigationDrawer;

import api.android.Android;
import core.UiObject;
import core.UiSelector;

public class NavigationDrawerUiObjects {
    private static UiObject

    userName,
    userImage,
    adInsertBtn,
    loginBtn,
    myProfilBtn,
    chatBtn,
    arabicBtn,
    contactUsBtn,
    informationBtn

    ;

    public UiObject userName(){
        if(userName == null) userName = new UiSelector().resourceId(Android.app.avito.packageID()+":id/account_label").makeUiObject();
        return userName;
    }

    public UiObject userImage(){
        if(userImage == null) userImage = new UiSelector().resourceId(Android.app.avito.packageID()+":id/account_status_icon").makeUiObject();
        return userImage;
    }

    public UiObject adInsertBtn(){
        if(adInsertBtn == null) adInsertBtn = new UiSelector().resourceId(Android.app.avito.packageID()+":id/drawer_ad_insert_cta").makeUiObject();
        return adInsertBtn;
    }

    public UiObject loginBtn(){
        if(loginBtn == null) loginBtn = new UiSelector().textContains("Se connecter").makeUiObject();
        return loginBtn;
    }

    public UiObject myProfilBtn(){
        if(myProfilBtn == null) myProfilBtn = new UiSelector().textContains("Mon profil").makeUiObject();
        return myProfilBtn;
    }

    public UiObject chatBtn(){
        if(chatBtn == null) chatBtn = new UiSelector().textContains("Chat").makeUiObject();
        return chatBtn;
    }

    public UiObject contactUsBtn(){
        if(contactUsBtn == null) contactUsBtn = new UiSelector().textContains("Contactez nous").makeUiObject();
        return contactUsBtn;
    }

    public UiObject informationBtn(){
        if(informationBtn == null) informationBtn = new UiSelector().textContains("Informations").makeUiObject();
        return informationBtn;
    }
}