/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sampcli.pipefy;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import java.io.IOException;
import com.google.gson.Gson;
import com.squareup.okhttp.ResponseBody;

/**
 *
 * @author jambi
 */
public class IntegracaoPipefy {

    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\"query\":\"{allCards(pipeId: 302763672) {edges {node {id title age}}}}\"}");
        Request request = new Request.Builder()
                .url("https://api.pipefy.com/graphql")
                .post(body)
                .addHeader("accept", "application/json")
                .addHeader("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJ1c2VyIjp7ImlkIjozMDIwODY5MjUsImVtYWlsIjoiam9hby5jb25jZWljYW9Ac3B0ZWNoLnNjaG9vbCIsImFwcGxpY2F0aW9uIjozMDAyMDc0NzZ9fQ.SRZx-58-x8HKCSTanwLU7MzGVoenpQwrmFpDppWzJduSo8NDJKtAw65ECGCGWEOO_1SJ65LnacQmgQ0aEIunXA")
                .addHeader("Content-Type", "application/json")
                .build();

        ResponseBody response = client.newCall(request).execute().body();
        Gson gson = new Gson();

        String jsonString = response.string();

        ResponsePipefy resposta = gson.fromJson(jsonString, ResponsePipefy.class);

        System.out.println(resposta.getData().getAllCards().getEdges().get(0).getNode().getTitle());

    }
}
