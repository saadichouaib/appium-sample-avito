package core.apiClients;

import api.data.SignUpData;
import com.fasterxml.jackson.databind.ObjectMapper;
import core.Utils;
import core.MyLogger;
import core.apiClients.Managers.ApiConf;
import core.constants.Global;
import io.qameta.allure.Step;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import java.io.IOException;

public class SignUpClient {
    private String HOST = Global.apiHost + "/api/v1/accounts";
    public SignUpData signUpData;
    private String signUpBody;
    private ObjectMapper mapper=new ObjectMapper();

    @Step("Sign Up")
    public void signUp(){
        try {
            signUpData = new SignUpData("chouaib",
                    Utils.randomEmail(),
                    "123456",
                    1,
                    "fr",
                    1,
                    Utils.randomPhone(),
                    2);
            signUpBody= mapper.writeValueAsString(signUpData);
            MyLogger.log.info("SignUp");
            ApiConf.postRequest(HOST,signUpBody);
            checkResponse();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public SignUpData getCredentials(SignUpData signUpData){
        JSONObject jsonObjects=(JSONObject) JSONValue.parse(ApiConf.responseBody);
        JSONObject jsonObject= (JSONObject) jsonObjects.get("account");

        MyLogger.log.info("jsonObjects: "+jsonObjects.toJSONString());
        MyLogger.log.info("jsonObject: "+jsonObject.toJSONString());

        String email=jsonObject.get("email").toString();
        String phone=jsonObject.get("phone").toString();
        signUpData.setEmail(email);
        signUpData.setPassword("123456");
        signUpData.setPhone(phone);

        MyLogger.log.info("email created: "+ signUpData.getEmail());
        MyLogger.log.info("password created: "+ signUpData.getPassword());
        MyLogger.log.info("phone created: "+ signUpData.getPhone());
        return signUpData;
    }

    public void checkResponse() throws IOException {
        try { Thread.sleep(8000); } catch (InterruptedException e) { e.printStackTrace(); }

        if(JSONValue.parse(ApiConf.responseBody)==null){
            throw new IOException("response null");
        }
    }
}