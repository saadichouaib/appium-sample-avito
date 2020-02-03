package api.apps.avito.SignIn;

import api.android.Android;
import core.UiObject;
import core.UiSelector;

public class SignInUiObjects {

    public static UiObject
        emailFd,
        passwordFd,
        signInBtn,
        hideShowPassword,
        forgotPasswordBtn,
        signUpBtn,
        resetPasswordEmailFd,
        resetPasswordSendBtn,
        resetPasswordDialogMessage,
        resetPasswordDialogMessageBtnOk,
        snackBarBadAccount;

    public UiObject emailFd() {
        if(emailFd==null) emailFd = new UiSelector().resourceId(Android.app.avito.packageID()+":id/edit_text").instance(0).makeUiObject();
        return emailFd;
    }

    public UiObject forgotPasswordBtn() {
        if(forgotPasswordBtn==null) forgotPasswordBtn = new UiSelector().resourceId(Android.app.avito.packageID()+":id/tv_forgot_passwd").makeUiObject();
        return forgotPasswordBtn;
    }

    public UiObject hideShowPassword() {
        if(hideShowPassword==null) hideShowPassword = new UiSelector().resourceId(Android.app.avito.packageID()+":id/text_input_password_toggle").makeUiObject();
        return hideShowPassword;
    }

    public UiObject passwordFd() {
        if(passwordFd==null) passwordFd = new UiSelector().resourceId(Android.app.avito.packageID()+":id/edit_text").instance(1).makeUiObject();
        return passwordFd;
    }

    public UiObject signInBtn() {
        if(signInBtn==null) signInBtn = new UiSelector().resourceId(Android.app.avito.packageID()+":id/signin_btn").makeUiObject();
        return signInBtn;
    }

    public UiObject signUpBtn() {
        if(signUpBtn==null) signUpBtn = new UiSelector().resourceId(Android.app.avito.packageID()+":id/tv_signup").makeUiObject();
        return signUpBtn;
    }

    public UiObject resetPasswordEmailFd() {
        if(resetPasswordEmailFd==null) resetPasswordEmailFd = new UiSelector().resourceId(Android.app.avito.packageID()+":id/email_field").makeUiObject();
        return resetPasswordEmailFd;
    }

    public UiObject resetPasswordSendBtn() {
        if(resetPasswordSendBtn==null) resetPasswordSendBtn = new UiSelector().xPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v7.widget.an/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button").makeUiObject();
        return resetPasswordSendBtn;
    }

    public UiObject resetPasswordDialogMessage() {
        if(resetPasswordDialogMessage==null) resetPasswordDialogMessage = new UiSelector().resourceId(Android.app.avito.packageID()+":id/dialog_message").makeUiObject();
        return resetPasswordDialogMessage;
    }

    public UiObject resetPasswordDialogMessageBtnOk() {
        if(resetPasswordDialogMessageBtnOk==null) resetPasswordDialogMessageBtnOk = new UiSelector().xPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v7.widget.an/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button").makeUiObject();
        return resetPasswordDialogMessageBtnOk;
    }
/*
    public UiObject snackBarBadAccount() {
        if(snackBarBadAccount==null) snackBarBadAccount = new UiSelector().resourceId(Android.app.tests.avito.packageID()+":id/snackbar_text").makeUiObject();
        return snackBarBadAccount;
    }
*/
    public UiObject snackBarBadAccount() {
        if(snackBarBadAccount==null) snackBarBadAccount = new UiSelector().text("Echec de connexion, e-mail ou mot de passe incorrect. Merci de réessayer").makeUiObject();
        return snackBarBadAccount;
    }

}