package core.apiClients;

import api.android.Android;

import api.data.AdInsertData.AdInsertBase;
import com.fasterxml.jackson.databind.ObjectMapper;
import core.MyLogger;
import core.apiClients.Managers.ApiConf;
import core.constants.Global;
import io.qameta.allure.Step;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.testng.Assert;

import java.io.IOException;


public class AdInsertClient {
    private String HOST;
    private String token="",accountId="";
    private String aIPhoneBody;
    private SignInClient signInClient;
    private ObjectMapper mapper=new ObjectMapper();
    private AdInsertBase adInsertBase;

    @Step("insert Phone Ad")
    public void insertPhoneAd(){
        try{
            adInsertBase=new AdInsertBase("s",
                    5010,
                    Android.app.avito.utils.randomText(8),
                    Android.app.avito.utils.randomText(20),
                    5,
                    Android.app.avito.utils.randomPhone(),
                    0,
                    "Omar",
                    1,
                    "fr");
            signInClient = new SignInClient();
            if(token=="") token=signInClient.getToken();
            if(accountId=="") accountId=signInClient.getAccountId();
            HOST = Global.apiHost + "/api/v1/accounts/"+accountId+"/ads";
            aIPhoneBody=mapper.writeValueAsString(adInsertBase);
            ApiConf.postRequest(HOST,aIPhoneBody,token);
            Thread.sleep(4000);
            checkResponse();
        } catch (
        IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void checkResponse(){
        try { Thread.sleep(8000); } catch (InterruptedException e) { e.printStackTrace(); }
        JSONObject jsonObject=(JSONObject) JSONValue.parse(ApiConf.responseBody);
        MyLogger.log.info("response: "+ApiConf.responseBody);
        String code=jsonObject.get("code").toString();
        MyLogger.log.info("code: "+code);
        Assert.assertEquals(code,"201");
    }
}