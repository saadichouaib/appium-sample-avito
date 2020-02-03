package api.apps.avito.SignUp;

import api.android.Android;
import core.UiObject;
import core.UiSelector;

public class SignUpUiObjects {

    public static UiObject
    nameFd,
    emailFd,
    phoneFd,
    hideShowPhoneSwitch,
    passwordFd,
    rePasswordFd,
    citylist,
    city,
    typePrivateRb,
    typeProfessionalRb,
    inscriptionBtn,
    seConnecterBtn

    ;

    public UiObject nameFd() {
        if(nameFd==null) nameFd = new UiSelector().resourceId(Android.app.avito.packageID()+":id/ic_full_name").makeUiObject();
        return nameFd;
    }

    public UiObject emailFd() {
        if(emailFd==null) emailFd = new UiSelector().resourceId(Android.app.avito.packageID()+":id/ac_mail").makeUiObject();
        return emailFd;
    }

    public UiObject phoneFd() {
        if(phoneFd==null) phoneFd = new UiSelector().resourceId(Android.app.avito.packageID()+":id/ac_phone").makeUiObject();
        return phoneFd;
    }

    public UiObject hideShowPhoneSwitch() {
        if(hideShowPhoneSwitch==null) hideShowPhoneSwitch = new UiSelector().resourceId(Android.app.avito.packageID()+":id/ac_hide_phone").makeUiObject();
        return hideShowPhoneSwitch;
    }

    public UiObject passwordFd() {
        if(passwordFd==null) passwordFd = new UiSelector().resourceId(Android.app.avito.packageID()+":id/ac_password").makeUiObject();
        return passwordFd;
    }

    public UiObject rePasswordFd() {
        if(rePasswordFd==null) rePasswordFd = new UiSelector().resourceId(Android.app.avito.packageID()+":id/ac_confirm_password").makeUiObject();
        return rePasswordFd;
    }

    public UiObject city(){
        if(city==null) city = new UiSelector().resourceId(Android.app.avito.packageID()+":id/cityAutoComplete").makeUiObject();
        return city;
    }

    public UiObject typePrivateRb() {
        if(typePrivateRb==null) typePrivateRb = new UiSelector().text("Particulier").makeUiObject();
        return typePrivateRb;
    }

    public UiObject typeProfessionalRb() {
        if(typeProfessionalRb==null) typeProfessionalRb = new UiSelector().resourceId(Android.app.avito.packageID()+":id/radiobtn_professional").makeUiObject();
        return typeProfessionalRb;
    }

    public UiObject inscriptionBtn() {
        if(inscriptionBtn==null) inscriptionBtn = new UiSelector().textContains("INSCRIPTION").makeUiObject();
        return inscriptionBtn;
    }

    public UiObject seConnecterBtn() {
        if(seConnecterBtn==null) seConnecterBtn = new UiSelector().textContains("SE CONNECTER").makeUiObject();
        return seConnecterBtn;
    }
}
