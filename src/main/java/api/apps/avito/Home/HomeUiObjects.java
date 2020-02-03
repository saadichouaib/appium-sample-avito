package api.apps.avito.Home;

import api.android.Android;
import core.UiObject;
import core.UiSelector;

public class HomeUiObjects {
    private static UiObject
//Header
    logo,
    filters,
    menuNavigation,
//Control bar
    categoryTitleControlBar,
    cityTitleControlBar,
    saveSearchBtn,

//Bottom navigation tabs
    myAccountBottomTab,
    listingBottomTab,
    messagingBottomTab,
    notificationBottomTab,
    fabBtn,
    frenchBtn,
    arabicBtn,
    marketingOnBoarding,
        marketingOnBoardingSuivantBtn,
        marketingOnBoardingFermerBtn

    ;

    public UiObject marketingOnBoarding(){
        if(marketingOnBoarding == null) marketingOnBoarding = new UiSelector().resourceId(Android.app.avito.packageID()+":id/com_appboy_inappmessage_html_full").makeUiObject();
        return marketingOnBoarding;
    }

    public UiObject marketingOnBoardingSuivantBtn(){
        if(marketingOnBoardingSuivantBtn == null) marketingOnBoardingSuivantBtn = new UiSelector().textContains("SUIVANT").makeUiObject();
        return marketingOnBoardingSuivantBtn;
    }

    public UiObject marketingOnBoardingFermerBtn(){
        if(marketingOnBoardingFermerBtn == null) marketingOnBoardingFermerBtn = new UiSelector().textContains("FERMER").makeUiObject();
        return marketingOnBoardingFermerBtn;
    }

    public UiObject fabBtn(){
        if(fabBtn == null) fabBtn = new UiSelector().resourceId(Android.app.avito.packageID()+":id/itemNavigationSell").makeUiObject();
        return fabBtn;
    }

    public UiObject frenchBtn(){
        if(frenchBtn == null) frenchBtn = new UiSelector().text("FRANÇAIS").makeUiObject();
        return frenchBtn;
    }

    public UiObject arabicBtn(){
        if(arabicBtn == null) arabicBtn = new UiSelector().resourceId(Android.app.avito.packageID()+":id/").makeUiObject();
        return arabicBtn;
    }

    public UiObject logo(){
        if(logo == null) logo = new UiSelector().resourceId(Android.app.avito.packageID()+":id/toolbar").makeUiObject();
        return logo;
    }

    public UiObject categoryTitleControlBar(){
        if(categoryTitleControlBar == null) categoryTitleControlBar = new UiSelector().resourceId(Android.app.avito.packageID()+":id/category_title_control_bar").makeUiObject();
        return categoryTitleControlBar;
    }

    public UiObject cityTitleControlBar(){
        if(cityTitleControlBar == null) cityTitleControlBar = new UiSelector().resourceId(Android.app.avito.packageID()+":id/city_title_control_bar").makeUiObject();
        return cityTitleControlBar;
    }

    public UiObject filters(){
        if(filters == null) filters = new UiSelector().resourceId(Android.app.avito.packageID()+":id/action_filters").makeUiObject();
        return filters;
    }

    public UiObject myAccountBottomTab(){
        if(myAccountBottomTab == null) myAccountBottomTab = new UiSelector().resourceId(Android.app.avito.packageID()+":id/itemNavigationProfile").makeUiObject();
        return myAccountBottomTab;
    }

    public UiObject messagingBottomTab(){
        if(messagingBottomTab == null) messagingBottomTab = new UiSelector().resourceId(Android.app.avito.packageID()+":id/itemNavigationMessage").makeUiObject();
        return messagingBottomTab;
    }

    public UiObject notificationBottomTab(){
        if(notificationBottomTab == null) notificationBottomTab = new UiSelector().resourceId(Android.app.avito.packageID()+":id/itemNavigationNotification").makeUiObject();
        return notificationBottomTab;
    }

    public UiObject listingBottomTab(){
        if(listingBottomTab == null) listingBottomTab = new UiSelector().resourceId(Android.app.avito.packageID()+":id/itemNavigationHome").makeUiObject();
        return listingBottomTab;
    }

    public UiObject saveSearchBtn(){
        if(saveSearchBtn == null) saveSearchBtn = new UiSelector().resourceId(Android.app.avito.packageID()+":id/switch_rating_btn").makeUiObject();
        return saveSearchBtn;
    }


    public UiObject menuNavigation(){
        if(menuNavigation == null) menuNavigation = new UiSelector().className("android.widget.ImageButton").makeUiObject();
        return menuNavigation;
    }
}