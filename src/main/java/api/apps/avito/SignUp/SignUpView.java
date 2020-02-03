package api.apps.avito.SignUp;

import api.android.Android;
import api.data.SignUpData;
import api.interfaces.Activity;
import core.Utils;
import core.MyLogger;
import core.UiObject;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;

public class SignUpView implements Activity{
    public SignUpUiObjects uiObject=new SignUpUiObjects();

    public SignUpData data;//=new SignUpData("QAname","123456",1,"fr",1,"Casablanca");

    @Step("Signing up ... login: {randomemail} Password: {data.password}")
    public void signUp(){
        try {
            data = new SignUpData("chouaib",
                    Utils.randomEmail(),
                    "123456",
                    1,
                    "fr",
                    1,
                    Utils.randomPhone(),
                    2);

            MyLogger.log.info("Signing up ... login: " + data.getEmail() + " Password: " + data.getPassword());

            MyLogger.log.info("name: " + data.getName());
            uiObject.nameFd().typeText(data.getName());
            //Android.driver.hideKeyboard();

            MyLogger.log.info("randomemail: " + data.getEmail());
            uiObject.emailFd().typeText(data.getEmail());
            //Android.driver.hideKeyboard();

            MyLogger.log.info("randomphone: " + data.getPhone());
            uiObject.phoneFd().typeText(data.getPhone());
            //Android.driver.hideKeyboard();

            MyLogger.log.info("hideshowPhoneSwitch: " + data.getPhoneHidden());
            if (data.getPhoneHidden()==0) uiObject.hideShowPhoneSwitch().tap();

            MyLogger.log.info("password: " + data.getPassword());
            uiObject.passwordFd().typeText(data.getPassword());
            //Android.driver.hideKeyboard();

            MyLogger.log.info("scrolling...");
            uiObject.typePrivateRb().scrollTo();

            MyLogger.log.info("confirm password: " + data.getPassword());
            uiObject.rePasswordFd().typeText(data.getPassword());
            //Android.driver.hideKeyboard();

            MyLogger.log.info("city: " + data.getCity());
            uiObject.city().typeTextAC("casa");
            MyLogger.log.info("choose city from auto completes list");
            UiObject.tapAutoCompleteSelection(uiObject.city());

            MyLogger.log.info("User type: " + data.getCity());
            if (data.getAccountType()==1) uiObject.typeProfessionalRb().waitToAppear(5).tap();

            MyLogger.log.info("Tap Inscription Btn");
            uiObject.inscriptionBtn().tap();

            MyLogger.log.info("Login to: " + data.randomphone() + " " + data.getPassword());
            uiObject.seConnecterBtn().waitToAppear(20).tap();

            Android.app.avito.myAccountView.waitToLoad();
        }catch (NoSuchElementException e){
            throw new AssertionError("cannot sign up");
        }
    }

    @Step("Waiting for SignUpView activity to load all the elements")
    @Override
    public Object waitToLoad() {
        try {
            MyLogger.log.info("Waiting for SignUpView activity to load all the elements");
            uiObject.nameFd().waitToAppear(10);
            return Android.app.avito.signUpView;
        }catch (NoSuchElementException e){
            throw new AssertionError("SignUpView failed to load/open");
        }
    }
}