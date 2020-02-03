package api.apps.avito;

import api.android.Android;
import api.apps.avito.Home.HomeView;
import api.apps.avito.Listing.ListingView;
import api.apps.avito.MyAccount.MyAccountView;
import api.apps.avito.MyProfil.MyProfilView;
import api.apps.avito.NavigationDrawer.NavigationDrawerUiObjects;
import api.apps.avito.NavigationDrawer.NavigationDrawerView;
import api.apps.avito.SignIn.SignInView;
import api.apps.avito.SignUp.SignUpView;
import api.data.HomeData;
import api.interfaces.Application;
import core.MyLogger;
import core.Utils;
import core.apiClients.AdInsertClient;
import core.apiClients.SignInClient;
import core.apiClients.SignUpClient;

public class Avito implements Application{
    public Utils utils = new Utils();

    public HomeData homeData = new HomeData();
    public HomeView homeView = new HomeView();
    public SignInView signInView =new SignInView();
    public SignUpView signUpView=new SignUpView();
    public ListingView listingView=new ListingView();
    public NavigationDrawerView navigationDrawerView=new NavigationDrawerView();
    public MyAccountView myAccountView=new MyAccountView();
    public MyProfilView myProfilView=new MyProfilView();
    public SignUpClient signUpClient = new SignUpClient();
    public SignInClient signInClient = new SignInClient();
    public AdInsertClient adInsertClient = new AdInsertClient();

    @Override
    public void forceStop() {
        Android.adb.forceStopApp(packageID());
    }

    @Override
    public void clearData() {
        Android.adb.clearAppsData(packageID());
    }

    @Override
    public Object open() {
        MyLogger.log.info("Open The application");
        Android.adb.openAppsActivity(packageID(), mainActivityID());
        return null;
    }

    public Object close() {
        Android.adb.redirectToHome();
        return null;
    }

    @Override
    public String packageID() {
        return "se.scmv.morocco";
    }

    @Override
    public String mainActivityID() {
        return "se.scmv.morocco.activities.MainActivity";
    }

    public String signInActivityID() {
        return "se.scmv.morocco.activities.LoginActivity";
    }
}