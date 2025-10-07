/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unindra.school.app.service;

import com.unindra.school.app.model.request.CourseRequest;
import com.unindra.school.app.model.response.CourseResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.unindra.school.app.model.request.CourseUpdateRequest;
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

/**
 *
 * @author rizmakiana
 */
public class CourseService {
    
    private final ObjectMapper om = new ObjectMapper();
    private final OkHttpClient client = new OkHttpClient();
    
    public String add(CourseRequest request) throws IOException{
        String jsonRequest = om.writeValueAsString(request);
                
        RequestBody requestBody = RequestBody.create(jsonRequest, MediaType.parse("application/json"));
        Request httpRequest = new Request.Builder()
                .url(AppManager.getWebName() + "/api/staff/courses")
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
    
    public List<CourseResponse> getAll() throws IOException{
        
        Request httpRequest = new Request.Builder()
                .url(AppManager.getWebName() + "/api/staff/courses")
                .addHeader("Authorization", "Bearer " + AppManager.getToken().getToken())
                .get()
                .build();
        
        try (Response response = client.newCall(httpRequest).execute()) {
            
            String jsonResponse = response.body().string();
            WebResponse<List<CourseResponse>> webResponse = om.readValue(
                    jsonResponse, new TypeReference<WebResponse<List<CourseResponse>>>() {}
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
    
    public CourseResponse getByCode(String code) throws IOException{
        Request httpRequest = new Request.Builder()
                .url(AppManager.getWebName() + "/api/staff/courses/" + code)
                .header("Accept-Language", AppManager.getLocale().toLanguageTag())
                .addHeader("Authorization", "Bearer " + AppManager.getToken().getToken())
                .get()
                .build();
        
        try (Response response = client.newCall(httpRequest).execute()) {
            
            String jsonResponse = response.body().string();
            WebResponse<CourseResponse> webResponse = om.readValue(
                    jsonResponse, new TypeReference<WebResponse<CourseResponse>>() {}
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
    
    public String update(String id, CourseUpdateRequest request) throws IOException{
        String jsonRequest = om.writeValueAsString(request);
                
        RequestBody requestBody = RequestBody.create(jsonRequest, MediaType.parse("application/json"));
        Request httpRequest = new Request.Builder()
                .url(AppManager.getWebName() + "/api/staff/courses/" + id)
                .header("Accept-Language", AppManager.getLocale().toLanguageTag())
                .addHeader("Authorization", "Bearer " + AppManager.getToken().getToken())
                .patch(requestBody)
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
    
    public String delete(String id) throws IOException{

        Request httpRequest = new Request.Builder()
                .url(AppManager.getWebName() + "/api/staff/courses/" + id)
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
