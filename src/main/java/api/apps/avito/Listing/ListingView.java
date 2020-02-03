package api.apps.avito.Listing;

import api.android.Android;
import api.interfaces.Activity;
import core.Utils;
import core.MyLogger;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;

public class ListingView implements Activity {
    public ListingUiObjects uiObject=new ListingUiObjects();

    @Step("Favourite an ad")
    public void favouriteAd(){
        try {
            while(uiObject.favouriteBtn().isSelected()){
                new Utils().scrollDownManually();
            }

            MyLogger.log.info("Favourite the first ad:"+uiObject.adTitle().getText());
            uiObject.favouriteBtn().tap();
        } catch (NoSuchElementException e) {
            throw new AssertionError("cannot favourite ad ad");
        }
    }

    @Step("Renouveler ad")
    public void renewAd(){
        try {
            MyLogger.log.info("Renew this Ad");

            MyLogger.log.info("Tap ad menu");
            uiObject.adMenuBtn().waitToAppear(10).tap();

            MyLogger.log.info("choose Renouveler from the list");
            uiObject.adRenewBtn().waitToAppear(10).tap();
        } catch (NoSuchElementException e) {
            throw new AssertionError("cannot redirect to RenewView");
        }
    }

    @Step("get data from Listing")
    public void getAdData(){
        try {
            MyLogger.log.info("get data from home view");
            Android.app.avito.homeData.adTitle=uiObject.adTitle().waitToAppear(20).getText();
            Android.app.avito.homeData.adLocation=uiObject.adLocation().waitToAppear(20).getText();
            Android.app.avito.homeData.adTime=uiObject.adDateTime().waitToAppear(20).getText();

            if(uiObject.adPrice().exists()){
                if(uiObject.adPrice().getText().contains("Prix non spécifié")){
                    Android.app.avito.homeData.adPrice="-1";
                }
                else{
                    Android.app.avito.homeData.adPrice=uiObject.adPrice().getText();
                }
            }
            else{
                Android.app.avito.homeData.adPrice="-1";
            }

            MyLogger.log.info("subject: "+Android.app.avito.homeData.adTitle);
            MyLogger.log.info("location: "+Android.app.avito.homeData.adLocation);
            MyLogger.log.info("time: "+Android.app.avito.homeData.adTime);
            MyLogger.log.info("price: "+Android.app.avito.homeData.adPrice);
        } catch (NoSuchElementException e) {
            throw new AssertionError("cannot get data from listing");
        }
    }

    @Step("Tap on ad from Listing")
    public void tapOnAd(){
        try {
            uiObject.adImage().tap();
        } catch (NoSuchElementException e) {
            throw new AssertionError("cannot tap ad from listing");
        }
    }

    @Step("Share ad from my Ads")
    public void shareAd(){
        try {
            MyLogger.log.info("Share Ad from listing view");

            MyLogger.log.info("Tap ad menu");
            uiObject.adMenuBtn().waitToAppear(10).tap();

            MyLogger.log.info("choose Partager from the list");
            uiObject.adSharing().waitToAppear(10).tap();

            MyLogger.log.info("waiting for share popup to appear");
            uiObject.adSharePopup().waitToAppear(10);

            if(uiObject.adSharePopup().exists()){
                Android.driver.navigate().back();
                MyLogger.log.info("waiting for share popup to disappear");
                uiObject.adSharePopup().waitToDisappear(10);
            }

        } catch (NoSuchElementException e) {
            throw new AssertionError("there is an error with sharing");
        }
    }

    @Step("Waiting for Listing to load all the elements")
    @Override
    public ListingView waitToLoad() {
        try {
            MyLogger.log.info("Waiting for Listing to load all the elements");
            uiObject.adImage().waitToAppear(60);
            uiObject.galleryView().waitToAppear(30);
            return Android.app.avito.listingView;
        } catch (NoSuchElementException e) {
            throw new AssertionError("Listing failed to load/open");
        }
    }
}