 package tests.avito.SignIn;

import api.android.Android;
import api.data.SignInData;
import core.listeners.TestListener;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners(TestListener.class)
@Test(description = "redirectToSignInView")
public class SignIn {
    private SignInData signInData;

    @Test(description = "Redirecting to Navigation menu")
    public void redirectingToNavigationViewToSignIn(){
        Android.app.avito.homeView.redirectToNavMenu();
        Android.app.avito.navigationDrawerView.waitToLoad();

        Assert.assertTrue(Android.app.avito.navigationDrawerView.uiObject.chatBtn().exists());
        Assert.assertTrue(Android.app.avito.navigationDrawerView.uiObject.adInsertBtn().exists());
        Assert.assertTrue(Android.app.avito.navigationDrawerView.uiObject.contactUsBtn().exists());
        Assert.assertTrue(Android.app.avito.navigationDrawerView.uiObject.informationBtn().exists());
    }

    @Test(description = "Redirecting to signIn view",dependsOnMethods = "redirectingToNavigationViewToSignIn")
    public void redirectingToSignInViewToSignIn(){

        Android.app.avito.navigationDrawerView.redirectToSignInView();
        Android.app.avito.signInView.waitToLoad();

        Assert.assertTrue(Android.app.avito.signInView.uiObject.emailFd().exists());
        Assert.assertTrue(Android.app.avito.signInView.uiObject.passwordFd().exists());
        Assert.assertTrue(Android.app.avito.signInView.uiObject.signInBtn().exists());
        Assert.assertTrue(Android.app.avito.signInView.uiObject.signUpBtn().exists());
        Assert.assertTrue(Android.app.avito.signInView.uiObject.forgotPasswordBtn().exists());

    }

    @Test(description = "Sign in with my login and password and redirect to the homeview",dependsOnMethods = {"redirectingToSignInViewToSignIn"})
    public void signingIn(){
        signInData=new SignInData("chouaibtest1@gmail.com","azertyavito","fauxpassword");
        Android.app.avito.signInView.SigningIn(signInData.getEmail(),signInData.getPassword());
        Android.app.avito.homeView.redirectToListingView();
        Android.app.avito.listingView.waitToLoad();
    }
}