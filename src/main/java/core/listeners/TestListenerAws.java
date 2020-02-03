package core.listeners;

import api.android.Android;
import core.MyLogger;
import core.managers.DriverManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListenerAws implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
    }

    @Override
    public void onTestSuccess(ITestResult result) {
    }

    @Override
    public void onTestFailure(ITestResult result) {

        //Screenshot.takeScreenshotAllure(composeTestName(result));

        MyLogger.log.error("Listener: An Error Is Occured ... trying to resume the test suite");

        if(Android.adb.getForegroundActivity().contains("se.scmv.morocco")){
            DriverManager.killDriver();
            DriverManager.createAwsAvitoDriver();
            try { Thread.sleep(5000); } catch (InterruptedException e) { e.printStackTrace(); }
            Android.app.avito.listingView.waitToLoad();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {
    }

    @Override
    public void onFinish(ITestContext context) {
        MyLogger.log.info("Closing the app");
        DriverManager.killDriver();
    }

    private String composeTestName(ITestResult iTestResult) {
        StringBuffer completeFileName = new StringBuffer();

        completeFileName.append(iTestResult.getTestClass().getRealClass().getSimpleName());
        completeFileName.append("_");
        completeFileName.append(iTestResult.getName());

        return completeFileName.toString();
    }
}