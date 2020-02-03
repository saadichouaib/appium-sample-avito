package tests.avito;

import api.android.Android;
import core.MyLogger;
import core.managers.DriverManager;
import core.listeners.TestListener;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners(TestListener.class)
@Test(description = "Loading Avito App")
public class LoadingAvitoApp {

    @Test(description = "Check if all the elements exist")
    public void CheckIfAllElementsExist(){
        Android.app.avito.open();

        Android.app.avito.homeView.waitToLoad();
        Android.app.avito.listingView.waitToLoad();

        Assert.assertTrue(Android.app.avito.homeView.uiObject.logo().exists());
        MyLogger.log.info("logo exist");

        Assert.assertTrue(Android.app.avito.homeView.uiObject.filters().exists());
        MyLogger.log.info("filter exist");

        Assert.assertTrue(Android.app.avito.homeView.uiObject.menuNavigation().exists());
        MyLogger.log.info("Navigation Drawer Menu exist");

        Assert.assertTrue(Android.app.avito.listingView.uiObject.adImage().exists());
        MyLogger.log.info("ads listing exist");

        Assert.assertTrue(Android.app.avito.listingView.uiObject.galleryView().exists());
        MyLogger.log.info("GalleryView exist");

    }
}