package com.unindra.school.app.service;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.unindra.school.app.model.request.ClassroomRequest;
import com.unindra.school.app.model.response.ClassroomResponse;
import com.unindra.school.app.model.response.WebResponse;
import com.unindra.school.app.util.AppManager;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author rizmakiana
 */
public class ClassroomService {
    
    private final ObjectMapper om = new ObjectMapper();
    private final OkHttpClient client = new OkHttpClient();
    
    public String add(ClassroomRequest request) throws IOException {
        String jsonRequest = om.writeValueAsString(request);
                
        RequestBody requestBody = RequestBody.create(jsonRequest, MediaType.parse("application/json"));
        Request httpRequest = new Request.Builder()
                .url(AppManager.getWebName() + "/api/staff/classrooms")
                .header("Accept-Language", AppManager.getLocale().toLanguageTag())
                .addHeader("Authorization", "Bearer " + AppManager.getToken().getToken())
                .post(requestBody)
                .build();
        
        try (Response response = client.newCall(httpRequest).execute()) {
            
            String jsonResponse = response.body().string();
            WebResponse<String> webResponse = om.readValue(
                    jsonResponse, new TypeReference<WebResponse<String>>() {}
            );
            
            Object errors = webResponse.getErrors();
            if (errors != null){
                String errorMessage;
                if (errors instanceof Map<?,?> map) {
                    errorMessage = map.values().stream()
                            .findFirst()
                            .map(Object::toString)
                            .orElse("Unknown error");
                } else {
                    errorMessage = errors.toString();
                }
                throw new IOException(errorMessage);
            }
            return webResponse.getMessage();
        }
    }
    
    public List<ClassroomResponse> getAll() throws IOException{
        
        Request httpRequest = new Request.Builder()
                .url(AppManager.getWebName() + "/api/staff/classrooms")
                .addHeader("Authorization", "Bearer " + AppManager.getToken().getToken())
                .get()
                .build();
        
        try (Response response = client.newCall(httpRequest).execute()) {
            
            String jsonResponse = response.body().string();
            WebResponse<List<ClassroomResponse>> webResponse = om.readValue(
                    jsonResponse, new TypeReference<WebResponse<List<ClassroomResponse>>>() {}
            );
            
            Object errors = webResponse.getErrors();
            if (errors != null){
                String errorMessage;
                if (errors instanceof Map<?,?> map) {
                    errorMessage = map.values().stream()
                            .findFirst()
                            .map(Object::toString)
                            .orElse("Unknown error");
                } else {
                    errorMessage = errors.toString();
                }
                throw new IOException(errorMessage);
            }
            return webResponse.getData();
        }
    }
    
    public ClassroomResponse getByCode(String code) throws IOException{
        Request httpRequest = new Request.Builder()
                .url(AppManager.getWebName() + "/api/staff/classrooms/" + code)
                .header("Accept-Language", AppManager.getLocale().toLanguageTag())
                .addHeader("Authorization", "Bearer " + AppManager.getToken().getToken())
                .get()
                .build();
        
        try (Response response = client.newCall(httpRequest).execute()) {
            
            String jsonResponse = response.body().string();
            WebResponse<ClassroomResponse> webResponse = om.readValue(
                    jsonResponse, new TypeReference<WebResponse<ClassroomResponse>>() {}
            );
            
            Object errors = webResponse.getErrors();
            if (errors != null){
                String errorMessage;
                if (errors instanceof Map<?,?> map) {
                    errorMessage = map.values().stream()
                            .findFirst()
                            .map(Object::toString)
                            .orElse("Unknown error");
                } else {
                    errorMessage = errors.toString();
                }
                throw new IOException(errorMessage);
            }
            return webResponse.getData();
        }
    }
    
    public String delete(String id) throws IOException{

        Request httpRequest = new Request.Builder()
                .url(AppManager.getWebName() + "/api/staff/classrooms/" + id)
                .header("Accept-Language", AppManager.getLocale().toLanguageTag())
                .addHeader("Authorization", "Bearer " + AppManager.getToken().getToken())
                .delete()
                .build();
        
        try (Response response = client.newCall(httpRequest).execute()) {
            
            String jsonResponse = response.body().string();
            WebResponse<String> webResponse = om.readValue(
                    jsonResponse, new TypeReference<WebResponse<String>>() {}
            );
            
            Object errors = webResponse.getErrors();
            if (errors != null){
                String errorMessage;
                if (errors instanceof Map<?,?> map) {
                    errorMessage = map.values().stream()
                            .findFirst()
                            .map(Object::toString)
                            .orElse("Unknown error");
                } else {
                    errorMessage = errors.toString();
                }
                throw new IOException(errorMessage);
            }
            return webResponse.getMessage();
        }
    }
}
