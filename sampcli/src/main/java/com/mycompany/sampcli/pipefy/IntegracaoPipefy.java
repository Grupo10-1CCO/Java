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
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;

/**
 *
 * @author jambi
 */
public class IntegracaoPipefy {

    public static Boolean verificarCard(String nomeComponente, String serial, Integer metrica) throws IOException {
        Boolean hasCard = false;
        
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
        
        Integer tamanhoLista = resposta.getData().getAllCards().getEdges().size();
        
        for(Integer i = 0; i < tamanhoLista; i++){
            Edges card = resposta.getData().getAllCards().getEdges().get(i);
            String titulo = String.format("A %s da maquina de serial %s está acima de %d.0%%!", nomeComponente, serial, metrica);            
            String titulo2 = String.format("A %s da maquina de serial %s está abaixo de %d.0%%!", nomeComponente, serial, metrica);

            if(card.getNode().getAge() < 86400 && (card.getNode().getTitle().equalsIgnoreCase(titulo) || card.getNode().getTitle().equalsIgnoreCase(titulo2))){
                hasCard = true;
            }
        }
        

        return hasCard;
    }
    
    public static void inserirCard(String nomeComponente, String serial, Integer metrica, Double registro) throws IOException {
        OkHttpClient client = new OkHttpClient();
        
        String problema = "";
        
        if(registro > metrica){
            problema = String.format("A %s da maquina de serial %s está acima de %d.0%%!", nomeComponente, serial, metrica);
        }else if(registro < metrica){
            problema = String.format("A %s da maquina de serial %s está abaixo de %d.0%%!", nomeComponente, serial, metrica);
        }else{
            
        }
        String descricaoProblema = String.format("A %s da máquina de serial %s atingiu um uso de %.2f. Valor fora do limite estabelecido de %d.0", nomeComponente, serial, registro, metrica);
        
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, String.format("{\"query\":\"mutation{createCard(input: {pipe_id:302763672, title: \\\"TITULO TESTE JAVA\\\", fields_attributes: [{field_id: \\\"qual_o_serial_da_m_quina\\\", field_value: \\\"%s\\\"} {field_id: \\\"qual_o_componente_afetado\\\", field_value: \\\"%s\\\"}{field_id: \\\"problema\\\", field_value: \\\"%s\\\"}{field_id: \\\"mais_informa_es\\\", field_value: \\\"%s\\\"}]}){card {title}}}\"}", serial, nomeComponente, problema, descricaoProblema));
        Request request = new Request.Builder()
                .url("https://api.pipefy.com/graphql")
                .post(body)
                .addHeader("accept", "application/json")
                .addHeader("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJ1c2VyIjp7ImlkIjozMDIwODY5MjUsImVtYWlsIjoiam9hby5jb25jZWljYW9Ac3B0ZWNoLnNjaG9vbCIsImFwcGxpY2F0aW9uIjozMDAyMDc0NzZ9fQ.SRZx-58-x8HKCSTanwLU7MzGVoenpQwrmFpDppWzJduSo8NDJKtAw65ECGCGWEOO_1SJ65LnacQmgQ0aEIunXA")
                .addHeader("Content-Type", "application/json")
                .build();
        
        Response response = client.newCall(request).execute();
        
        System.out.println(response);
        
    }
    
}
