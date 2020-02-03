package core;

import api.android.Android;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;

public class Screenshot {

    public static boolean takeScreenshot(final String name) {
        File screenshotDirectory=new File("./screenshots");
        File screenshot = ((TakesScreenshot) Android.driver).getScreenshotAs(OutputType.FILE);
        MyLogger.log.info("Dir screenshot taken");
        return screenshot.renameTo(new File(screenshotDirectory, String.format("%s.png", name)));
    }

    @Attachment(value = "{0}", type = "image/png")
    public static byte[] takeScreenshotAllure(String imageTitle) {
        MyLogger.log.info("Allure screenshot taken");
        MyLogger.log.info(((TakesScreenshot) Android.driver).getScreenshotAs(OutputType.BYTES));
        return ((TakesScreenshot) Android.driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "Log", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }

    public static void deleteScreenshots(){
        File index = new File("./screenshots");
        String[]entries = index.list();
        for(String s: entries){
            File currentFile = new File(index.getPath(),s);
            currentFile.delete();
        }
    }
}