package api.apps.avito.SignIn;

import api.android.Android;
import api.interfaces.Activity;
import core.MyLogger;
import core.managers.DriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;

public class SignInView implements Activity {
    public SignInUiObjects uiObject=new SignInUiObjects();

    @Step("redirectToSignInView with login: {login} and password: {password}")
    public void SigningIn(String login,String password){
        try {
            MyLogger.log.info("Signing In to ... login: " + login + " Password: " + password);
            uiObject.emailFd().clearText().typeText(login);
            uiObject.passwordFd().clearText().typeText(password);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            uiObject.signInBtn().tap().waitToDisappear(15);
            Android.app.avito.myAccountView.waitToLoad();
        }catch (NoSuchElementException e){
            throw new AssertionError("cannot signIn with: "+login+"and"+password);
        }
    }

    @Step("redirectToSignInView with bad account: {login} and password: {password}")
    public void SigningInBadAccount(String login,String password){
        try {
            MyLogger.log.info("Signing In to ... login: " + login + " Password: " + password);
            uiObject.emailFd().typeText(login).waitToAppear(10);
            uiObject.passwordFd().typeText(password);
            uiObject.hideShowPassword().tap();
            //Android.adb.hideKeyboard();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            uiObject.signInBtn().tap();
            uiObject.snackBarBadAccount().waitToAppear(10);
        }catch (NoSuchElementException e){
            throw new AssertionError("cannot signIn bad account");
        }
    }

    @Step("reset password with email : {email}")
    public void resetPassword(String email){
        try {
            MyLogger.log.info("ResetPassword btn tapped");
            uiObject.forgotPasswordBtn().tap();
            uiObject.resetPasswordEmailFd().waitToAppear(10);
            uiObject.resetPasswordEmailFd().typeText(email);

            try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }

            Android.adb.tapToBackGround();
            Android.adb.tapToBackGround();

            uiObject.resetPasswordSendBtn().waitToAppear(10).tap();
            uiObject.resetPasswordDialogMessage().waitToAppear(10);
            MyLogger.log.info(uiObject.resetPasswordDialogMessage().getText());
            uiObject.resetPasswordDialogMessageBtnOk().waitToAppear(10).tap();
            Android.driver.navigate().back();
        } catch (NoSuchElementException e){
            throw new AssertionError("cannot reset password");
        }
    }

    @Step("Redirecting to signUp view")
    public void signUp(){
        try {
            MyLogger.log.info("Redirecting to signUp view");
            uiObject.signUpBtn().tap();
        } catch (NoSuchElementException e){
            throw new AssertionError("cannot redirect to signUp from SignInView");
        }
    }

    public void backToHomeView(){
        try {
            MyLogger.log.info("Redirecting back to home view");
            Android.driver.navigate().back();
        } catch (NoSuchElementException e){
            throw new AssertionError("error when tring to back to home");
        }
    }

    public void refresh(){
        try {
            MyLogger.log.info("Refreshing this view");
            Android.driver.navigate().refresh();
        } catch (NoSuchElementException e){
            throw new AssertionError("cannot refresh this view");
        }
    }

    @Step("Waiting for signInView to load all the elements")
    @Override
    public SignInView waitToLoad() {
        try {
            MyLogger.log.info("Waiting for SignInView activity to load all the elements");
            uiObject.emailFd().waitToAppear(25);
            return Android.app.avito.signInView;
        } catch (NoSuchElementException e){
            throw new AssertionError("SignInView failed to open/load");
        }
    }
}