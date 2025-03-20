package com.example.wazmaali.controller;

import android.util.Log;

import com.example.wazmaali.model.ListItems;
import com.example.wazmaali.services.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListItemController {
    private static final String BASE_URL = "https://fetch-hiring.s3.amazonaws.com";

    public interface ListItemsCallback {
        void onItemsFetched(List<ListItems> listItems);
        void onError(String error);
    }

    private ApiService apiService;

    public ListItemController() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofit.create(ApiService.class);
    }

    public void getListItems(final ListItemsCallback callback) {
        apiService.getListItems().enqueue(new Callback<List<ListItems>>() {
            @Override
            public void onResponse(Call<List<ListItems>> call, Response<List<ListItems>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    callback.onItemsFetched(response.body());
                    Log.d("TAG", "This is a debug message: ");
                    Log.d("TAG", "response.body()"+response.body());

                } else {
                    callback.onError("Failed to fetch data.");
                }
            }

            @Override
            public void onFailure(Call<List<ListItems>> call, Throwable t) {
                callback.onError("Error: " + t.getMessage());
            }
        });
    }
}
