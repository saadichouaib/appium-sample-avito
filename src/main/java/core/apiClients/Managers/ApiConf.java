package core.apiClients.Managers;

import core.MyLogger;
import okhttp3.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ApiConf {
    private static MediaType JSON = MediaType.parse("application/json");
    public static String responseBody ="";
    public static int responseCode;
    private static OkHttpClient client = new OkHttpClient.Builder()
            .connectTimeout(20, TimeUnit.SECONDS)
            .writeTimeout(20, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build();

    public static void getRequest(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        //Response response = client.newCall(request).execute();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (!response.isSuccessful()) throw new IOException("Unexpected code " + response.body().string());
                else {
                    responseBody = response.body().string();
                    responseCode = response.code();
                    MyLogger.log.info("Response body: " + responseBody);
                    MyLogger.log.info("Response code: " + responseCode);
                }
            }
        });
    }

    public static void postRequest(String url, String jsonBody, String token){
        RequestBody body = RequestBody.create(JSON, jsonBody);
        Request request = new Request.Builder()
                .url(url)
                .header("x-token","Bearer "+token)
                .addHeader("Accept","application/json")
                .addHeader("Content-Type","application/json")
                .post(body)
                .build();

        MyLogger.log.info("url: " + url);
        MyLogger.log.info("Body: " + jsonBody);

        //Response response = client.newCall(request).execute();

        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (!response.isSuccessful()){
                    throw new IOException("Unexpected code " + response.body().string());
                }
                responseBody = response.body().string();
                responseCode = response.code();
                MyLogger.log.info("Response body: " + responseBody);
                MyLogger.log.info("Response code: " + responseCode);
            }
        });
    }

    public static void postRequest(String url, String jsonBody){
        RequestBody body = RequestBody.create(JSON, jsonBody);
        Request request = new Request.Builder()
                .url(url)
                .header("Accept","application/json")
                .addHeader("Content-Type","application/json")
                .post(body)
                .build();

        MyLogger.log.info("POST body: "+jsonBody);
        MyLogger.log.info("Endpoint: "+url);

        //Response response = client.newCall(request).execute();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (!response.isSuccessful()){
                    throw new IOException("Unexpected code " + response.body().string());
                }
                responseBody = response.body().string();
                responseCode = response.code();
                MyLogger.log.info("Response body: " + responseBody);
                MyLogger.log.info("Response code: " + responseCode);
            }
        });

    }
}