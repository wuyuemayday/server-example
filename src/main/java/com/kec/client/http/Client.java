package com.kec.client.http;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class Client {
    public static void main(String[] args) {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request req = new Request.Builder()
                .url("http://localhost:8080?name=abc")
                .build();

        try (Response resp = client.newCall(req).execute()) {
            System.out.println(resp.code());
            System.out.println(resp.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
