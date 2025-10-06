package com.unindra.school.app.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.unindra.school.app.model.RegisterStaffRequest;
import com.unindra.school.app.model.WebResponse;
import com.unindra.school.app.util.AppManager;
import java.io.IOException;
import java.util.HashMap;
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
public class StaffService {
    
    private final ObjectMapper om = new ObjectMapper();
    private final OkHttpClient client = new OkHttpClient();
    
    public String register(RegisterStaffRequest request) throws IOException {
        String json = om.writeValueAsString(request);

        RequestBody requestBody = RequestBody.create(json, MediaType.parse("application/json"));
        Request requestHttp = new Request.Builder()
                .url(AppManager.getWebName() + "/api/staff")
                .header("Accept-Language", AppManager.getLocale().toLanguageTag())
                .post(requestBody)
                .build();

        try (Response response = client.newCall(requestHttp).execute()) {

            String jsonResponse = response.body().string(); // convert response ke string
            WebResponse<?> responseBody = om.readValue(jsonResponse, WebResponse.class);

            Object errors = responseBody.getErrors();
            if (errors != null) {
                String errorMessage;

                if (errors instanceof Map<?, ?> map) {
                    // ambil error pertama aja
                    errorMessage = map.values().stream()
                            .findFirst()
                            .map(Object::toString)
                            .orElse("Unknown error");
                } else {
                    // fallback String atau tipe lain
                    errorMessage = errors.toString();
                }

                throw new IOException(errorMessage);
            }

            return responseBody.getMessage();
        }
    }
}
