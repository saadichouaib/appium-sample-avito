package api.apps.avito.MyProfil;

import api.android.Android;
import core.UiObject;
import core.UiSelector;

public class MyProfilUiObjects {
    public static UiObject
    fullName,
    phone,
    hidePhoneSwitch,
    email,
    changePasswordBtn,
    logOutBtn,
    cityLt,
    cityFd,
    updateBtn,
    cancelBtn,
    continuerBtn
            ;

    public UiObject continuerBtn() {
        if(continuerBtn==null) continuerBtn = new UiSelector().xPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v7.widget.LinearLayoutCompat/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button").makeUiObject();
        return continuerBtn;
    }

    public UiObject fullName() {
        if(fullName==null) fullName = new UiSelector().resourceId(Android.app.avito.packageID()+":id/acetAcFullName").makeUiObject();
        return fullName;
    }

    public UiObject phone() {
        if(phone==null) phone = new UiSelector().resourceId(Android.app.avito.packageID()+":id/acetAcPhone").makeUiObject();
        return phone;
    }

    public UiObject hidePhoneSwitch() {
        if(hidePhoneSwitch==null) hidePhoneSwitch = new UiSelector().resourceId(Android.app.avito.packageID()+":id/ac_hide_phone").makeUiObject();
        return hidePhoneSwitch;
    }

    public UiObject email() {
        if(email==null) email = new UiSelector().resourceId(Android.app.avito.packageID()+":id/acetAcEmail").makeUiObject();
        return email;
    }

    public UiObject changePasswordBtn() {
        if(changePasswordBtn==null) changePasswordBtn = new UiSelector().resourceId(Android.app.avito.packageID()+":id/update_passwd_btn").makeUiObject();
        return changePasswordBtn;
    }

    public UiObject logOutBtn() {
        if(logOutBtn==null) logOutBtn = new UiSelector().resourceId(Android.app.avito.packageID()+":id/logout_btn").makeUiObject();
        return logOutBtn;
    }

    public UiObject cityLt() {
        if(cityLt==null) cityLt = new UiSelector().resourceId(Android.app.avito.packageID()+":id/ac_city_field").makeUiObject();
        return cityLt;
    }

    public UiObject cityFd() {
        if(cityFd==null) cityFd = new UiSelector().resourceId(Android.app.avito.packageID()+":id/").makeUiObject();
        return cityFd;
    }

    public UiObject updateBtn() {
        if(updateBtn==null) updateBtn = new UiSelector().resourceId(Android.app.avito.packageID()+":id/btnUpdate").makeUiObject();
        return updateBtn;
    }

    public UiObject cancelBtn() {
        if(cancelBtn==null) cancelBtn = new UiSelector().resourceId(Android.app.avito.packageID()+":id/btnCancel").makeUiObject();
        return cancelBtn;
    }
}