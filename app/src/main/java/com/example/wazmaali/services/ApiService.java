package com.example.wazmaali.services;

import com.example.wazmaali.model.ListItems;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("hiring.json")
    Call<List<ListItems>> getListItems();
}
