package core.apiClients;

import api.data.SignInData;
import api.data.SignUpData;
import com.fasterxml.jackson.databind.ObjectMapper;
import core.MyLogger;
import core.apiClients.Managers.ApiConf;
import core.constants.Global;
import io.qameta.allure.Step;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.testng.Assert;

import java.io.IOException;

public class SignInClient {
    private String HOST = Global.apiHost + "/api/v1/auth/token";
    private String loginBody;
    public SignInData signInData;
    public SignUpClient signUpClient;
    private SignUpData signUpData;
    private ObjectMapper mapper=new ObjectMapper();
    String token,accountId;

    @Step("signIn")
    public SignInData signIn(){
        try {
            signUpData = new SignUpData();
            signUpClient=new SignUpClient();

            signUpData=signUpClient.getCredentials(signUpData);

            signInData=new SignInData(signUpData.getEmail(),signUpData.getPassword(),0);

            loginBody=mapper.writeValueAsString(signInData);
            MyLogger.log.info("signIn");
            ApiConf.postRequest(HOST,loginBody);
            //checkResponse();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return signInData;
    }

    public void checkResponse(){
        try { Thread.sleep(8000); } catch (InterruptedException e) { e.printStackTrace(); }
        JSONObject jsonObject=(JSONObject) JSONValue.parse(ApiConf.responseBody);
        MyLogger.log.info("response: "+ApiConf.responseBody);
        String code=jsonObject.get("tokenType").toString();
        MyLogger.log.info("code: "+code);
        Assert.assertEquals(code,"201");
    }
    //Extract token from response and store it
    public String getToken(){

        try { Thread.sleep(8000); } catch (InterruptedException e) { e.printStackTrace(); }
        JSONObject jsonObject=(JSONObject) JSONValue.parse(ApiConf.responseBody);
        if(jsonObject.containsKey("x-token")){
            token=jsonObject.get("x-token").toString();
            MyLogger.log.info("token: "+token);
        }
        return token;
    }

    public String getAccountId(){
        JSONObject jsonObject=(JSONObject) JSONValue.parse(ApiConf.responseBody);
        if(jsonObject.containsKey("accountId")){
            accountId=jsonObject.get("accountId").toString();
            MyLogger.log.info("accountID: "+accountId);
        }
        return accountId;
    }
}