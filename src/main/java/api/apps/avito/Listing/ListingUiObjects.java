package api.apps.avito.Listing;

import api.android.Android;
import core.UiObject;
import core.UiSelector;

public class ListingUiObjects {

    private static UiObject

            //Ads
    adImage,
    adTitle,
    adLocation,
    adDateTime,
    adPrice,
    adMenuBtn,
    adRenew,
    adSharing,
    favoriteBtn,
    listingView,
    galleryView,
    adSharePopup

    ;

    public UiObject galleryView(){
        if(galleryView == null) galleryView = new UiSelector().resourceId(Android.app.avito.packageID()+":id/vas_gallery_view").makeUiObject();
        return galleryView;
    }

    public UiObject adImage(){
        if(adImage == null) adImage = new UiSelector().resourceId(Android.app.avito.packageID()+":id/ad_thumb_view").makeUiObject();
        return adImage;
    }

    public UiObject adPrice(){
        if(adPrice == null) adPrice = new UiSelector().resourceId(Android.app.avito.packageID()+":id/ad_price_view").makeUiObject();
        return adPrice;
    }

    public UiObject adDateTime(){
        if(adDateTime == null) adDateTime = new UiSelector().resourceId(Android.app.avito.packageID()+":id/ad_date_view").makeUiObject();
        return adDateTime;
    }

    public UiObject adMenuBtn(){
        if(adMenuBtn == null) adMenuBtn = new UiSelector().resourceId(Android.app.avito.packageID()+":id/ad_menu_button").makeUiObject();
        return adMenuBtn;
    }

    public UiObject adLocation(){
        if(adLocation == null) adLocation = new UiSelector().resourceId(Android.app.avito.packageID()+":id/ad_location_view").makeUiObject();
        return adLocation;
    }

    public UiObject adTitle(){
        if(adTitle == null) adTitle = new UiSelector().resourceId(Android.app.avito.packageID()+":id/ad_title_view").makeUiObject();
        return adTitle;
    }

    public UiObject favouriteBtn(){
        if(favoriteBtn == null) favoriteBtn = new UiSelector().resourceId(Android.app.avito.packageID()+":id/favorite_btn").makeUiObject();
        return favoriteBtn;
    }

    public UiObject listingView(){
        if(listingView == null) listingView = new UiSelector().resourceId(Android.app.avito.packageID()+":id/listing_view").makeUiObject();
        return listingView;
    }

    public UiObject adRenewBtn(){
        if(adRenew == null) adRenew = new UiSelector().text("Renouveler").makeUiObject();
        return adRenew;
    }

    public UiObject adSharing(){
        if(adSharing == null) adSharing = new UiSelector().text("Partager").makeUiObject();
        return adSharing;
    }

    public UiObject adSharePopup(){
        if(adSharePopup == null) adSharePopup = new UiSelector().textContains("Partager sur").makeUiObject();
        return adSharePopup;
    }
}
