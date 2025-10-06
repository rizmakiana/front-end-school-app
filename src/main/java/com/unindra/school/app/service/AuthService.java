/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unindra.school.app.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.unindra.school.app.model.LoginRequest;
import com.unindra.school.app.entity.StaffResponse;
import com.unindra.school.app.model.TokenResponse;
import com.unindra.school.app.model.WebResponse;
import com.unindra.school.app.util.AppManager;
import java.io.IOException;
import java.util.Map;
import javax.imageio.IIOException;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

/**
 *
 * @author rizmakiana
 */
public class AuthService {
    
    private final ObjectMapper om = new ObjectMapper();
    private final OkHttpClient client = new OkHttpClient();
    
    public String loginStaff(LoginRequest request) throws IOException {
        String jsonRequest = om.writeValueAsString(request);

        RequestBody requestBody = RequestBody.create(jsonRequest, MediaType.parse("application/json"));
        Request requestHttp = new Request.Builder()
                .url(AppManager.getWebName() + "/api/auth/login")
                .header("Accept-Language", AppManager.getLocale().toLanguageTag())
                .post(requestBody)
                .build();

        try (Response response = client.newCall(requestHttp).execute()) {

            String jsonResponse = response.body().string();

            WebResponse<TokenResponse> webResponse = om.readValue(
                    jsonResponse, new TypeReference<WebResponse<TokenResponse>>() {}
            );

            Object errors = webResponse.getErrors();
            if (errors != null) {
                if (errors instanceof Map) {
                    Map<String, String> map = (Map<String, String>) errors;
                    String firstError = map.values().stream().findFirst().orElse("Unknown error");
                    throw new IOException(firstError);
                }
                if (errors instanceof String) {
                    throw new IOException((String) errors);
                }
                throw new IOException(errors.toString()); // fallback
            }

            TokenResponse tokenResponse = webResponse.getData();
            if (tokenResponse == null) {
                throw new IOException("Login gagal: tidak ada token dari server");
            }

            AppManager.setToken(tokenResponse); // simpan ke AppManager
            return webResponse.getMessage();
        }
    }

    public StaffResponse getCurrentStaff() throws IOException {
        om.registerModule(new JavaTimeModule());
        Request httpRequest = new Request.Builder()
                .url(AppManager.getWebName() + "/api/staff/me")
                .addHeader("Authorization", "Bearer " + AppManager.getToken().getToken())
                .header("Accept-Language", AppManager.getLocale().toLanguageTag())
                .get()
                .build();

        try (Response response = client.newCall(httpRequest).execute()) {
            
            String jsonResponse = response.body().string();
            WebResponse<StaffResponse> webResponse = om.readValue(
                    jsonResponse, new TypeReference<WebResponse<StaffResponse>>() {}
            );
            
            if (webResponse.getErrors() != null){
                throw new IIOException("");
            }

            return webResponse.getData();
        }
    }

}
