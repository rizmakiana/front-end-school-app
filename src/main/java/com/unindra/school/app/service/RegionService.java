/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unindra.school.app.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.unindra.school.app.model.response.RegionResponse;
import com.unindra.school.app.model.response.WebResponse;
import com.unindra.school.app.util.AppManager;
import java.io.IOException;
import java.util.List;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 *
 * @author rizmakiana
 */
public class RegionService {
    
    private final OkHttpClient client = new OkHttpClient();
    private final ObjectMapper mapper = new ObjectMapper();
    
    // Helper untuk parsing WebResponse<List<RegionResponse>>
    private List<RegionResponse> fetchRegionList(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("HTTP error: " + response.code());
            }

            WebResponse<List<RegionResponse>> respObj = mapper.readValue(
                    response.body().string(),
                    mapper.getTypeFactory().constructParametricType(
                            WebResponse.class,
                            mapper.getTypeFactory().constructCollectionType(List.class, RegionResponse.class)
                    )
            );

            if (respObj.getErrors() != null) {
                throw new RuntimeException();
            }

            return respObj.getData();
        }
    }

    // Ambil semua provinsi
    public List<RegionResponse> getProvinces() throws IOException {
        String url = AppManager.getWebName() + "/api/region/provinces";
        return fetchRegionList(url);
    }

    // Ambil semua kabupaten/kota berdasarkan provinceId
    public List<RegionResponse> getRegencies(String provinceId) throws IOException {
        String url = AppManager.getWebName() + "/api/region/regencies?provinceId=" + provinceId;
        return fetchRegionList(url);
    }

    // Ambil semua kecamatan berdasarkan regencyId
    public List<RegionResponse> getDistricts(String regencyId) throws IOException {
        String url = AppManager.getWebName() + "/api/region/districts?regencyId=" + regencyId;
        return fetchRegionList(url);
    }
    
}
